package org.prog.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlloUaPage extends AbstractPage{
    private final static String URL = "https://allo.ua/";
    public AlloUaPage(WebDriver driver) {
        super(driver, URL);
    }
    public void setSearchValue(String value) {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.sendKeys(value);
    }
    public void executeSearch() {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.sendKeys(Keys.ENTER);
    }
    public List<WebElement> getSearchHeaders() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        return driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("products-layout__item"), 2));
    }

    public void setSearchInputText(String randomPhone) {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.clear();
        searchBox.sendKeys(randomPhone);
    }
    }

