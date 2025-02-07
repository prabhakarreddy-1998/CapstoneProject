package com.capstone.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By abTestLink = By.linkText("A/B Testing");
    By dropdownLink = By.linkText("Dropdown");
    By framesLink = By.linkText("Frames");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickABTesting() {
        driver.findElement(abTestLink).click();
    }

    public void clickDropdown() {
        driver.findElement(dropdownLink).click();
    }

    public void clickFrames() {
        driver.findElement(framesLink).click();
    }
}
