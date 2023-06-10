package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {

    @Test
    public void PracticeJSAlert(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement ClickButton1 = driver.findElement(By.cssSelector("#alertBox"));
        ClickButton1.click();
        Alert alert =driver.switchTo().alert();
        String ActualText = alert.getText().trim();
        String ExpectedText = "I am an alert box!";
        Assert.assertEquals(ActualText,ExpectedText);
        alert.accept();
        WebElement Message = driver.findElement(By.cssSelector("#output"));
        String ActualMessage = BrowserUtils.getText(Message);
        String ExpectedMessage = "You selected alert popup";

        WebElement ClickButton2 = driver.findElement(By.cssSelector("#confirmBox"));
        ClickButton2.click();
        String ActualText2= alert.getText().trim();
        String ExpectedText2 = "Press a button!";
        Assert.assertEquals(ActualText2,ExpectedText2);
        alert.dismiss();
        WebElement Output = driver.findElement(By.cssSelector("#output"));
        String ActualOutput = BrowserUtils.getText(Output);
        String ExpectedOutput = "You pressed Cancel in confirmation popup";
        Assert.assertEquals(ActualOutput,ExpectedOutput);

        WebElement ClickButton3 = driver.findElement(By.cssSelector("#promptBox"));
        ClickButton3.click();
        alert.sendKeys("Anna");
        alert.accept();

        WebElement Message3= driver.findElement(By.cssSelector("#output"));
        String ActualMessage3 = BrowserUtils.getText(Message3);
        String ExpectedMessage3 = "You entered text Anna in propmt popup"; // there is a bug here. word misspelled
        Assert.assertEquals(ActualMessage3,ExpectedMessage3);
    }
}
