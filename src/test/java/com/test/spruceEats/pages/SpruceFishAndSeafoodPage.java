package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceFishAndSeafoodPage {

    public SpruceFishAndSeafoodPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css= "#search-form-input")
    WebElement SearchBar;

    @FindBy (xpath = "//button[@id='button_1-0']")
    WebElement SearchButton;

    public void FishAndSeafoodFunctionality(WebDriver driver, String InsertedData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.scrollWithJS(driver,SearchBar);
        Thread.sleep(2000);
        SearchBar.sendKeys(InsertedData);
        BrowserUtils.ClickWithJS(driver,SearchButton);
     //   SearchButton.click();
        Thread.sleep(2000);
    }
}
