package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Anna");


        WebElement LastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        LastName.sendKeys("Tumbev");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("ana7777@gmail.com");

        WebElement Telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        Telephone.sendKeys("111-301-1111");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("anna12374Q");

        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("anna12374Q");

        WebElement PrivacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(2000);
        PrivacyPolicy.click();

        WebElement checkbox = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        Thread.sleep(2000);
        checkbox.click();

        WebElement Header = driver.findElement(By.xpath("//h1[.='Your Account Has Been Created!']"));
        String actualHeader = Header.getText();
        String expectedHeader ="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)? "Account is created":"Account is not created");

       WebElement Continue = driver.findElement(By.xpath("//a[.='Continue']"));
       Thread.sleep(2000);
       Continue.click();

        String ActualURL = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(ActualURL.equals(expectedUrl)?"URL Passed": "URL Failed");
        Thread.sleep(2000);
        driver.quit();


    }
}
