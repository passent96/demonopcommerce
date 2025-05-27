package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.example.pages.P02_RegisterPage;
import org.example.pages.P03_RegisterResult;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_Registration {
    P01_HomePage home=new P01_HomePage();
    P02_RegisterPage register=new P02_RegisterPage();
    P03_RegisterResult result=new P03_RegisterResult();

    @Given("user opens register page")
    public void goToRegister(){
    home.registerTab().click();
    }

    @When("user selects gender type")
    public void userSelectGenderType() {
        register.select_gender().click();

    }

    @And("user enters first name {string} and last name {string}")
    public void userEnterFirstAndLastName(String arg0,String arg1) {
     register.first_name().sendKeys(arg0);
     register.last_name().sendKeys(arg1);
    }

    @And("user selects date of birth")
    public void userSelectDateOfBirth() {
    Select select=new Select(register.dateofbirthday());
    select.selectByIndex(4);
    Select select1=new Select(register.dateofbirthmonth());
    select1.selectByIndex(6);
    Select select2=new Select(register.dateofbirthyear());
    select2.selectByIndex(25);

    }

    @And("user enters the email {string}")
    public void userEnterTheEmail(String arg0) {
    register.Email1().sendKeys(arg0);
    }


    @And("user fills password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
    register.Password().sendKeys(arg0);
    register.confirmPassword().sendKeys(arg1);
    }


    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
    register.registerButton().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft=new SoftAssert();

    boolean actual_msg=result.SuccessMsg().isDisplayed();
        soft.assertTrue(actual_msg);

    String actualColor= result.SuccessMsgColor();
    soft.assertEquals(Color.fromString(actualColor).asRgba(),"76, 177, 124, 1");


    }
}
