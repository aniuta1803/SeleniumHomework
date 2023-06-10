package JavaScriptExcecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement YesRadioButton = driver.findElement(By.cssSelector("#yesRadio"));
      //  YesRadioButton.click();
     //   Actions actions = new Actions(driver);
      //  actions.click(YesRadioButton).perform();    if action doesn't work let's try to use javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",YesRadioButton);

        WebElement message = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String ActualText= BrowserUtils.getText(message);
        String ExpectedText = "You have selected Yes";
        Assert.assertEquals(ActualText,ExpectedText);



        WebElement Impressive = driver.findElement(By.cssSelector("#impressiveRadio"));
      //  Impressive.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",Impressive);


        WebElement ImpressiveText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String ActualImpressiveText = BrowserUtils.getText(ImpressiveText);
        String ExpectedImpressiveText = "You have selected Impressive";

        Assert.assertEquals(ActualImpressiveText,ExpectedImpressiveText);



        WebElement noRadioButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());


    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement Copyright = driver.findElement(By.xpath("//div[@class='learnworlds-main-text learnworlds-main-text-small learnworlds-element']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        BrowserUtils.scrollWithJS(driver,Copyright);
        String ActualText = BrowserUtils.getText(Copyright);
        String ExpectedText="Copyright © 2023";
        Assert.assertEquals(ActualText,ExpectedText);
        WebElement ApplyNow= driver.findElement(By.linkText("Apply Now"));
        BrowserUtils.scrollWithJS(driver,ApplyNow);
        Thread.sleep(2000);
        BrowserUtils.ClickWithJS(driver,ApplyNow);
        Thread.sleep(2000);



         String ActualTitle = BrowserUtils.GetTitleWithJS(driver);
         String ExpectedTitle = "Apply Now";
         Assert.assertEquals(ActualTitle,ExpectedTitle);

         List<WebElement> AllInformation = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));

         List <String> expectedInformation = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i<AllInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(AllInformation.get(i)),expectedInformation.get(i));

        }








    }
}