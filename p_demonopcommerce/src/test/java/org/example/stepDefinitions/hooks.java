package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class hooks {
public static WebDriver driver=null;

@Before
    public void openBrowser(){

    driver=new ChromeDriver();

   driver.manage().window().maximize();

   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   driver.get("https://demo.nopcommerce.com/");


    }

    @After
    public void quitDriver() throws InterruptedException {

    Thread.sleep(3000);
    driver.quit();


    }



}

