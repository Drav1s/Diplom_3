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
import pageObject.*;

import java.util.concurrent.TimeUnit;

import static pageObject.CONSTANT.*;

@RunWith(Parameterized.class)
public class PersonalAccountTest {

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
    public PersonalAccountTest(String browserName) {
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
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    @Description("Позитивная проверка")
    public void testPersonalAccount() {
        driver.get(URL_MAIN_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);
        mainPage.clickPersonalAccount();

        personalAccountPage.isVisible();

    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    @Description("Позитивная проверка")
    public void testExitPersonalAccount() {
        driver.get(URL_MAIN_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);
        mainPage.clickPersonalAccount();

        personalAccountPage.clickExitButton();
        loginPage.isVisible();

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Позитивная проверка")
    public void testClickDesignerButtonFromPersonalAccount() {
        driver.get(URL_MAIN_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);
        mainPage.clickPersonalAccount();
        mainPage.clickDesigner();

        mainPage.isVisible();

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на на логотип Stellar Burgers")
    @Description("Позитивная проверка")
    public void testClickStellarBurgersLogoFromPersonalAccount() {
        driver.get(URL_MAIN_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);
        mainPage.clickPersonalAccount();
        mainPage.clickStellarBurgers();

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
