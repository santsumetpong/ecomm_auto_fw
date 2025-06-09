package com.sant.tests;

// import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import io.cucumber.java.en.*;

public class login_test {
    WebDriver driver;

    @BeforeMethod
    @Given("the browser is safari and we've properly launched saucedemo")
    public void setup() {
        // WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    @When("we've successfully log in and successfully check title")
    public void testSuccessfulLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productsHeader = driver.findElement(By.cssSelector(".title"));
        Assert.assertEquals(productsHeader.getText(), "Products");
        System.out.println("login successful!");
    }

    @AfterMethod
    @Then("clean up resources by shutting down safari")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
