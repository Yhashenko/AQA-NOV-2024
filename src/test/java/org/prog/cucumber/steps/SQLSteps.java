package org.prog.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.prog.selenium.dto.PhoneDto;
import org.testng.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLSteps {

    public static List<PhoneDto> RANDOM_PHONES = new ArrayList<>();

    public static Connection connection;
    @Before
    public void setUp() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
            System.out.println("Database connection established successfully!");
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection: " + e.getMessage());
            throw e;
        }
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed successfully!");
        }
    }

    @Given("I store those phones to database")
    public void storeRandomPhonesToDatabase() throws SQLException {
        String insertStatement = "INSERT INTO Phones (PhoneName, GoodsId) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

        for (PhoneDto phoneDto : SQLSteps.RANDOM_PHONES) {
            preparedStatement.setString(1, phoneDto.getPhoneName());
            preparedStatement.setString(2, phoneDto.getGoodsId());
            try {
                preparedStatement.execute();
            } catch (Exception e) {
                System.err.println("Failed to save phone " + phoneDto.getPhoneName() + " " + phoneDto.getGoodsId());
            }
        }
    }

    @When("I request database for a random phone")
    public void getRandomPhoneFromDB() throws SQLException {
        String selectStatement = "SELECT * FROM Phones ORDER BY RAND() LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String phoneName = resultSet.getString("PhoneName");
            String goodsId = resultSet.getString("GoodsId");

            PhoneDto phoneDto = new PhoneDto(phoneName, goodsId);
            RANDOM_PHONES.clear();
            RANDOM_PHONES.add(phoneDto);
        }

        Assert.assertFalse(RANDOM_PHONES.isEmpty(), "No random phone found!");
    }
}
