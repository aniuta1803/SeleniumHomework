import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Project1_Task3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.saucedemo.com/");
        WebElement UserName = driver.findElement(By.xpath("//input[@ id='user-name']"));
        UserName.sendKeys("standard_user");

        WebElement Password = driver.findElement(By.xpath("//input[@ id='password']"));
        Password.sendKeys("secret_sauce");

        WebElement Login = driver.findElement(By.xpath("//input[@ id='login-button']"));
        Thread.sleep(2000);
        Login.click();

        String ActualURL = driver.getCurrentUrl();
        String ExpectedUEL ="https://www.saucedemo.com/inventory.html";
        System.out.println(ActualURL.equals(ExpectedUEL)? "URL Matches": "URL DOESN'T MATCH");
        driver.quit();
    }
}
