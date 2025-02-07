package com.capstone.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FramesPage {
    WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFrameLinks() {
        Assert.assertTrue(driver.findElement(By.linkText("Nested Frames")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("iFrame")).isDisplayed());
    }
}
