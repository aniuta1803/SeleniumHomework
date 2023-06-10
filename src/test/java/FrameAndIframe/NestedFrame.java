package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void NestedFramePractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        //Name or ID iFrame
        driver.switchTo().frame("frame-top");
        //WebElement iframe
        WebElement iFrameLeft= driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iFrameLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));


        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement Middle = driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(Middle));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement righFrame = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(righFrame));

     //   driver.switchTo().parentFrame();//top frame
      //  driver.switchTo().parentFrame();//main HTML
      //  driver.switchTo().frame("frame-bottom");
        driver.switchTo().defaultContent(); //this way it will go to main HTML no matter what, no need to write goTo.parent frame
        //Swithing frame with index
        driver.switchTo().frame(1);//bottom    - we can do it by index of a frame, but its better not to use it that way
        WebElement BottomFrame = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(BottomFrame));











    }
}
