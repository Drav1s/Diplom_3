package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    //Поле для ввода email
    private final By inputEmailLogIn = By.xpath(".//input[@class='text input__textfield text_type_main-default']");

    //Поле для ввода пароля
    private final By inputPasswordLogIn = By.xpath(".//input[@type='password']");

    //"Войти" в окне входа
    private final By logIn = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //"Зарегистрироваться" в окне входа
    private final By signUp = By.xpath(".//p[@href='/register']");

    //"Восстановить пароль" в окне входа
    private final By recoverPassword = By.xpath(".//p[@href='/forgot-password']");

    //Заголовок "Вход"
    private final By headerLogin = By.xpath(".//h2");

    //заполнение полей email и password и вход
    public void login(String email, String password){
        driver.findElement(inputEmailLogIn).sendKeys(email);
        driver.findElement(inputPasswordLogIn).sendKeys(password);

        driver.findElement(logIn).click();
    }

    //Клик по "Зарегистрироваться" в окне входа
    public void clickSignUp(){
        driver.findElement(signUp).click();
    }

    //Клик по "Восстановить пароль" в окне входа
    public void clickRecoverPassword(){
        driver.findElement(recoverPassword).click();
    }

    //проверка видимости заголовка
    public boolean isVisible() {
        return driver.findElement(headerLogin).isDisplayed();
    }
}

