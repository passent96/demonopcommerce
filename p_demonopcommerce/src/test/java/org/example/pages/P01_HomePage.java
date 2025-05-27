package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

import static org.example.stepDefinitions.hooks.driver;

public class P01_HomePage {
    public WebElement registerTab() {

        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }


    public WebElement loginTab() {
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }

    public WebElement Currency(){
        return driver.findElement(By.id("customerCurrency"));
    }

   public List<WebElement> euroSymbol(){
        return driver.findElements(By.xpath("span[@class=\"price actual-price\"]"));
   }


   public WebElement SearchByName(){
        return driver.findElement(By.id("small-searchterms"));
   }

   public WebElement SearchButton(){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
   }

   public WebElement SearchSku(){
        return driver.findElement(By.cssSelector("a[class=ui-menu-item-wrapper]"));
   }

   public WebElement SearchResult(){
        return driver.findElement(By.cssSelector("div[class=\"sku\"]"));
   }

   public List<WebElement> MainCategories(){
        return driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li"));


   }

  public WebElement PageTitle(){
        return driver.findElement(By.cssSelector("div[class=\"page-title\"] h1"));
  }

  public List<WebElement> FollowUsLinks(){
        return driver.findElements(By.cssSelector("a[rel=\"noopener noreferrer\"]"));

  }
  public WebElement rssLink(){
     return    driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
  }

  public List<WebElement> Products(){
        return driver.findElements(By.cssSelector("div[class=\"product-grid home-page-product-grid\"]>div>div"));
  }

  public List<WebElement> WishlistProduct(){
        return driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
  }

  public WebElement SucessM(){
        return driver.findElement(By.cssSelector("p[class=\"content\"]"));
  }

  public WebElement BackgroundColor(){
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
  }

  public WebElement WishlistButton(){
        return driver.findElement(By.cssSelector("a[class=\"ico-wishlist\"]"));
  }

  public WebElement WishlistQty(){
        return driver.findElement(By.cssSelector("td>input[value=\"1\"]"));
  }
  }



