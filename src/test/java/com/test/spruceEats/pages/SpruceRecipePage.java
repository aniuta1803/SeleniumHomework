package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SpruceRecipePage {
    public SpruceRecipePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "#starRating_score_4Star")
    WebElement RatingButton;

    @FindBy (css = "#pop_search_editor")
    WebElement EditorsChoice;

    @FindBy (css = ".card__title")
    WebElement ActualNameOfProduct;

    public void RatingButtonClick(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(RatingButton).perform();
        Thread.sleep(2000);
        if (!EditorsChoice.isSelected()&&EditorsChoice.isEnabled()){
           actions.click(EditorsChoice).perform();
           Thread.sleep(2000);
        }

    }
    public void RoastedSalmonFunctionality(String expectedNameOfProduct){
        Assert.assertEquals(BrowserUtils.getText(ActualNameOfProduct),expectedNameOfProduct);
    }
}
