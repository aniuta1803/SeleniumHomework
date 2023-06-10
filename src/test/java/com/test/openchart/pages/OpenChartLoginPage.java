package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement Username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement LoginButton;

    @FindBy (css = "#alert")
    WebElement errorMessage;



    public void LoginFunctionality(String username,String password) {
        this.Username.sendKeys(username);
        this.Password.sendKeys(password);
        LoginButton.click();

    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
