package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrderPage {
   public PlaceOrderPage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }

   @FindBy(css = "#name")
    WebElement name;

   @FindBy (css = "#country")
    WebElement Country;

   @FindBy(css = "#city")
    WebElement City;

   @FindBy(css = "#card")
    WebElement Card;

   @FindBy(css = "#month")
    WebElement Month;

   @FindBy(css = "#year")
    WebElement Year;

   @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement PurchaseButton;

   @FindBy (xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
   WebElement Message;

   @FindBy (xpath = "//button[.='OK']")
   WebElement OkButton;

   public void PlaceOderFunctionality(String name,String country,String city, String card, String month,String year) throws InterruptedException {
       this.name.sendKeys(name);
       this.Country.sendKeys(country);
       this.City.sendKeys(city);
        this.Card.sendKeys(card);
        this.Month.sendKeys(month);
        this.Year.sendKeys(year);
        PurchaseButton.click();
        Thread.sleep(2000);
   }
   public void ConfirmationMessageFunctionality(String ExpectedMessage){
       Assert.assertEquals( BrowserUtils.getText(Message),ExpectedMessage);
       OkButton.click();
   }
}
