package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.HomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import org.bouncycastle.cms.jcajce.JceKeyAgreeEnvelopedRecipient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BlazeTestBase{

    @Test
    public void CartPageValidation() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.SelectCagegory("Laptops");
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.Laptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.AddToCart(driver,"Product added");
        homePage.ClickCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.CartItemList("MacBook Pro","1100");
        cartPage.PlaceOrderClick();

    }
}
