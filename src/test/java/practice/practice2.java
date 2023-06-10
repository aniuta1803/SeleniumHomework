package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class practice2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait time
        driver.get("https://www.youtube.com/");

        WebElement searchField = driver.findElement(By.xpath("//input[@id='search']"));
        searchField.sendKeys("romantic movies");
        WebElement SearchButton= driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        Thread.sleep(2000);
        SearchButton.click();

        List<WebElement> Movies = driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement movie:Movies){
            if(movie.getAttribute("title").contains("SEDUCTION")){
                Thread.sleep(2000);
                movie.click();
                movie.sendKeys(Keys.ARROW_DOWN);
            }
        }
        WebElement Skip = driver.findElement(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text'] "));
        Thread.sleep(5000);
        Skip.click();
    }
}
