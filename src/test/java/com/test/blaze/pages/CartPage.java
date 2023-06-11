package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".success")
    List<WebElement> AllCartItems;

    @FindBy(css = ".btn-success")
    WebElement PlaceOrderButton;

    public void CartItemList(String ExpectedTittle,String ExpectedPrice){
        List<String> ExpectedItemsInCArt = Arrays.asList("",ExpectedTittle,ExpectedPrice,"");
        for (int i =1; i<AllCartItems.size()-1;i++){
          Assert.assertEquals(BrowserUtils.getText(AllCartItems.get(i)),ExpectedItemsInCArt.get(i));
        }

    }
    public void PlaceOrderClick() throws InterruptedException {
        PlaceOrderButton.click();
        Thread.sleep(2000);
    }
}
