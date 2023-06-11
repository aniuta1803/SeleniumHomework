package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

}
    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> Categories;

    @FindBy(css = "#cartur")
    WebElement CartButton;

    public void SelectCagegory(String SelectedOption) throws InterruptedException {
       for(WebElement category:Categories){
           if(BrowserUtils.getText(category).contains(SelectedOption)){
               category.click();
               Thread.sleep(2000);
               break;
           }
       }

        }
        public void ClickCartButton(){
        CartButton.click();
        }
    }


