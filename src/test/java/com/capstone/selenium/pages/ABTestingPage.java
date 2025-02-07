package com.capstone.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABTestingPage {
    WebDriver driver;
    By text = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyABTestingText() {
        String actualText = driver.findElement(text).getText();
        Assert.assertEquals(actualText, "A/B Test Variation 1");
    }
}
