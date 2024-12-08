package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//TODO: Move Allo.ua code to TestNG
//TODO: replace [// if X > goods count -> throw exception] with Assert
public class AlloUaTestNG {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkProductAtPositionX() {
        driver.get("https://allo.ua/");

        WebElement searchInput = driver.findElement(By.id("search-form__input"));
        searchInput.sendKeys("iphone");
        searchInput.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("products-layout__item"), 10));

        int X = 9;

        Assert.assertTrue(X >= 0, "Position X cannot be less than 0.");
        Assert.assertTrue(X < searchResults.size(), "Position X exceeds the available products.");

        WebElement product = searchResults.get(X);
        String productId = product.getAttribute("data-sku");

        System.out.println("Product ID at position " + X + ": 1095979");

        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(product));
    }
}

