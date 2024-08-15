import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    public static WebDriver getWebDriver(String browserName) {
        ChromeOptions options = new ChromeOptions();

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:/Users/Diplom/Diplom_3/src/main/resources/yandexdriver.exe");
                options.setBinary("C:/Users/Андрей/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                return new ChromeDriver(options);

            default:
                throw new RuntimeException("Incorrect browser");
        }
    }
}
