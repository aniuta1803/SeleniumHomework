package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelfPractice {
    public static void main(String[] args) {
        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("file:///Users/anya/Desktop/Techtorial.html");

       WebElement SelenuiumLink = driver.findElement(By.linkText("Selenium")); // if we have <a> means its clickable so we use linktext
        SelenuiumLink.click();
        WebElement SeleniumHeader = driver.findElement(By.tagName("h1"));
       String ActualHeader = SeleniumHeader.getText().trim();
        String expectedSeleniumHeader = "Selenium automates browsers. That's it!";
        System.out.println(ActualHeader.equals(expectedSeleniumHeader)? "Selenium Header Passed": "Selenium Header failed");
        driver.navigate().back();

        WebElement TestNGLink = driver.findElement(By.linkText("TestNG"));
        TestNGLink.click();
        WebElement TestNGHeader = driver.findElement(By.tagName("h2"));
       String ActualHeaderTestNG = TestNGHeader.getText();
       String expectedHeaderTestNG = "TestNG";
        System.out.println(ActualHeaderTestNG.equals(expectedHeaderTestNG)?"TestNG passed":"TestNG failed");
        driver.navigate().back();
        String actualURLTestNG = driver.getCurrentUrl();
        String expectedURLTestNG = "file:///Users/anya/Desktop/Techtorial.html";
        System.out.println(actualURLTestNG.equals(expectedURLTestNG)? "Url TestNG passed":"Url TestNG failed");














       /*
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/anya/Desktop/Techtorial.html");

        WebElement SeleniumLink = driver.findElement(By.linkText("Selenium")); // It Has a tag name and text
        SeleniumLink.click();        // we found it and now we clicked it
        WebElement SeleniumHeader = driver.findElement(By.tagName("h1"));
        String actual = SeleniumHeader.getText().trim();
        String expected ="Selenium automates browsers. That's it!";
        System.out.println( actual.equals(expected) ? "passed Selenium ":"Failed Selenium" );
        driver.navigate().back();

        WebElement CucumberLink = driver.findElement(By.linkText("Cucumber"));
        CucumberLink.click();
        WebElement Cucumber = driver.findElement(By.tagName("h1"));
        String actual2 = Cucumber.getText().trim();
        String expected2 = "Tools & techniques that elevate teams to greatness";
        System.out.println(actual2.equals(expected2)? "Cucumber is Correct": "Cucumber is not Correct");
        driver.navigate().back();

        WebElement TestNgLink = driver.findElement(By.linkText("TestNG")); // if we have <a and link we use linkText
        TestNgLink.click();
        WebElement HeaderTestNg = driver.findElement(By.tagName("h2"));
        System.out.println( HeaderTestNg.getText().trim() );
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "file:///Users/anya/Desktop/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)? "Passed URL": "Did Not Pass URL");

        */

    }
}


