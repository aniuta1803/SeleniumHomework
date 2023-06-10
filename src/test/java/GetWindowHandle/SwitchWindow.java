package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public static void SwitchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement ClickHere= driver.findElement(By.linkText("Click Here"));
        ClickHere.click();
        WebElement Header = driver.findElement(By.xpath("//h3"));
        String Actual = BrowserUtils.getText(Header);

      //  System.out.println(driver.getWindowHandle()); //it will return main page id -->the internet
        Set <String> AllPagesID = driver.getWindowHandles();
        System.out.println(AllPagesID);
        String MainPageId= driver.getWindowHandle();

        for (String id: AllPagesID){
            if (!id.equals(MainPageId)){
                driver.switchTo().window(id);
                break;
            }

        }
        Header = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(Header));

    }
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

       WebElement OpenNewWindow = driver.findElement(By.xpath("//button[contains(text(),'  Open New Tab')]"));
       OpenNewWindow.click();


        String MainPageTAb = driver.getWindowHandle();//this is first page id
        Set<String>AllWindowTabs = driver.getWindowHandles(); //all pages, includes 2nd page
        for (String id: AllWindowTabs){
            if (!id.equals(MainPageTAb)){
                driver.switchTo().window(id);
                break;
            }

        }
       WebElement AllertsDemo = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
      String ActualAllertsDemo= BrowserUtils.getText(AllertsDemo);
      String ExpectedAllertsDemo = "AlertsDemo";
      Assert.assertEquals(ActualAllertsDemo,ExpectedAllertsDemo);

       String ActualTitle =  driver.getTitle();
       String ExpectedTitle ="AlertsDemo - H Y R Tutorials";
       Assert.assertEquals(ActualTitle,ExpectedTitle);

       WebElement AllertBox = driver.findElement(By.cssSelector("#allertBox"));
       AllertBox.click();

    }
}
