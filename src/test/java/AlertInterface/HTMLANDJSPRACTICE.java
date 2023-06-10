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

import java.security.AllPermission;
import java.time.Duration;

public class HTMLANDJSPRACTICE {

    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement PreviewButton1= driver.findElement(By.xpath("//button[contains(@class,'preview')]"));
        PreviewButton1.click();
        Alert alert =driver.switchTo().alert();
        String ActualMessage =alert.getText().trim();
        String ExpectedMessage = "Oops, something went wrong!";
        Assert.assertEquals(ActualMessage,ExpectedMessage);
        System.out.println(ActualMessage);
        alert.accept();

        WebElement PreviewButton2 = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        PreviewButton2.click();
        Thread.sleep(2000);

        WebElement HTMLFrame= driver.findElement(By.xpath("//div[@class='swal-modal']"));
        WebElement HTMLText = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String ActualText = BrowserUtils.getText(HTMLText);
        String ExpectedText ="Something went wrong!";
        System.out.println(BrowserUtils.getText(HTMLText));

        WebElement Oops = driver.findElement(By.xpath("//div[@class='swal-title']"));
        System.out.println(BrowserUtils.getText(Oops));

        WebElement AllTExt = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        String ActualText1 = BrowserUtils.getText(AllTExt);
        String ExoectedYext1 = "Something went wrong";
        Assert.assertTrue(ActualText1.contains(ExoectedYext1));
        System.out.println(BrowserUtils.getText(AllTExt));


        WebElement OkButton = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        OkButton.click();
        driver.quit();
    }

}
