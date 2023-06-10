package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void SuccessfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement Username = driver.findElement(By.cssSelector("#input-username"));
        Username.sendKeys("demo");
        WebElement Password = driver.findElement(By.cssSelector("#input-password"));
        Password.sendKeys("demo");
        WebElement SubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(2000);
        SubmitButton.click();
        Thread.sleep(2000);
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Dashboard";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @Test
    public void NegativeOutcome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement Username2 = driver.findElement(By.cssSelector("#input-username"));
        Username2.sendKeys("demo");
        WebElement Password2 = driver.findElement(By.cssSelector("#input-password"));
        Password2.sendKeys("DEMO");
        WebElement SubmitButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(2000);
        SubmitButton2.click();
        Thread.sleep(2000);

        WebElement Message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String ActualMessage = Message.getText().trim();
        String ExpectedMessage = "No match for Username and/or Password.".trim();
        Thread.sleep(2000);
        Assert.assertEquals(ActualMessage, ExpectedMessage);

        //assert true



        }

    @Test
    public void ValidateProductButton () throws InterruptedException {
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
        WebElement Products = driver.findElement(By.linkText("Products"));
       Assert.assertTrue(Products.isDisplayed());
       Assert.assertTrue(Products.isEnabled()); //enabled means its clickable




    }
    // arrow down Assert box is enabled, bos is displayed,  Asseret false box is selected  click it validate it's selected(assert true box is selected) ...arrow down

@Test
    public void ValidateBoxesFunctionality() throws InterruptedException {
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
        List<WebElement> CheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i =1; i<CheckBoxes.size(); i++){
            Assert.assertTrue(CheckBoxes.get(i).isDisplayed()&&CheckBoxes.get(i).isEnabled());
            Thread.sleep(1000);
            Assert.assertFalse(CheckBoxes.get(i).isSelected());
            CheckBoxes.get(i).click();
            Assert.assertTrue(CheckBoxes.get(i).isSelected());
            CheckBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }

        }
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
        Thread.sleep(3000);
        SubmitButton2.click();
        Thread.sleep(3000);

        WebElement CloseButton = driver.findElement(By.cssSelector(".btn-close"));
        CloseButton.click();
        Thread.sleep(3000);
        WebElement Catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        Thread.sleep(2000);
        Catalog.click();
        Thread.sleep(2000);
        WebElement Product = driver.findElement(By.xpath("//a[.='Products']"));
        Product.click();
        Thread.sleep(3000);
        // ********//
        WebElement ProductNameButton = driver.findElement(By.cssSelector("//a[.='Product Name']"));
        ProductNameButton.click();
        Thread.sleep(3000);

        List<WebElement> Products = driver.findElements(By.xpath("//td[@class='text-start']")); // 11 elements , but we don't need first one, because its 'product name'

        ArrayList<String> ActualProducts = new ArrayList<>();
        ArrayList<String> ExpectedProducts = new ArrayList<>();

        for(int i =1; i<Products.size(); i++){         // //runs the loop and adds elements to our list one by one
            ActualProducts.add(Products.get(i).getText().toUpperCase().trim());
            ExpectedProducts.add(Products.get(i).getText().toUpperCase().trim());
        }
        Collections.sort(ExpectedProducts);
        Collections.reverse(ExpectedProducts);
        System.out.println(ActualProducts);
        System.out.println(ExpectedProducts);
        Assert.assertEquals(ActualProducts,ExpectedProducts);




  }
    }
