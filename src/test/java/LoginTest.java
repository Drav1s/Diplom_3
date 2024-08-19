import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RecoverPasswordPage;
import pageObject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static pageObject.CONSTANT.*;

@RunWith(Parameterized.class)
public class LoginTest{

    private WebDriver driver;
    private String token;
    private CreateUserApi user;
    private final UserApiSteps userSteps = new UserApiSteps();
    private final UserApiPull pulls = new UserApiPull();
    String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(8);
    String name = RandomStringUtils.randomAlphabetic(8);
    private String browserName;

    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] driverSettings() {
        return new Object[][] {
                {"chrome"},
                {"yandex"}
        };
    }
    public LoginTest(String browserName) {
        this.browserName = browserName;
    }

    @Before
    @DisplayName("Создание пользователя")
    public void setUp() {
        user = new CreateUserApi(email, password, name);
        token = userSteps.createUser(user).extract().path("accessToken");

        driver = Browser.getWebDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Позитивная проверка")
    public void testLoginMainPage() {
        driver.get(URL_MAIN_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickLogInMainPage();
        loginPage.login(email, password);

        mainPage.isVisible();

    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Позитивная проверка")
    public void testLoginPersonalAccount() {
        driver.get(URL_MAIN_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);

        mainPage.isVisible();

    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Позитивная проверка")
    public void testLoginRegistrationPage() {
        driver.get(URL_REGISTRATION_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);

        registrationPage.clickLoginRegistrationPage();
        loginPage.login(email, password);

        mainPage.isVisible();

    }



    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Позитивная проверка")
    public void testLoginRecoverPasswordPage() {
        driver.get(URL_RECOVER_PASSWORD_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        MainPage mainPage = new MainPage(driver);

        recoverPasswordPage.clickLoginRecoverPasswordPage();
        loginPage.login(email, password);

        mainPage.isVisible();

    }

    @After
    @DisplayName("Удаления пользователя")
    @Description("Очистка данных")
    public void deleteUser() {
        driver.quit();

        if (token != null) {
            DeleteUserApi deleteUser = new DeleteUserApi(token);

            ValidatableResponse removalResponse = userSteps.deleteUser(deleteUser);
            pulls.checkRemoveOk(removalResponse);
        }
    }
}
