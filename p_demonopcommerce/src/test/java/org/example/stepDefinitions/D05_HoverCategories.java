package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.pool.TypePool;
import org.example.pages.P01_HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.example.stepDefinitions.hooks.driver;

public class D05_HoverCategories {

    P01_HomePage home=new P01_HomePage();
     WebElement hover;
     WebElement result;
     String Text;

    @When("user selects random one of the three main categories in Home page")
    public void selectRandomCategory(){
     int min=0;
     int max=2;
     int selectedCategoryIndex=(int)Math.floor(Math.random()*(max-min+1)+min);
    hover=home.MainCategories().get(selectedCategoryIndex);
    }


    @And("user hover on selected category")
    public void userHoverOnSelectedCategory() {
        Actions action=new Actions(driver);
        action.moveToElement(hover).perform();

    }

    @And("user selects random one of the sub-categories")
    public void userSelectRandomOneOfTheSubCategories(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        int min=0;
        int max=2;
        int Index=(int)Math.floor(Math.random()*(max-min+1)+min);
        result=hover.findElements(By.cssSelector("ul[class=\"sublist first-level\"]>li>a")).get(Index);
         Text=result.getText();
        System.out.println("the sub category is "+Text);
        wait.until(ExpectedConditions.elementToBeClickable(result)).click();
    }


    @Then("user gets page subtitle text and compare it with the random sub-category")
    public void userGetsPageSubtitleText(){
     driver.getCurrentUrl();
    String Title=home.PageTitle().getText();
    System.out.println("Page Title "+Title);
     Assert.assertEquals(Title,Text);


    }
}
