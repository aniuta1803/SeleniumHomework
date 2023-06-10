package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class SelenIntroPractice {
    public static void main(String[] args) throws InterruptedException {

        //go to youtube page. write justin bieber. press search... the pick some song, make it click

        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait time
        driver.get("https://www.youtube.com/");
        // Thread.sleep ("2000")
        //song.sendKeys(Keys.Arrow_Down)-put this inside loop
        WebElement searchLine = driver.findElement(By.xpath("//input[@id='search']"));
        searchLine.sendKeys("Justin Bieber");
       WebElement SeachButton = driver.findElement(By.xpath("//button[@id ='search-icon-legacy']"));
       Thread.sleep(2000);
       SeachButton.click();
        List<WebElement> AllSongs= driver.findElements(By.xpath("//a[@id='video-title']"));

        for(WebElement song : AllSongs ){
            if(song.getAttribute("aria-label").contains("Justin Bieber - Ghost")){
                Thread.sleep(2000);
                song.click();
            }
        }

    }
}
