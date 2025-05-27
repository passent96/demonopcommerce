package org.example.stepDefinitions;

import com.sun.tools.jconsole.JConsoleContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static org.example.stepDefinitions.hooks.driver;

public class D08_Wishlist {
    P01_HomePage home5=new P01_HomePage();
    @Given("user finds 4 products in the middle of home page")
    public void userFind4Products(){
        int NumberOfProducts=home5.Products().size();
        System.out.println("Number Of Products in Home Page Is "+NumberOfProducts);
    }

    @When("user clicks on wishlist button on this product {string}")
    public void userClicksOnWishlistButtonOnThisProduct(String arg0) {
        home5.WishlistProduct().get(2).click();

    }


    @Then("success message  {string} displayed with green color")
    public void successMessageDisplayedWithGreenColor(String arg0) {
        SoftAssert soft=new SoftAssert();
    Boolean SucessM=home5.SucessM().isDisplayed();
    soft.assertTrue(SucessM);
    String ActualColor=home5.BackgroundColor().getCssValue("background-color");
    String ActualColorHex= Color.fromString(ActualColor).asHex();
    String ExpectedColor="#4bb07a";
    soft.assertEquals(ActualColorHex,ExpectedColor);
    soft.assertAll();
    }

    @And("user wait until success message disappear and click on wishlist tab")
    public void userWaitUntilSuccessMessageDisappearAndClickOnWishlistTab() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(home5.SucessM()));
        home5.WishlistButton().click();
    }

    @Then("user gets Qty value and verify it's bigger than {string}")
    public void userGetsQtyValueAndVerifyItSBiggerThan(String arg0) {
       WebElement r= home5.WishlistQty();
       String Qty=r.getAttribute("value");
        System.out.println("text "+Qty);
     Boolean result=Qty.compareTo(arg0)>0;
     Assert.assertTrue(result);
    }
}
