package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".btn-close")
    WebElement CloseButton;

    @FindBy(linkText = "Customers")
    WebElement CustomersButton1;

    @FindBy(xpath = "//ul[@id='collapse-5']//a[.='Customers']")
    WebElement CustomersButton2;


    public void HomePageFunctionality()  {
        CloseButton.click();
        CustomersButton1.click();
        CustomersButton2.click();
    }

    }

