package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.Callable;

public class LocatorPractice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement FirstName = driver.findElement(By.name("firstname"));
        FirstName.sendKeys("Anna");

        WebElement LastName = driver.findElement(By.name("lastname"));
        LastName.sendKeys("Tumbev");
        Thread.sleep(3000);
        WebElement checkBox = driver.findElement(By.id("sex-1"));
            checkBox.click();

        WebElement checkBoxExperience = driver.findElement(By.id("exp-3"));
            checkBoxExperience.click();

        WebElement Datepicker = driver.findElement(By.id("datepicker"));
        Datepicker.sendKeys("03/18/1992");

        WebElement Profession1 = driver.findElement(By.id("profession-0"));

        Profession1.click();

        WebElement Profession2 = driver.findElement(By.id("profession-1"));

            Profession2.click();

        WebElement Selenium = driver.findElement(By.id("tool-2"));
            Selenium.click();

        WebElement Continents = driver.findElement(By.id("continents"));
        Continents.sendKeys("Asia");

        WebElement Button = driver.findElement(By.id("submit"));
        Thread.sleep(2000);
       Button.click();

       String ActualURL = driver.getCurrentUrl();
       String ExpectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(ActualURL.equals(ExpectedURL)? "Url passed": "Url Failed");

        driver.quit();

            }
        }

