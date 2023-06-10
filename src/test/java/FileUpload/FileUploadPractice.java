package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://the-internet.herokuapp.com/upload");
        WebElement ChooseFile=driver.findElement(By.cssSelector("#file-upload"));
        ChooseFile.sendKeys("/Users/anya/Desktop/usa.png");
        WebElement UploadButton = driver.findElement(By.cssSelector("#file-submit"));
        UploadButton.submit();
        WebElement FileUploaded = driver.findElement(By.cssSelector("#uploaded-files"));
        String ActualText= BrowserUtils.getText(FileUploaded);
        String ExpectedText = "usa.png";
        Assert.assertEquals(ActualText,ExpectedText);


    }

    @Test
 public void practice2() throws InterruptedException {
     WebDriverManager.chromedriver().setup();
     ChromeOptions chromeOptions= new ChromeOptions();
     chromeOptions.addArguments("--remote-allow-origins=*");
     ChromeDriver driver = new ChromeDriver(chromeOptions);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://demo.guru99.com/test/upload/");

     WebElement ChooseFile = driver.findElement(By.cssSelector(".upload_txt"));
     ChooseFile.sendKeys("/Users/anya/Desktop/usa.png");

     WebElement message = driver.findElement(By.xpath("//b[contains(text(),'Select file to send(max 196.45 MB)')]"));
     String ActualMessage = BrowserUtils.getText(message);
     String ExpectedMesage ="Select file to send(max 196.45 MB)";
     Assert.assertEquals(ActualMessage,ExpectedMesage);

     WebElement AcceptButton = driver.findElement(By.cssSelector("#terms"));
     if(AcceptButton.isDisplayed()&& !AcceptButton.isSelected()&&AcceptButton.isEnabled()) {
         AcceptButton.click();
     }

     WebElement SubmitFile = driver.findElement(By.xpath("//button[@id='submitbutton']"));
     SubmitFile.click();
Thread.sleep(2000);
    WebElement  SubmitMessage = driver.findElement(By.xpath("//h3[@id='res']"));
    String ActualSubmitMessage = BrowserUtils.getText(SubmitMessage);
    Thread.sleep(2000);
    String ExpectedSubmitMessage = "1 file\n" +
            "has been successfully uploaded.";
    Thread.sleep(2000);
    Assert.assertEquals(ActualSubmitMessage,ExpectedSubmitMessage);

 }
}
