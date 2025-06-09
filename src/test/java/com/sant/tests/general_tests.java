package com.sant.tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import io.cucumber.java.en.*;
import com.sant.pages.LoginPage;
import com.sant.pages.LandingPage;

public class general_tests {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    @Given("the browser is safari and we've properly launched saucedemo")
    public void setup() {
        // WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    @When("we've successfully logged in and successfully checked title")
    public void testSuccessfulLogin() {
      //driver.findElement(By.id("user-name")).sendKeys("standard_user");
      //driver.findElement(By.id("password")).sendKeys("secret_sauce");
      //driver.findElement(By.id("login-button")).click();
        LandingPage landingPage = loginPage.login("standard_user", "secret_sauce");

      //WebElement productsHeader = driver.findElement(By.cssSelector(".title"));
      //Assert.assertEquals(productsHeader.getText(), "Products");
        Assert.assertEquals(landingPage.getPageHeader(), "Products");
        System.out.println("login successful!");
    }

    @Test
    @When("and we've successfully checked name of first item")
    public void testFirstProductName() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productName = driver.findElement(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals(productName.getText(), "Sauce Labs Backpack");
        System.out.println("first name correct!");
    }

    @Test
    @When("and we've successfully checked price of first item")
    public void testFirstProductPrice() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(productPrice.getText(), "$29.99");
        System.out.println("first price correct!");
    }

    @Test
    @When("and we've successfully checked name of second item")
    public void testSecondProductName() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productName = driver.findElement(By.cssSelector(" div.inventory_item:nth-of-type(2) .inventory_item_name"));
        Assert.assertEquals(productName.getText(), "Sauce Labs Bike Light");
        System.out.println("second name correct!");
    }

    @Test
    @When("and we've successfully checked price of second item")
    public void testSecondProductPrice() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productPrice = driver.findElement(By.cssSelector("div.inventory_item:nth-of-type(2) .inventory_item_price"));
        Assert.assertEquals(productPrice.getText(), "$9.99");
        System.out.println("second price correct!");
    }

    @AfterMethod
    @Then("clean up resources by shutting down safari")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
