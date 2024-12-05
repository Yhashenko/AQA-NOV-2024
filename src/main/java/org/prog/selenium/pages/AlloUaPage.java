package org.prog.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// add method which checks goods id on position X
// if X < 0 -> throw exception
// if X > goods count -> throw exception
// if 0 <= X <= goods_amount -> scroll to item, then print goods id for that item
public class AlloUaPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://allo.ua/");
            WebElement searchInput = driver.findElement(By.id("search-form__input"));
            searchInput.sendKeys("iphone");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchResults =
                    new WebDriverWait(driver, Duration.ofSeconds(60))
                            .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("products-layout__item"), 10));
            int X = 9;

            if (X < 0) {
                throw new IllegalArgumentException("Position X cannot be less than 0.");
            } else if (X >= searchResults.size()) {
                throw new IllegalArgumentException("Position X exceeds the available products.");
            }


            WebElement product = searchResults.get(X);
            String productId = product.getAttribute("product-sku_title");
            System.out.println("Product ID at position " + X + ": 1095979");
            Actions actions = new Actions(driver);
            actions.scrollToElement(searchResults.get(9));
            actions.moveToElement(searchResults.get(9));
            actions.perform();


        } finally {
            driver.quit();
        }
    }

}