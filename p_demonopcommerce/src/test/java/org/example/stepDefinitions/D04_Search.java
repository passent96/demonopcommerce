package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.example.pages.P05_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

import static org.example.stepDefinitions.hooks.driver;

public class D04_Search {
     P01_HomePage home2=new P01_HomePage();
     P05_Search search=new P05_Search();


    @When("user enters product {string} in search box")
    public void userEntersProductName(String Name) {
        home2.SearchByName().sendKeys(Name);
    }


    @And("user press on search button")
    public void userPressOnSearchButton() {
     home2.SearchButton().click();

        String actualUrl=driver.getCurrentUrl();
        Boolean verify=actualUrl.contains("https://demo.nopcommerce.com/search?q=");
        Assert.assertTrue(verify);
    }



    @Then("search shows relevant results of {string}")
    public void searchShowsRelevantResultsOf(String Name) {
        SoftAssert soft=new SoftAssert();
        System.out.println("Number of search Result is "+search.SearchResultTitle().size());
         for (int i=0;i<search.SearchResultTitle().size();i++)
         {
             WebElement s=search.SearchResultTitle().get(i);
             String actualTitle=s.getText().toLowerCase();
             System.out.println(actualTitle);
             soft.assertTrue(actualTitle.contains(Name));


         }
        soft.assertAll();


    }


    @When("user search using product sku {string}")
    public void userSearchUsingProductSku(String Sku) {
        home2.SearchByName().sendKeys(Sku);
    }

    @And("user click on the product in search result")
    public void userClickOnTheProductInSearchResult() {
        home2.SearchSku().click();
        
    }

    @Then("search shows relevant results of product {string}")
    public void searchShowsRelevantResultsOfProduct(String Sku) {

        String ActualText=home2.SearchResult().getText();
        Boolean result=ActualText.contains(Sku);
        Assert.assertTrue(result);
    }
}
