package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectPractice {

    @Test
    public void practice () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/anya/Desktop/Techtorial.html");

        //check if dropdown box is as default united states


        WebElement box = driver.findElement(By.xpath("//select[@name='country']"));
        Select DefaultCountry = new Select(box);
        String ActualCountry = DefaultCountry.getFirstSelectedOption().getText().trim();
        String ExpectedCountry = "UNITED STATES";
        Assert.assertEquals(ActualCountry,ExpectedCountry);


        List<WebElement>AllCountries = DefaultCountry.getOptions();
        List <String> ActualAllCountries = new ArrayList<>();
        List <String> ExpectedAllCountries = new ArrayList<>();
        int count=0;
        for (int i =0; i<AllCountries.size(); i++){
            System.out.println( AllCountries.get(i).getText().trim());
            count++;
        }

        System.out.println(count);

        DefaultCountry.selectByVisibleText("UKRAINE");
        Thread.sleep(2000);
        DefaultCountry.selectByValue("132");//Mexico
        Thread.sleep(2000);
        DefaultCountry.selectByIndex(10);//Aruba
        Thread.sleep(2000);
    }
}
