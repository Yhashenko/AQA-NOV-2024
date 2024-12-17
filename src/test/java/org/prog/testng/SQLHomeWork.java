package org.prog.testng;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//TODO: Add table to database which contains PhoneId, PhoneName, GoodsId
//TODO: In Allo.ua search for iphone, and store first three devices name
// and код товару (GoodsId) to database
// TODO: * - check if this code and name are already present in database. If its present - do nothing
public class SQLHomeWork {
    private Connection connection;
    @SneakyThrows
    @BeforeSuite
    public void setUp() {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");

        }
    @SneakyThrows
    @Test
    public void searchAndStorePhones() {
        String insertPhoneStatement = "INSERT INTO Phones (PhoneName, GoodsId) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertPhoneStatement);
       List<PhoneDto> phones = retrievePhones (3);
        for (PhoneDto phoneDto : phones) {
            preparedStatement.setString(1, phoneDto.getPhoneName());
            preparedStatement.setString(2, phoneDto.getGoodsId());
            try {
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.err.println("Failed to save iphone " + phoneDto.getPhoneName() + " " + phoneDto.getGoodsId());
            }
        }
    }

   @SneakyThrows
   @Test
    public void mySqlReadRandomPhone () {
       String selectStatement = "select * from Phones ORDER BY RAND() limit 3";
       PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
       ResultSet resultSet = preparedStatement.executeQuery(selectStatement);
       while (resultSet.next()) {
           System.out.println(resultSet.getString("PhoneName") +
                   " " + resultSet.getString("GoodsId"));
       }
   }
    @SneakyThrows
    @AfterSuite
    public void tearDown() {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    private List<PhoneDto> retrievePhones (int amount) {
        List<PhoneDto> phones = new ArrayList<>();
        String searchQuery = "iphone";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "iphone, id");
        requestSpecification.baseUri("https://allo.ua/");
        Response response = requestSpecification.get("/search");


        ValidatableResponse validatableResponse = response.then();

        return phones;
    }

    }

