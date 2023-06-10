package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class CustomerPage {

    public  CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//i[@class='fas fa-plus']")
    WebElement PlusSignButton;

    @FindBy(css = "#input-firstname")
    WebElement FirstName;

    @FindBy(css = "#input-lastname")
    WebElement LastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(css = "#input-confirm")
    WebElement ConfirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement NewsLetterButton;

    @FindBy(css = "#input-status")
    WebElement StatusButton;

    @FindBy(css = "#input-safe")
    WebElement SafeButton;

    @FindBy(xpath = "//i[@class='fas fa-save']")
    WebElement SaveButton;
    @FindBy (xpath = "//div[@id='alert']")// "Warning: You do not have permission to modify customers!")
    WebElement Message;
    public void CustomerPageFunctionality(WebDriver driver,String firstName,String lastName,String email,String password,String ConfirmPassword,String expectedMessage ) throws InterruptedException {
        this.PlusSignButton.click();
        this.FirstName.sendKeys(firstName);
        this.LastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.ConfirmPassword.sendKeys(ConfirmPassword);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.scrollWithJS(driver,SafeButton);
        if(NewsLetterButton.isEnabled()&& NewsLetterButton.isDisplayed()&&!NewsLetterButton.isSelected()){
            js.executeScript("arguments[0].click()",NewsLetterButton);
        }

        if(StatusButton.isEnabled()&&StatusButton.isDisplayed()&&!StatusButton.isSelected()){
            js.executeScript("arguments[0].click()",StatusButton);
        }
        if(SafeButton.isEnabled()&&SafeButton.isDisplayed()&&!SafeButton.isSelected()){
            js.executeScript("arguments[0].click()",SafeButton);
        }
        SaveButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(Message),expectedMessage);
    }
}
