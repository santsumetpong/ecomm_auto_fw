package com.sant.pages;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

public class LandingPage {
    WebDriver driver;

    private By header = By.cssSelector(".title");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeader(){
        return driver.findElement(header).getText();
    }
}
