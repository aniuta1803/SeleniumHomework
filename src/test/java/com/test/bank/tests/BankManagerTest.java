package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.AddCustomerFunctionality(driver,"Anna","Tumbev","60010","Customer added successfully with customer id");


    }
    @Test
    public  void validateOpenAccountFunctionality() throws InterruptedException {
      //  WebDriverManager.chromedriver().setup();
       // ChromeOptions options=new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //WebDriver driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        Thread.sleep(2000);
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.AddCustomerFunctionality(driver,"Anna","Tumbev","60010","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Anna Tumbev","Dollar","Account created successfully with account Number");

    }
    @Test
    public void validateCustomerFunctionality(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.AddCustomerFunctionality(driver,"Anna","Tumbev","60010","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Anna Tumbev","Dollar","Account created successfully with account Number");
        bankManagerPage.CustomersFunctionality("Anna","Tumbev","60010");
    }
}
