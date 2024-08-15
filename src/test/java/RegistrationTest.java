import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

import static pageObject.CONSTANT.URL_REGISTRATION_PAGE;

@RunWith(Parameterized.class)
public class RegistrationTest {

    private WebDriver driver;
    String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
    String passwordCorrect = RandomStringUtils.randomAlphabetic(8);
    String name = RandomStringUtils.randomAlphabetic(8);
    String passwordIncorrect = RandomStringUtils.randomAlphabetic(5);
    private String browserName;

    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] driverSettings() {
        return new Object[][] {
                {"chrome"},
                {"yandex"}
        };
    }
    public RegistrationTest(String browserName) {
        this.browserName = browserName;
    }

    @Before
    public void setUp() {
        driver = Browser.getWebDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL_REGISTRATION_PAGE);

    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Позитивная проверка")
    public void testRegistrationOk() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        registrationPage.registration(email, passwordCorrect, name);
        loginPage.isVisible();

    }

    @Test
    @DisplayName("Ошибку для некорректного пароля. Минимальный пароль — шесть символов")
    @Description("Негативная проверка")
    public void testRegistrationWithIncorrectPassword() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.registration(email, passwordIncorrect, name);
        registrationPage.isVisible();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
