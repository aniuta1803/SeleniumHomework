package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerPageTest {
    @Test
    public void validateCustomerPageFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.AddCustomerFunctionality(driver,"Anna","Tumbev","60010","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Anna Tumbev","Dollar","Account created successfully with account Number");
        bankManagerPage.CustomersFunctionality("Anna","Tumbev","60010");


        loginPage.clickHomeButton();
        Thread.sleep(2000);
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.CustomerPageFunctionality("Anna Tumbev");
        customerPage.CustomerPageHeaderValidation("Welcome Anna Tumbev !!");
        Thread.sleep(2000);
        customerPage.DepositFunctionality("Deposit Successful","500");
        Thread.sleep(2000);
        driver.navigate().refresh();

        customerPage.WithdrawalFunctionality("Transaction successful","300");

        customerPage.TransactionsFunctionality();
    }
}
