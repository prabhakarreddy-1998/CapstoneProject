package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.utils.ExcelUtils;

import java.io.IOException;
import java.util.List;

public class CountryTranslationTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/translation";
    }

    @DataProvider(name = "translations")
    public Object[][] getTranslations() throws IOException {
        List<String> translations = ExcelUtils.readTranslations("E:/JavaLearning/ComprehensiveAssignment/RestAssuredProject/src/test/resources/translations.xlsx", "Sheet1");
        Object[][] data = new Object[translations.size()][1];
        for (int i = 0; i < translations.size(); i++) {
            data[i][0] = translations.get(i);
        }
        return data;
    }


    @Test(dataProvider = "translations")
    public void testCountryTranslation(String translation) {
        Response response = RestAssured.given()
            .pathParam("translation", translation)
            .when()
            .get("/{translation}");

        System.out.println("Response for translation " + translation + ": " + response.getBody().asString());
        
        // Assert status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
