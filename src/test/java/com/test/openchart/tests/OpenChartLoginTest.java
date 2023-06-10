package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase{

    @Test
       public void HappyPathLogin(){
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");

    }
     @Test
    public void validateNegativeLogin(){
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.LoginFunctionality("wrongusername","wrongpassword");
        Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");
     }

}
