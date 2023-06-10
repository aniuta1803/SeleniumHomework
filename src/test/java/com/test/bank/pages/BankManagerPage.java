package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {
    public BankManagerPage (WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement OpenAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css="#currency")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    public void AddCustomerFunctionality(WebDriver driver, String firstName, String lastName, String postCode, String expectedMessage){
       addCustomerButton.click();
       this.firstName.sendKeys(firstName);
       this.lastName.sendKeys(lastName);
       this.postCode.sendKeys(postCode);
       SubmitAddCustomerButton.submit();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }
    public void OpenAccountFunctionality(WebDriver driver, String name,String currency, String ExpectedMessage) {
        OpenAccountButton.click();
        BrowserUtils.selectBy(customerName,name,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
       Alert alert = driver.switchTo().alert();
       Assert.assertTrue(alert.getText().trim().contains(ExpectedMessage));
       alert.accept();


    }
    public void CustomersFunctionality(String customerName, String lastName, String postCode){
        customersButton.click();
        searchBox.sendKeys(customerName);
        List<String> expectedNames = Arrays.asList(customerName,lastName,postCode);
        for(int i =0; i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));
        }
    }
}
