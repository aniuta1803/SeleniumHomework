import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Project1_Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/text-box");
        WebElement FullName = driver.findElement(By.xpath("//input[@id='userName']"));
        FullName.sendKeys("Anna Tumbev");
        String actualFullName = FullName.getText();
        String ExpectedFullName = "Anna Tumbev";
        if (actualFullName.equals(ExpectedFullName)){
            System.out.println("Full NAme passed");
        }else {
            System.out.println("full name didn't pass");
        }

        WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        Email.sendKeys("aaa123@gmail.com");
      String ActualEmail= Email.getAttribute("value");
        String ExpectedEmail= "aaa123@gmail.com";
       System.out.println(ActualEmail.equals(ExpectedEmail)?"Email Passed":"Email Failed");


        WebElement CurrentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        CurrentAddress.sendKeys("1111 Main St, Des Plaines,IL 12345");
        String ActualCurrentAddress = CurrentAddress.getAttribute("value");
        String ExpectedCurrentAddress= "1111 Main St, Des Plaines,IL 12345";
        System.out.println(ActualCurrentAddress.equals(ExpectedCurrentAddress)?"Actual Address Passed":"Actual Address Failed");


        WebElement PermanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        PermanentAddress.sendKeys("3333 W Grand Ave, Apt#1 Chicago,IL 33456");
        String ActualPermanentAddress= PermanentAddress.getAttribute("value");
        String ExpectedPermanentAddress = "3333 W Grand Ave, Apt#1 Chicago,IL 33456";
        System.out.println(ActualPermanentAddress.equals(ExpectedPermanentAddress)?"Permanent Address Passed": "Permanent Address Failed");

        WebElement SubmitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(2000);
        SubmitButton.click();

        Thread.sleep(2000);
       driver.quit();


    }
}
