package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPAthRealHealthProject {
    public static void main(String[] args) throws InterruptedException {
                  /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or .=   XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://katalon-demo-cura.herokuapp.com/");
      //  WebElement MakeAppointment= driver.findElement(By.xpath("//a[@ id ='btn-make-appointment']"));
      //  Thread.sleep(2000);

        //CSS
        WebElement makeAppointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        Thread.sleep(2000);
       makeAppointment.click();
        WebElement Username = driver.findElement(By.xpath("//input[@ id ='txt-username']"));
        Username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@ id ='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement LoginButton = driver.findElement(By.xpath("//button[@ id ='btn-login']"));
        Thread.sleep(2000);
        LoginButton.click();

        WebElement Facility = driver.findElement(By.xpath("//select[@ id ='combo_facility']"));
        Facility.sendKeys("Hongkong CURA Helthcare Center");

        WebElement checkbox = driver.findElement(By.xpath("//input[@ id ='chk_hospotal_readmission']"));
        if(checkbox.isDisplayed()&& !checkbox.isSelected()){
            checkbox.click();
        }
        System.out.println(checkbox.isSelected()?"selected":"not selected");

        WebElement medicaid = driver.findElement(By.xpath("//input[@ id ='radio_program_medicaid']"));
        Thread.sleep(2000);
        medicaid.click();

        WebElement data = driver.findElement(By.xpath("//input[@ id ='txt_visit_date']"));
        data.sendKeys("01/01/2023");

        WebElement Comment = driver.findElement(By.xpath("//textarea[@ id ='txt_comment']"));
        Comment.sendKeys(" I would like to make an appointment");

        //CSS with Class
      /*  WebElement BookAppontmentButton = driver.findElement(By.xpath("//button[@ id ='btn-book-appointment']"));
        Thread.sleep(2000);
        BookAppontmentButton.click();  instead we will use css class : */
        WebElement BookAppontmentButton = driver.findElement(By.cssSelector(".btn-default"));
        Thread.sleep(2000);
        BookAppontmentButton.click();

        WebElement AppointmentConfirmation=driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String ActualHeader= AppointmentConfirmation.getText();
        String Expected = "Appointment Confirmation";
        System.out.println(ActualHeader.equals(Expected)? "Header Passed": "Header Failed");

        WebElement h2 = driver.findElement(By.xpath("//p[.='Please be informed that your appointment has been booked as following:']"));
        System.out.println( h2.getText());

        WebElement h3 = driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println( h3.getText());

        WebElement h4 = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(h4.getText());

        WebElement h5 = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(h5.getText());

        WebElement h6= driver.findElement(By.xpath("//p[.='01/01/2023']"));
        System.out.println( h6.getText());

        WebElement h7 = driver.findElement(By.xpath("//p[.=' I would like to make an appointment']"));
        System.out.println( h7.getText());

        WebElement HomePage = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        Thread.sleep(2000);
        HomePage.click();

        System.out.println(driver.getCurrentUrl());

        driver.quit();





    }
}
