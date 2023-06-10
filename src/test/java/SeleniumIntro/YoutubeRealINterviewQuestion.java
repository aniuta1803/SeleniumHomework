package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealINterviewQuestion {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait time
        driver.get("https://www.youtube.com/");
        // Thread.sleep ("2000")
        //song.sendKeys(Keys.Arrow_Down)-put this inside loop

        WebElement SerchField = driver.findElement(By.xpath("//input[@id='search']"));
        SerchField.sendKeys("Justin Bieber", Keys.ENTER);
        SerchField.sendKeys(Keys.ENTER); // instead of looking for search button and make it click, this will just hit enter
       /* WebElement Button = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        Thread.sleep(2000);
        Button.click(); */
         Thread.sleep(2000); //put it before list, just to make sure it loads .. because we need to give enough time to scroll down
        List<WebElement> songs = driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song : songs){
            if (song.getAttribute("aria-label").contains("Justin Bieber X Free Fire - Beautiful Love (Free Fire) [Official Video]"));
           Thread.sleep(2000);
           song.sendKeys(Keys.ARROW_DOWN);
            song.click();
            break;
        }




    }
}
