package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {

    // fist step is setting up your automation

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Then create your driver to start automation
        WebDriver driver = new ChromeDriver(options); // a way to create driver to connect with a website
                                                 // without driver you cannot connect with website
        driver.get("https://www.amazon.com/"); //get method takes you to the website
        System.out.println(driver.getTitle()); //goes to website and gets the tittle

        String actualTitle = driver.getTitle();// actual comes from website. validation.

        String expectedTitle = "Amazon.com. Spend less. Smile more."; //expected comes from team (the name that we expect to be shown )

        if (actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.amazon.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println(" URL passed");

            }else {
            System.out.println("URL failed");
        }

        driver.close();
        }

    }


