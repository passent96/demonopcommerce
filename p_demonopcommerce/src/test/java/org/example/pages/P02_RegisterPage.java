package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefinitions.hooks.driver;

public class P02_RegisterPage {
    public WebElement select_gender(){
        return driver.findElement(By.cssSelector("input[id=\"gender-male\"]"));
    }

    public WebElement first_name(){
        return driver.findElement(By.cssSelector("input[id=\"FirstName\"]"));
    }

    public WebElement last_name(){
        return driver.findElement(By.cssSelector("input[id=\"LastName\"]"));
    }

    public WebElement dateofbirthday(){
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement dateofbirthmonth(){
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement dateofbirthyear(){
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement Email1(){
        return driver.findElement(By.id("Email"));
    }


    public WebElement Password(){
        return driver.findElement(By.id("Password"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerButton(){
        return driver.findElement(By.id("register-button"));
    }

    public WebElement successMsg(){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }


}
