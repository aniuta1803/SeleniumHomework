package com.test.spruceEats.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SpruceEatsTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        //   WebDriverManager.chromedriver().setup();
        //  ChromeOptions options=new ChromeOptions();
        // options.addArguments("--remote-allow-origins=*");
        // driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.navigate().to("https://www.demoblaze.com/#");
        driver= DriverHelper.getDriver();
        driver.get("https://www.thespruceeats.com/");

    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenshot(driver,"SpruceEatsPicture");
        }
     //   driver.quit();
    }
}