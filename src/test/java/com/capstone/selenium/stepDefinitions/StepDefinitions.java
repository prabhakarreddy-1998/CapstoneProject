package com.capstone.selenium.stepDefinitions;

import com.capstone.selenium.base.BaseTest;
import com.capstone.selenium.pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {
    WebDriver driver;
    HomePage home;
    ABTestingPage abTesting;
    DropdownPage dropdown;
    FramesPage frames;

    @Given("User launches the application")
    public void user_launches_application() {
        BaseTest.setup();
        driver = BaseTest.getDriver();
        driver.get("http://the-internet.herokuapp.com/");
        
        home = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(), "The Internet", "Home page title does not match.");
    }

    @When("User clicks on AB Testing and verifies the text")
    public void user_clicks_ab_testing() {
        if (home != null) {
            home.clickABTesting();
            abTesting = new ABTestingPage(driver);
            abTesting.verifyABTestingText();
            driver.navigate().back();
        } else {
            throw new IllegalStateException("HomePage object is null. Ensure driver is initialized.");
        }
    }

    @And("User navigates back to home and clicks dropdown")
    public void user_clicks_dropdown() {
        if (home != null) {
            home.clickDropdown();
            dropdown = new DropdownPage(driver);
        } else {
            throw new IllegalStateException("HomePage object is null. Ensure driver is initialized.");
        }
    }

    @Then("User selects Option 1 and verifies selection")
    public void user_selects_option1() {
        if (dropdown != null) {
            dropdown.selectOption1();
            driver.navigate().back();
        } else {
            throw new IllegalStateException("DropdownPage object is null. Ensure navigation is correct.");
        }
    }

    @And("User navigates back to home and clicks Frames")
    public void user_clicks_frames() {
        if (home != null) {
            home.clickFrames();
            frames = new FramesPage(driver);
        } else {
            throw new IllegalStateException("HomePage object is null. Ensure driver is initialized.");
        }
    }

    @Then("User verifies Nested Frames and iFrame links")
    public void user_verifies_frames_links() {
        if (frames != null) {
            frames.verifyFrameLinks();
            BaseTest.tearDown();
        } else {
            throw new IllegalStateException("FramesPage object is null. Ensure navigation is correct.");
        }
    }
}
