package org.prog.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.selenium.pages.AlloUaPage;
import org.testng.Assert;

import java.sql.*;
import java.util.List;
import java.util.Random;

public class AlloUaSteps {

    public static AlloUaPage alloUaPage;
    private WebDriver driver;
    private Connection connection;
    private String randomPhone;

    public AlloUaSteps() {
        this.driver = new ChromeDriver();
        this.alloUaPage = new AlloUaPage(driver);
    }

    @Given("I load allo.ua page")
    public void loadAlloUaPage() {
        driver.get("https://allo.ua/");
    }

    @When("I request for 3 random phones from allo.ua website")
    public void requestRandomPhones() {
        String[] phones = {"iPhone 13", "iPhone 15", "iPhone 16"};
        randomPhone = phones[new Random().nextInt(phones.length)];
        alloUaPage.setSearchInputText(randomPhone);
        alloUaPage.executeSearch();
    }

    @Then("I can see at least {int} search results")
    public void validateAlloUaSearchResultsCount(int amount) {

        List<WebElement> searchHeaders = alloUaPage.getSearchHeaders();

        long count = searchHeaders.stream()
                .filter(header -> header.getText().contains(randomPhone))
                .count();

        Assert.assertTrue(count >= amount,
                "Expected at least " + amount + " search results, but found " + count);
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
