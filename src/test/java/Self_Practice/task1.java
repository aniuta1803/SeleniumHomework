package Self_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task1 {

    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {


    /*
        1. you will click product name button
        2- you should create 2 arraylist
        *one will be actual data
        *another will be expected data
        3. for (int =1)
        *store all the names for both of the list. Please use at the end .toUppercase
        4. For expected list you will use Collections.sort(expectedList)
        --> Collections. reverse(expected)
        Assert.equals (actualList,expectedList
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement Username2 = driver.findElement(By.cssSelector("#input-username"));
        Username2.sendKeys("demo");
        WebElement Password2 = driver.findElement(By.cssSelector("#input-password"));
        Password2.sendKeys("demo");
        WebElement SubmitButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(2000);
        SubmitButton2.click();
        Thread.sleep(2000);
        WebElement CloseButton = driver.findElement(By.cssSelector(".btn-close"));
        Thread.sleep(2000);
        CloseButton.click();
        WebElement Catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        Thread.sleep(2000);
        Catalog.click();
        Thread.sleep(2000);
        WebElement Product = driver.findElement(By.xpath("//a[.='Products']"));
        Product.click();
        Thread.sleep(2000);
        // ********//
        WebElement ProductNameButton = driver.findElement(By.cssSelector(".asc"));
        ProductNameButton.click();
        Thread.sleep(2000);

        List<WebElement> Products = driver.findElements(By.xpath("//td[@class='text-start']"));

        ArrayList<String> ActualProducts = new ArrayList<>();
        ArrayList<String> ExpectedProducts = new ArrayList<>();

        for(int i =1; i<Products.size(); i++){
            ActualProducts.add(Products.get(i).getText().toUpperCase());
            ExpectedProducts.add(Products.get(i).getText().toUpperCase());
        }
        Collections.sort(ExpectedProducts);
        Collections.reverse(ExpectedProducts);

        Assert.assertEquals(ActualProducts,ExpectedProducts);

        driver.quit();
    }
}