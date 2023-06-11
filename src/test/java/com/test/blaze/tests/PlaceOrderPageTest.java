package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderPageTest extends BlazeTestBase{

    @Test
    public void OrderPageValidation() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SelectCagegory("Laptops");
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.Laptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.AddToCart(driver,"Product added");
        homePage.ClickCartButton();

        CartPage cartPage = new CartPage(driver);
        //cartPage.CartItemList("MacBook Pro","1100");
        cartPage.PlaceOrderClick();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.PlaceOderFunctionality("Anna","Ukraine","Lviv","1234567","June","2023");

        placeOrderPage.ConfirmationMessageFunctionality("Thank you for your purchase!");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/index.html");
    }
}
