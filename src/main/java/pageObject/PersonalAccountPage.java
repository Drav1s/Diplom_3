package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private final WebDriver driver;

    public PersonalAccountPage (WebDriver driver){
        this.driver = driver;
    }

    //"Выход" в личном кабинете
    private final By exitButton = By.xpath(".//ul/li[3]/button");

    //Кнопка "Профиль" в личном кабинете
    private final By accountButton = By.xpath(".//a[@href='/account/profile']");

    //Клик на кнопку "Выход" в личном кабинете
    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }

    public boolean isVisible() {
        return driver.findElement(accountButton).isDisplayed();
    }
}
