import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.LoginPage;
import pageObject.MainPage;

import java.util.concurrent.TimeUnit;

import static pageObject.CONSTANT.URL_MAIN_PAGE;

@RunWith(Parameterized.class)
public class DesignerTest {
    private WebDriver driver;
    private String browserName;

    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] driverSettings() {
        return new Object[][] {
                {"chrome"},
                {"yandex"}
        };
    }
    public DesignerTest(String browserName) {
        this.browserName = browserName;
    }

    @Before
    public void setUp() {
        driver = Browser.getWebDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL_MAIN_PAGE);

    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу «Соусы»")
    @Description("Позитивная проверка")
    public void testCheckSauces() {
        driver.get(URL_MAIN_PAGE);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickSauces();
        mainPage.isVisibleSpicySauce();


    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу «Начинки»")
    @Description("Позитивная проверка")
    public void testCheckToppings() {
        driver.get(URL_MAIN_PAGE);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickToppings();
        mainPage.isVisibleProtostomia();

    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу «Булки»")
    @Description("Позитивная проверка")
    public void testLoginMainPage() {
        driver.get(URL_MAIN_PAGE);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickSauces();
        mainPage.clickBuns();
        mainPage.isVisibleRD();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
