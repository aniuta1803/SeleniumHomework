package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement Appointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        Appointment.click();

        WebElement name = driver.findElement(By.xpath("//input[@value='John Doe']"));
        name.getAttribute("value");
        System.out.println(name.getAttribute("value"));//john Doe  //here our attribute is value and joe Doe is actual value of that attribute value =joe doe

        System.out.println(name.getAttribute("type"));//text   //here our attribute is 'type' and value is 'text'


    }
}
