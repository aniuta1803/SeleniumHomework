package com.test.bank.pages;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "#userSelect")
    WebElement YourNameField;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement CustomerLoginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")

    WebElement CustomerHeader;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement DepositButton;

    @FindBy(tagName = "input")
    WebElement AmountToBeDeposited;

    @FindBy(css = ".error")
    WebElement DepositMessage;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement DepositButton2;

    @FindBy (xpath = "//button[@ng-click='withdrawl()']") // button[contains(text(),'Withdrawl')]
    WebElement Withdrawal;
    @FindBy(xpath = "//input[@type='number']") //  //input
    WebElement AmountToBeWithdrawn;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement WithdrawSubmitButton;

    @FindBy (xpath = "//span[@ng-show='message']")
    WebElement WithdrawMessage;

    @FindBy (xpath = "//div[@class='center']//strong[2]") // //div[@ng-hide='noAccount']//strong[2]
    WebElement Balance;

   @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement Transactions;

   @FindBy(xpath= "//tr[@id='anchor0']//td[2]")
   WebElement FirstDeposit; //depositCredit

    @FindBy(xpath="//tr[@id='anchor1']//td[2]")
    WebElement WithdrawAmount;  //WithrawDebit


    public void CustomerPageFunctionality(String CustomerName) throws InterruptedException {  // loginfunctionality
        YourNameField.click();
        BrowserUtils.selectBy(YourNameField,CustomerName,"text");
        Thread.sleep(2000);
        CustomerLoginButton.click();

    }
    public void CustomerPageHeaderValidation (String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(CustomerHeader),expectedHeader);
    }

    public void DepositFunctionality(String expectedMessage,String DepositAmount) throws InterruptedException {
        DepositButton.click();
        Thread.sleep(2000);
        AmountToBeDeposited.sendKeys(DepositAmount);
        DepositButton2.click();

        Assert.assertEquals(BrowserUtils.getText(DepositMessage),expectedMessage);
    }
    public void WithdrawalFunctionality (String expectedWithdrawMessage, String WithdrawAmount) throws InterruptedException {
        Withdrawal.click();
        Thread.sleep(2000);
        AmountToBeWithdrawn.sendKeys(WithdrawAmount);
        WithdrawSubmitButton.click();
        Assert.assertEquals(BrowserUtils.getText(WithdrawMessage),expectedWithdrawMessage);
    }
    public void TransactionsFunctionality() throws InterruptedException {
        Thread.sleep(2000);
        int resultActual = Integer.parseInt(BrowserUtils.getText(Balance));//200
        Transactions.click();
        Thread.sleep(2000);
        int Amount500 = Integer.parseInt(BrowserUtils.getText(FirstDeposit)); //depositCredit
        int Amout300 = Integer.parseInt(BrowserUtils.getText(WithdrawAmount)); //withrawDebit
        int resultExpected = Amount500-Amout300;
        Assert.assertEquals(resultActual,resultExpected);



    }}


