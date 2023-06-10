package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.util.List;

public class FramePractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement text = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing the TinyMCE WYSIWYG Editor')]"));
        System.out.println(BrowserUtils.getText(text));

        driver.switchTo().frame("mce_0_ifr");
        WebElement Field = driver.findElement(By.cssSelector("#tinymce"));
        Field.clear();
        Field.sendKeys("I love selenium");
        driver.switchTo().parentFrame();
        text = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing the TinyMCE WYSIWYG Editor')]"));
        System.out.println(BrowserUtils.getText(text));



    }
    /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
    @Test
    public void practice1 () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement Pavilion = driver.findElement(By.linkText("Pavilion"));
        Pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home");

        WebElement SeleniumButton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(SeleniumButton).perform();

        WebElement SeleniumPython = driver.findElement(By.linkText("Selenium-Python"));
        SeleniumPython.click();

        BrowserUtils.switchByTitle(driver,"Selenium-Python");
        WebElement Header = driver.findElement(By.tagName("h1"));
        String AcualHeader = BrowserUtils.getText(Header);
        String ExpectedHeader ="Selenium-Python Tutorial";
        Assert.assertEquals(AcualHeader,ExpectedHeader);


        List<WebElement> ListOfWebsites = driver.findElements(By.xpath("//p//a"));
        for (WebElement links :ListOfWebsites){
            System.out.println(links.getText());
        }

        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

BrowserUtils.switchByTitle(driver,"iframes");

driver.switchTo().frame("Framename1");
WebElement Category1 = driver.findElement(By.linkText("Category1"));
Category1.click();

BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");
WebElement HeaderCAtegory1 = driver.findElement(By.tagName("h1"));
String ActualHeader1 = BrowserUtils.getText(HeaderCAtegory1);
String ExpectedHeader1 = "Category Archives: SeleniumTesting";
Assert.assertEquals(ActualHeader1,ExpectedHeader1);

List<WebElement> links= driver.findElements(By.xpath("//article"));
for(WebElement link :links){
    Thread.sleep(2000);
    System.out.println(link.getText());
}
  /*
  TASK 3:
  1-Go back mainPage
  sout "im inside frame"
  c2-Click Category3
  3-print out header "Category Archives: SoftwareTesting"

 */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Framename1");
        WebElement Message = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(Message));

        driver.switchTo().parentFrame();                    //in order to switch between iframe we have to go back to parent frame
        driver.switchTo().frame("Frame2");          //and then find location of new frame

        WebElement Category3 = driver.findElement(By.linkText("Category3"));
        Category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement HeaderCAtegory2 = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(HeaderCAtegory2));

    }
}
