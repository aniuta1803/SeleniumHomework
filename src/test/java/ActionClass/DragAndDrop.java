package ActionClass;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String ActualMessage = BrowserUtils.getText(orangeBox);
        String ExpectedMessage = "... Or here.";
        Assert.assertEquals(ActualMessage, ExpectedMessage);
        String ActualBackgroundColor = orangeBox.getCssValue("background-color");
        String ExpectedBackgroundColor ="rgba(238, 111, 11, 1)";
        Thread.sleep(2000);
                Assert.assertEquals(ActualBackgroundColor, ExpectedBackgroundColor);

                WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
                Actions actions = new Actions(driver);
                actions.dragAndDrop(draggable,orangeBox).perform();
                Thread.sleep(2000);
               orangeBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']")); // we have to do reassignment because our code didn't work

                String ActualAfterDragDrop = BrowserUtils.getText(orangeBox);
                String ExpectedAfterDragDrop = "You did great!";
              Assert.assertEquals(ActualAfterDragDrop,ExpectedAfterDragDrop);

    }
    @Test
    public void DragAndDrop1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement BlueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String ActualMessage = BrowserUtils.getText(BlueBox);
        String ExpectedMessage = "Drag the small circle here ...";

        Assert.assertEquals(ActualMessage,ExpectedMessage);

        String actualColor = BlueBox.getCssValue("background-color").trim();
        String  ExpectedColor ="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,ExpectedColor);

        WebElement Draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(Draggable).moveToElement(BlueBox).release().perform();






    }
    }

