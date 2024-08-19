package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage (WebDriver driver){
        this.driver = driver;
    }

    //Поле для ввода имени
    private final By inputNameSignUp = By.xpath(".//fieldset/div/div/input[@class = 'text input__textfield text_type_main-default']");

    //Поле для ввода email
    private final By inputEmailSignUp = By.xpath(".//fieldset[2]/div/div/input[@class = 'text input__textfield text_type_main-default']");

    //Поле для ввода пароля
    private final By inputPasswordSignUp = By.xpath(".//fieldset[3]/div/div/input[@class = 'text input__textfield text_type_main-default']");

    //Кнопка "Зарегистрироватсья"
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//a[@href='/login']");

    //Сообщение об ошибке о неккоректном пароле
    private final By errorMessage = By.xpath(".//p[@class='input__error text_type_main-default']");

    //заполнение полей email, имя и password и Зарегистрировватсься
    public void registration(String email, String password, String name){
        driver.findElement(inputNameSignUp).sendKeys(name);
        driver.findElement(inputEmailSignUp).sendKeys(email);
        driver.findElement(inputPasswordSignUp).sendKeys(password);

        driver.findElement(signUpButton).click();
    }

    //Кнопка "Войти" на странице регистрации
    public void clickLoginRegistrationPage(){
        driver.findElement(loginButton).click();
    }

    public boolean isVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }


}
