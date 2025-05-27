package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefinitions.hooks.driver;

public class P05_Search {

    public List<WebElement> SearchResultTitle(){
        return driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));

    }


}
