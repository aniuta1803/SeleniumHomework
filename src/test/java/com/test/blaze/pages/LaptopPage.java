package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaptopPage {
    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> LaptopList;

    public void Laptop (String LaptopName) throws InterruptedException {
        Thread.sleep(2000);
        for (WebElement laptop: LaptopList){
            if (BrowserUtils.getText(laptop).equals(LaptopName)){
            laptop.click();
            break;
        }
    }
}}
