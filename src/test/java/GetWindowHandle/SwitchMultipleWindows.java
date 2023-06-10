package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.SortedMap;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String MainPageTAb = driver.getWindowHandle();
        Set<String> AllWindowTabs = driver.getWindowHandles(); //all pages, includes 2nd page
        for (String id: AllWindowTabs){
            if (!id.equals(MainPageTAb)){
                driver.switchTo().window(id);
                break;
            }

        }

        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

      BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Contains");
        System.out.println(driver.getTitle());

    }

    /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
*/
    @Test
    public void RealTask () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement Button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,Button4);
        Button4.click();
        BrowserUtils.switchByTitle(driver,"Basic");

        WebElement FirstName = driver.findElement(By.cssSelector("#firstName"));
        FirstName.sendKeys("Anna");
        WebElement LastName = driver.findElement(By.cssSelector("#lastName"));
        LastName.sendKeys("Tumbev");
        WebElement Gender = driver.findElement(By.cssSelector("#femalerb"));
        Gender.click();
        Thread.sleep(1000);
        WebElement LanguageCheckBox = driver.findElement(By.cssSelector("#englishchbx"));
        LanguageCheckBox.click();

        WebElement Email = driver.findElement(By.cssSelector("#email"));
        Email.sendKeys("anna18@gmail.com");

        WebElement Password = driver.findElement(By.cssSelector("#password"));
        Password.sendKeys("Anna12345");
        WebElement RegisterButton = driver.findElement(By.cssSelector("#registerbtn"));
        RegisterButton.click();
        Thread.sleep(1000);
        WebElement Message = driver.findElement(By.cssSelector("#msg"));
       String ActualMessage= BrowserUtils.getText(Message);
       String  ExpectedMessage = "Registration is Successful";
        Assert.assertEquals(ActualMessage,ExpectedMessage);

        BrowserUtils.switchByTitle(driver,"Window");
       WebElement Header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
       String ActualHeader= BrowserUtils.getText(Header);
       String ExpectedHeader = "Window Handles Practice";
       Assert.assertEquals(ActualHeader,ExpectedHeader);

       BrowserUtils.switchByTitle(driver,"alertsDemo");
       WebElement ClickMeButton = driver.findElement(By.cssSelector("#promptBox"));
       ClickMeButton.click();

       driver.quit();

    }


}
