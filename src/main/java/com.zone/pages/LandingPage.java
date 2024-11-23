package com.zone.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private final Actions actions;
    private WebDriver driver;
    private static final Logger logger  = LogManager.getLogger(LandingPage.class);


    @FindBy(xpath = "//a[normalize-space()='Shop by Category']")
    public static WebElement ShopByCategory;

    @FindBy(xpath = "//span[@class='title'][contains(text(), 'MP3 Players')]")
    public static WebElement SelectMP3Player;

    @FindBy(xpath = "//img[@class='lazy-load']")
    public static WebElement menu;
    @FindBy(xpath = "//i[@class='fas fa-heart']")
    public static WebElement submenu;
    @FindBy(xpath = "//a[@class='btn btn-secondary btn-block']")
    public static WebElement Register;
    @FindBy(id="input-firstname")
    public static WebElement firstname;
    @FindBy(id="input-lastname")
    public static WebElement lastname;
    @FindBy(id="input-email")
    public static WebElement email;
    @FindBy(id="input-telephone")
    public static WebElement telephone;
    @FindBy(id="input-password")
    public static WebElement password;
    @FindBy(id="input-confirm")
    public static WebElement ConfirmPassword;
    @FindBy(xpath="//label[@for='input-agree']")
    public static WebElement Agree;
    @FindBy(xpath="//input[@class='btn btn-primary']")
    public static WebElement Continue;
    @FindBy(xpath = "//a[@class='btn btn-primary'][contains(text(), 'Continue')]")
    public static WebElement Continue2;



    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
        actions = new Actions(driver); // Initialize Actions object
    }


    //Methods for different actions
    public void clickShopByCategory(WebElement ShopByCategory) throws InterruptedException {
        ShopByCategory.click();
    }
    public void clickOnMP3Player(WebElement SelectMP3Player) throws InterruptedException {
        SelectMP3Player.click();
    }
    public void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)");
    }
    public void hoverOverMenu() {
        actions.moveToElement(menu).perform();
    }
    public void hoverAndClickSubmenu() {
        hoverOverMenu(); // Call hover method
        submenu.click(); // Click on the submenu
    }
    public void clickRegister() {
        Register.click();
    }
    public void inputFirstname(String Firstname) {
        firstname.sendKeys(Firstname);
    }
    public void inputLastname(String Lastname) {
        lastname.sendKeys(Lastname);
    }
    public void inputEmail(String Email) {
        email.sendKeys(Email);
    }
    public void inputTelephone(String phone) {
        telephone.sendKeys(phone);
    }
    public void inputPassword(String Password) {
        password.sendKeys(Password);
    }
    public void ConfirmPassword(String confirmPassword) {
        ConfirmPassword.sendKeys(confirmPassword);
    }
    public void clickAgree() {
        Agree.click();
    }
    public void clickContinue() {
        Continue.click();
    }
    public void clickContinue2() {
        Continue2.click();
    }
   }

