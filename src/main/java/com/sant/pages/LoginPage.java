package com.sant.pages;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import java.time.Duration;
import io.cucumber.java.en.*;

public class LoginPage {
    WebDriver driver;

    private By un = By.id("user-name");
    private By pw = By.id("password");
    private By login = By.id("login-button");
    private By err = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(un).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(pw).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public LandingPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new LandingPage(driver);
    }

    public String sendErrMsg() {
        return driver.findElement(err).getText();
    }
}
