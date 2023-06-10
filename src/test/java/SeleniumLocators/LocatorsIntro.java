package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //locators is a way to find elements and manipulate on it.
    public static void main(String[] args) throws InterruptedException {

        //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("file:///Users/anya/Desktop/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim(); //gets text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "correct" : "wrong");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //NAME LOCATOR
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");


        WebElement LastName = driver.findElement(By.name("lastName"));
        LastName.sendKeys("Tumbev");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("773-999-9999");

        WebElement Email = driver.findElement(By.name("userName"));
        Email.sendKeys("aniuta18@gmail.com");

        WebElement Address = driver.findElement(By.name("address1"));
        Address.sendKeys("1234 Grand ave");

        WebElement City = driver.findElement(By.name("city"));
        City.sendKeys("Chicago");

        WebElement State = driver.findElement(By.name("state"));
        State.sendKeys("IL");

        WebElement PostalCode = driver.findElement(By.name("postalCode"));
        PostalCode.sendKeys("87973");

        // Class LOCATOR

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "Selected" : "Not Selected");

        WebElement testNg = driver.findElement(By.id("cond3"));
        if (testNg.isDisplayed() && !testNg.isSelected()) {
            testNg.click();
            System.out.println(testNg.isSelected() ? "Selected" : "Not Selected");
        }

        WebElement Cucumber = driver.findElement(By.id("cond4"));
        if (Cucumber.isDisplayed() && !Cucumber.isSelected()) {
            Cucumber.click();
            System.out.println(Cucumber.isSelected() ? "Selected" : "Not Selected");


        }

        //TAG NAME LOCATOR:

        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement use = driver.findElement(By.tagName("u"));
        System.out.println(use.getText());
       Thread.sleep(2000);
       driver.quit();

    }
}
