package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;

public class login {
    WebDriver driver=null;
    @BeforeMethod
    public void openbrowser() {
        //1- define bridge between selenium code and browser  system.setproperty- webdrivermanager
        WebDriverManager.chromedriver().setup();

        //2-create new object from webdriver interface
        //declaration
        driver =new ChromeDriver();

        //3-configurations
        //3.1-maximize browser
        driver.manage().window().maximize();
        //3.2- set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //4- navigate to home page
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @Test
    public void validlogin() throws InterruptedException {
    driver.findElement(By.xpath("//a[@href=\"/login?returnUrl=%2F\"]")).click();
    driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("passent@gmail.com");
    driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();

        SoftAssert soft=new SoftAssert();
        Thread.sleep(2000);

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

        boolean actualLogout=driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed();
        Assert.assertTrue(actualLogout);

        boolean loginbutton=driver.findElements(By.xpath("//a[@class=\"ico-login\"]")).isEmpty();
        Assert.assertTrue(loginbutton);

        boolean accountbutton=driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed();
        Assert.assertTrue(accountbutton);

        //String actualMsgColor=driver.findElement(By.cssSelector("class=\"button-1 search-box-button\"")).getCssValue("background-color");
        //String actualColorHex= Color.fromString(actualMsgColor).asHex();
        String expectedColorHex="#4ab2f1";
       // Assert.assertEquals(actualColorHex,expectedColorHex);


        soft.assertAll();
    }
    @AfterMethod
    public void quitdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
