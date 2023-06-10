package com.test.openchart.tests;

import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.HomePage;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends OpenChartTestBase {

    @Test
    public void HomePageFunctionality() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("demo","demo");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");

        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.HomePageFunctionality();
    }
    @Test
    public void CustomerPageFunctionality() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("demo","demo");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.HomePageFunctionality();

        CustomerPage customerPage = new CustomerPage(driver);
        Thread.sleep(2000);
        customerPage.CustomerPageFunctionality(driver,"Anna","Tumbev","anna@gmail.com",
                "12345","12345","Warning:You do not have permission to modify customers!");
        Thread.sleep(2000);

        driver.quit();



    }
}
