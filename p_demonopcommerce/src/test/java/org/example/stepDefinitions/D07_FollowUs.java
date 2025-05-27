package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefinitions.hooks.driver;

public class D07_FollowUs {
    P01_HomePage home4=new P01_HomePage();

    @When("user opens facebook link")
    public void userOpensFBLink(){
     home4.FollowUsLinks().get(0).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) {
        ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,arg0);

    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        home4.FollowUsLinks().get(1).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        home4.rssLink().click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        home4.FollowUsLinks().get(2).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
