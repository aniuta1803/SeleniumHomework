import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Project1_Task2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.saucedemo.com/");
        WebElement UserName = driver.findElement(By.xpath("//input[@ id='user-name']"));
        UserName.sendKeys("Java");

        WebElement Password = driver.findElement(By.xpath("//input[@ id='password']"));
        Password.sendKeys("Selenium");

        WebElement Login = driver.findElement(By.xpath("//input[@ id='login-button']"));
        Thread.sleep(2000);
        Login.click();

        WebElement EpicSadFace = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String ActualEpicSadFAce = EpicSadFace.getText();
        String ExpectedEpicSadFace ="Epic sadface: Username and password do not match any user in this service";

        System.out.println(ActualEpicSadFAce.equals(ExpectedEpicSadFace)?"Epic Sadface passed":"Epic sadface failed");

        driver.quit();



    }
}
