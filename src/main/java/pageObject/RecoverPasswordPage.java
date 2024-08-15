package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    private final WebDriver driver;

    public RecoverPasswordPage (WebDriver driver){
        this.driver = driver;
    }

    //Поле для ввода email
    private final By inputEmailRecover = By.xpath(".//fieldset/div/div/input");

    //Кнопка "Восстановить"
    private final By recoverButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//a[@href='/login']");

    public void recoverPassword(String email){
        driver.findElement(inputEmailRecover).sendKeys(email);

        driver.findElement(recoverButton).click();
    }

    //Клик по кнопке "Войти" на странице восстановления пароля
    public void clickLoginRecoverPasswordPage(){
        driver.findElement(loginButton).click();
    }
}
