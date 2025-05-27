package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_Currencies {
    P01_HomePage home1=new P01_HomePage();

    @When("user change currency selection to euro")
    public void changeCurrency(){
        Select select=new Select(home1.Currency());
        select.selectByIndex(1);
        
    }

    @Then("verify that euro symbol is visible on home page")
    public void verifyThatEuroSymbolIsVisibleOnHomePage() {
        WebElement r;
       List<WebElement> productsDetails=home1.euroSymbol();
     for (int i=0;i<productsDetails.size();i++){
         r=productsDetails.get(i);
         String actualresult=r.getText();
         Boolean verify=actualresult.contains("€");
         Assert.assertTrue(verify);
     }
    }
}
