package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
*/
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");


        WebElement New = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(New,"New","text");
        WebElement Make = driver.findElement((By.xpath("//select[@id='makes']")));
        BrowserUtils.selectBy(Make,"lexus","value");

        WebElement Model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(Model,"lexus-rx_350","value");
        WebElement PriceLimit = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select select = new Select(PriceLimit);
        String ActualPrice = BrowserUtils.getText(select.getFirstSelectedOption());
       String ExpectedPrice = "No max price";
        Assert.assertEquals(ActualPrice,ExpectedPrice);

        WebElement Distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(Distance,"40 miles", "text");

        WebElement ZipCode = driver.findElement(By.cssSelector("#make-model-zip"));
        ZipCode.clear();
        ZipCode.sendKeys("60056");

        WebElement SearchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        SearchButton.click();
        Thread.sleep(2000);

        WebElement Header  = driver.findElement(By.cssSelector(".sds-heading--1"));
      String ActualHeader=  BrowserUtils.getText(Header);
      String ExpectedHeader = "New Lexus RX 350 for sale";
      Assert.assertEquals(ActualHeader,ExpectedHeader);

      WebElement SortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
       BrowserUtils.selectBy(SortBy,"list_price","value");
       Thread.sleep(2000);

       List<WebElement> SearchResult = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
           for(WebElement result : SearchResult){
           Assert.assertTrue(BrowserUtils.getText(result).contains("Lexus RX 350"));
               System.out.println(BrowserUtils.getText(result));
       }

           List<WebElement> Price = driver.findElements(By.cssSelector(".primary-price"));
           List<Integer> ActualCarPrice =new ArrayList<>();
           List<Integer> ExpectedCarPrice = new ArrayList<>();
           Thread.sleep(3000);

           for(int i =0; i<Price.size();i++){
               String CarPrice= BrowserUtils.getText(Price.get(i)).replace("$","").replace(",","");
               ActualCarPrice.add(Integer.parseInt(CarPrice));
               ExpectedCarPrice.add(Integer.parseInt(CarPrice));
               }
        Collections.sort(ExpectedCarPrice);
           Assert.assertEquals(ActualCarPrice,ExpectedCarPrice);
           Thread.sleep(2000);
           driver.quit();

           }

    }
