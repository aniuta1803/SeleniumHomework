package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1 {
    public static void main(String[] args) {

/*

1-Create a homework package and class
2-Under 1 main method--> go to 3 different websites and validate the title, and URL of the page with Ternary Operator. (It can be any website you decide)
SIDE NOTE: You do not need to create 3 different web drivers. One will be enough.
                     Send your code screenshot by replaying this thread.
 */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.nike.com/");
        System.out.println(driver.getTitle());
        String ActualTitleNike = driver.getTitle();
        String expectedTitleNike = "Nike. Just Do It. Nike.com";
        System.out.println(ActualTitleNike.equals(expectedTitleNike)?"Nike Title Passed":"Nike Title Failed");
        String ActualURLNike = driver.getCurrentUrl();
        String ExpectedURLNike = "https://www.nike.com/";
        System.out.println(ActualURLNike.equals(ExpectedURLNike)?"Nike URL Passed":"Nike URL Failed");

        driver.navigate().to("https://www.adidas.com/us");
        System.out.println(driver.getTitle());
        String ActualTitleAdidas = driver.getTitle();
        String ExpectedTitleAdidas = "adidas Official Website | adidas US";
        System.out.println(ActualTitleAdidas.equals(ExpectedTitleAdidas)?"Adidas Title Passed":"Adidas Title Failed");
        String ActualURLAdidas= driver.getCurrentUrl();
        String ExpectedURLAdidas = "https://www.adidas.com/us";
        System.out.println(ActualURLAdidas.equals(ExpectedURLAdidas)? "Adidas URL Passed": "Adidas URL Failed");

        driver.navigate().to("https://www.underarmour.com/en-us/");
        System.out.println( driver.getTitle());
        String ActualTitleUnderArmor = driver.getTitle();
        String ExpectedTitleUnderArmor = "Under Armour® Official Store | FREE Shipping Available";
        System.out.println(ActualTitleUnderArmor.equals(ExpectedTitleUnderArmor)?"Under Armor Title Passed" : "Under Armor Title Failed");
        String ActualURLUnderArmor = driver.getCurrentUrl();
        String ExpectedURLUnderArmor = "https://www.underarmour.com/en-us/";
        System.out.println(ActualURLUnderArmor.equals(ExpectedURLUnderArmor)?"Under Armor URL Passed" : "Under Armor URL Failed");



    }
}
