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
    private final By designer = By.xpath(".//li/a[@href='/']");

    //"stellar burgers" в верхней панели
    private final By logo = By.className("AppHeader_header__logo__2D0X2");

    //"Булки" в ценре
    private final By buns = By.xpath(".//span[text() = 'Булки']");

    //"Соусы" в ценре
    private final By sauces = By.xpath(".//span[text() = 'Соусы']");

    //"Начинки" в ценре
    private final By toppings= By.xpath(".//span[text() = 'Начинки']");

    //"Войти в аккаунт" в ценре
    private final By logIn = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

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

    //Соусы активны
    public boolean isSaucesSelected() {
        String getAttribute = driver.findElement(By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[2]")).getAttribute("class");
        return (getAttribute.equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }

    //Булки активны
    public boolean isBunsSelected() {
        String getAttribute = driver.findElement(By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[1]")).getAttribute("class");
        return (getAttribute.equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }

    //Начинки активны
    public boolean isToppingsSelected() {
        String getAttribute = driver.findElement(By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[3]")).getAttribute("class");
        return (getAttribute.equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    }
}
