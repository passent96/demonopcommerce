package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefinitions.hooks.driver;

public class P04_login {

    public WebElement Email(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement Password(){
        return driver.findElement(By.id("Password"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement invalidLogin(){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
}
