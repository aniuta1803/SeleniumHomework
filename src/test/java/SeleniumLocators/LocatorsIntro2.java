package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("file:///Users/anya/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();

        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println( actualHeader.equals(expectedHeader)? "Correct": "False");
        driver.navigate().back();
/*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        WebElement SeleniumLink = driver.findElement(By.linkText("Selenium")); // It Has <a> tag name and text
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
        String expectedUrl = "file:///Users/anya/Desktop/Techtorial.html ";
        System.out.println(actualUrl.equals(expectedUrl)? "Passed URL": "Did Not Pass URL");

        //LOCATOR PARTIALLINKTEXT:
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());



    }
}
