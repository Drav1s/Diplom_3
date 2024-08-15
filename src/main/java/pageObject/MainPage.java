package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    //"Личный кабинет" в верхней панели
    private final By personalAccount = By.xpath(".//a[@href='/account']");

    //"Конструктор" в верхней панели
    private final By designer = By.xpath(".//li");

    //"stellar burgers" в верхней панели
    private final By logo = By.xpath(".//div/a[@href='/']");

    //"Булки" в ценре
    private final By buns = By.xpath(".//div/div/main/section/div/div/span");

    //"Соусы" в ценре
    private final By sauces = By.xpath(".//div/div/main/section/div/div[2]/span");

    //"Начинки" в ценре
    private final By toppings= By.xpath(".//div/div/main/section/div/div[3]/span");

    //"Войти в аккаунт" в ценре
    private final By logIn = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    //Локатор соуса Spicy-x
    private final By spicySauce = By.xpath(".//a[@href = '/ingredient/61c0c5a71d1f82001bdaaa72']");

    //Локатор начинки Protostomia
    private final By protostomiaTopping = By.xpath(".//a[@href = '/ingredient/61c0c5a71d1f82001bdaaa6f']");

    //Локатор булки R2-D3
    private final By bunsRD = By.xpath(".//a[@href = '/ingredient/61c0c5a71d1f82001bdaaa6d']");

    //Клик на кнопку "Личный кабинет" в верхней панели
    public void clickPersonalAccount(){
        driver.findElement(personalAccount).click();
    }

    //Клик на кнопку "Войти в аккаунт"
    public void clickLogInMainPage(){
        driver.findElement(logIn).click();
    }

    //Клик на кнопку "Конструктор" в верхней панели
    public void clickDesigner(){
        driver.findElement(designer).click();
    }

    //Клик на кнопку "stellar burgers"  в верхней панели
    public void clickStellarBurgers(){
        driver.findElement(logo).click();
    }

    //Клик на кнопку "Булки" в ценре
    public void clickBuns(){
        driver.findElement(buns).click();
    }

    //Клик на кнопку Соусы" в ценре
    public void clickSauces(){
        driver.findElement(sauces).click();
    }

    //Клик на кнопку "Начинки" в ценре
    public void clickToppings(){
        driver.findElement(toppings).click();
    }

    //Видимость кнопки Соусы
    public boolean isVisible() {
        return driver.findElement(sauces).isDisplayed();
    }

    //Видимость соуса Spice-x
    public boolean isVisibleSpicySauce() {
        return driver.findElement(spicySauce).isDisplayed();
    }

    //Видимость начинки Protostomia
    public boolean isVisibleProtostomia() {
        return driver.findElement(protostomiaTopping).isDisplayed();
    }

    //Видимость булки R2-D3
    public boolean isVisibleRD() {
        return driver.findElement(bunsRD).isDisplayed();
    }
}
