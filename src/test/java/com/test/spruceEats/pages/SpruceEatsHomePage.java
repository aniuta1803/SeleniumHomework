package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceEatsHomePage {
    public SpruceEatsHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
}
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingridients;

    @FindBy (xpath = "//a[.='Fish & Seafood']")
    WebElement FishAndSeafood;

    public void IngridientsFunctionality(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(ingridients).perform();
        actions.click(FishAndSeafood).perform();
        Thread.sleep(2000);


    }
}
