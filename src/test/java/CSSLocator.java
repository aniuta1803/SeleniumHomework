import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement Search = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        Search.sendKeys("Watch");

        WebElement SearchButton = driver.findElement(By.cssSelector(".wt-input-btn-group__btn"));
        SearchButton.click();

        String ActualURL= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        String ExpectedURL ="https://www.etsy.com/search?q=watch&ref=search_bar";
        System.out.println(ActualURL.equals(ExpectedURL)? "Passed": "Failed");

    }
}
