package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import static org.example.stepDefinitions.hooks.driver;

public class P03_RegisterResult {
    public WebElement SuccessMsg(){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }

    public String SuccessMsgColor(){
        return SuccessMsg().getCssValue("color");
    }
}
