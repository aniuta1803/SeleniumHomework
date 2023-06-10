package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait time
        driver.get("https://the-internet.herokuapp.com/");//url
// loop through all the links and count all the links

       List< WebElement> alllinks = driver.findElements(By.xpath("//li"));
        int count=0;
        for (WebElement link:alllinks){
            System.out.println(link.getText());
            count++;
        }
        System.out.println(count);


        //print out words that are longer >=12
        List<WebElement> allLinks = driver.findElements(By.tagName("li"));
        int count1 = 0;
        for(WebElement link : allLinks) {
            if (link.getText().length() >= 12) {  //there is no length. there is .gettext instead
                System.out.println(link.getText());
                count1++;
            }
        }
        System.out.println(count1);



    }
}
