package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P01_HomePage;
import org.example.pages.P04_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static org.example.stepDefinitions.hooks.driver;

public class D02_login {
    P01_HomePage homePage=new P01_HomePage();
    P04_login login=new P04_login();


    @Given("user go to login page")
    public void goToLoginPage(){
        homePage.loginTab().click();
    }

    @And("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String arg0, String arg1, String arg2) {
     login.Email().sendKeys(arg1);
     login.Password().sendKeys(arg2);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
    login.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft=new SoftAssert();
     String actualUrl=driver.getCurrentUrl();
     String expectedUrl="https://demo.nopcommerce.com/";
        soft.assertEquals(actualUrl,expectedUrl);

     boolean MyAccount=driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
     soft.assertTrue(MyAccount);
     soft.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft=new SoftAssert();

      String ActualerrorMsg=login.invalidLogin().getText();
      boolean compare= ActualerrorMsg.contains("Login was unsuccessful.");
      soft.assertTrue(compare);

      String ActualMsgColor=login.invalidLogin().getCssValue("color");
      soft.assertEquals(Color.fromString(ActualMsgColor).asHex(),"#e4434b");

      soft.assertAll();



    }
}
