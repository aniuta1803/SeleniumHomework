package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {
    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement HeaderText;

    @FindBy(tagName = "h3")
    WebElement price;

    @FindBy (xpath = "//div[@id='more-information']")
    WebElement Description;

    @FindBy (xpath = "//a[contains(text(),'Add to cart')]")
    WebElement AddToCart;

    public void MacBookProPageInformation(String ExpectedHeader, String ExpectedPrice, String ExpectedDescription){
        Assert.assertEquals(BrowserUtils.getText(HeaderText),ExpectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),ExpectedPrice);
        Assert.assertEquals(BrowserUtils.getText(Description),ExpectedDescription);
    }
    public void AddToCart(WebDriver driver, String ExpectedAlertText) throws InterruptedException {
        AddToCart.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),ExpectedAlertText);
        alert.accept();
    }
}
