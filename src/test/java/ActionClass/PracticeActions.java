package ActionClass;

import Utils.BrowserUtils;
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

public class PracticeActions {
    @Test
    public void PracticeDragandDrop() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement dropBox = driver.findElement(By.xpath("//div[@class ='simple-drop-container']//div[@id='droppable']"));
        String ActualTex = BrowserUtils.getText(dropBox);
        String ExpectedText = "Drop here";
        Assert.assertEquals(ActualTex, ExpectedText);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, dropBox).perform();
        dropBox = driver.findElement(By.xpath("//div[@class ='simple-drop-container']//div[@id='droppable']"));
        String ActualAfterDragandDrop = BrowserUtils.getText(dropBox);
        String ExpectedAfterDragandDrop = "Dropped!";
        Assert.assertEquals(ActualAfterDragandDrop, ExpectedAfterDragandDrop);

        String ActualColor = dropBox.getCssValue("background-color");
        String ExpectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(ActualColor, ExpectedColor);


    }

    @Test
    public void PracticeClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement AcceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        AcceptButton.click();
        Thread.sleep(3000);

        WebElement Draggable1 = driver.findElement(By.cssSelector("#notAcceptable"));
        String ActualTextDraggable1 = BrowserUtils.getText(Draggable1);
        String ExceptedTextDragable1 = "Not Acceptable";
        Assert.assertEquals(ActualTextDraggable1,ExceptedTextDragable1);
        Thread.sleep(2000);
        WebElement DropBox= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        String ActualDropBoxText = BrowserUtils.getText(DropBox);
        String ExpectedDropBoxText = "Drop here";
        Thread.sleep(2000);
        Assert.assertEquals(ActualDropBoxText,ExpectedDropBoxText);

        Actions actions = new Actions(driver);
        actions.clickAndHold(Draggable1).moveToElement(DropBox).release().perform();

        Thread.sleep(2000);
        // DropBox= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
        String ActualTextAfterDrop = BrowserUtils.getText(DropBox);
        String ExpectedTextAfterDrop = "Drop here";
        Assert.assertEquals(ActualTextAfterDrop,ExpectedTextAfterDrop);

    }
}