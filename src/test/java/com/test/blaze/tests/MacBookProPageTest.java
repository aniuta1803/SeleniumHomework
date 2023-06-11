package com.test.blaze.tests;

import com.test.blaze.pages.HomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MacBookProPageTest extends BlazeTestBase{

    @Test
    public void HomePageValidation () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SelectCagegory("Laptops");
    }

    @Test void MacBookProValidation() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SelectCagegory("Laptops");
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.Laptop("MacBook Pro");
        macBookProPage.MacBookProPageInformation("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookProPage.AddToCart(driver,"Product added");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/prod.html?idp_=15#");
        homePage.ClickCartButton();
        Thread.sleep(2000);

    }

  }


