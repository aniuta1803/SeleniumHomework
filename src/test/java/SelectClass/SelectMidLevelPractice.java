package SelectClass;

import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {

    @Test
    public void ValidateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue

14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"
 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebElement OneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        OneWay.click();
        Thread.sleep(2000);
        WebElement Passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengers = new Select(Passengers);
        passengers.selectByValue("4");


        WebElement DepartFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select AllCountries = new Select(DepartFrom);
       String ActualDepatureCity = AllCountries.getFirstSelectedOption().getText().trim();// Acapulco
       String ExpectedDepartureCity = "Acapulco";
       Assert.assertEquals(ActualDepatureCity,ExpectedDepartureCity);

    AllCountries.selectByVisibleText("Paris"); //picked Paris
    Thread.sleep(2000);

    WebElement DepartureDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
    Select Month = new Select(DepartureDate);
    Month.selectByVisibleText("August");
    Thread.sleep(2000);

    WebElement DayPicker = driver.findElement(By.xpath("//select[@name='fromDay']"));
    Select Day = new Select(DayPicker);
    Day.selectByValue("15");
    Thread.sleep(2000);

    WebElement ArriveIn = driver.findElement(By.xpath("//select[@name='toPort']"));
    Select ArriveInCity = new Select(ArriveIn);
    ArriveInCity.selectByVisibleText("San Francisco");
    Thread.sleep(2000);

    WebElement ReturnAllMonths = driver.findElement(By.xpath("//select[@name='toMonth']"));
    Select ReturnMonth = new Select(ReturnAllMonths);
    ReturnMonth.selectByVisibleText("December");
    Thread.sleep(2000);

    WebElement ReturnAllDays= driver.findElement(By.xpath("//select[@name='toDay']"));
    Select ReturnDay = new Select(ReturnAllDays);
    ReturnDay.selectByValue("15");
    Thread.sleep(2000);

    WebElement FirstClass = driver.findElement(By.xpath("//input[@value='First']"));
    FirstClass.click();

//Finding location of All Airlines and validating
    WebElement AllAirlines = driver.findElement(By.xpath("//select[@name='airline']"));
    Select Airline = new Select(AllAirlines);
    List<WebElement> ActualAirlines = Airline.getOptions();
    List<String> ExpectedAirlines = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
   for( int i =0;i< ActualAirlines.size(); i++ ){
       Assert.assertEquals(ActualAirlines.get(i).getText().trim(),ExpectedAirlines.get(i).trim());
   }

   //Choosing Unified option from the list
   Airline.selectByIndex(2);

   //Click continue
        WebElement ContinueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        ContinueButton.click();
        Thread.sleep(2000);

    //Validating message at the top of the page

        WebElement Message = driver.findElement(By.xpath("//font[@size='4']"));
        String ActualMessage = Message.getText().trim();
        String ExpectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(ActualMessage,ExpectedMessage);
        Thread.sleep(2000);

        driver.quit();

    }

    @Test
    public void ValidateOrderMessageShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue

14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"
 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebElement OneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        OneWay.click();
        Thread.sleep(2000);
        WebElement Passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
      //  Select passengers = new Select(Passengers);
       // passengers.selectByValue("4");
        BrowserUtils.selectBy(Passengers,"4","value");


        WebElement DepartFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select AllCountries = new Select(DepartFrom);
        String ActualDepatureCity = AllCountries.getFirstSelectedOption().getText().trim();// Acapulco
        String ExpectedDepartureCity = "Acapulco";
        Assert.assertEquals(ActualDepatureCity,ExpectedDepartureCity);

       // AllCountries.selectByVisibleText("Paris"); //picked Paris
       // Thread.sleep(2000);
        BrowserUtils.selectBy(DepartFrom,"Paris", "text");

        WebElement DepartureDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
       // Select Month = new Select(DepartureDate);
      //  Month.selectByVisibleText("August");
        BrowserUtils.selectBy(DepartureDate,"7", "value");

        WebElement DayPicker = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select Day = new Select(DayPicker);
        Day.selectByValue("15");
        Thread.sleep(2000);

        WebElement ArriveIn = driver.findElement(By.xpath("//select[@name='toPort']"));
      //  Select ArriveInCity = new Select(ArriveIn);
       // ArriveInCity.selectByVisibleText("San Francisco");
      BrowserUtils.selectBy(ArriveIn,"San Francisco","text");

        WebElement ReturnAllMonths = driver.findElement(By.xpath("//select[@name='toMonth']"));
     //   Select ReturnMonth = new Select(ReturnAllMonths);
     //   ReturnMonth.selectByVisibleText("December");
        BrowserUtils.selectBy(ReturnAllMonths,"December","text");
        Thread.sleep(2000);

        WebElement ReturnAllDays= driver.findElement(By.xpath("//select[@name='toDay']"));
        Select ReturnDay = new Select(ReturnAllDays);
        ReturnDay.selectByValue("15");
        Thread.sleep(2000);

        WebElement FirstClass = driver.findElement(By.xpath("//input[@value='First']"));
        FirstClass.click();

//Finding location of All Airlines and validating
        WebElement AllAirlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select Airline = new Select(AllAirlines);
        List<WebElement> ActualAirlines = Airline.getOptions();
        List<String> ExpectedAirlines = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for( int i =0;i< ActualAirlines.size(); i++ ){
            Assert.assertEquals(ActualAirlines.get(i).getText().trim(),ExpectedAirlines.get(i).trim());
        }

        //Choosing Unified option from the list
        Airline.selectByIndex(2);

        //Click continue
        WebElement ContinueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        ContinueButton.click();
        Thread.sleep(2000);

        //Validating message at the top of the page

        WebElement Message = driver.findElement(By.xpath("//font[@size='4']"));
        String ActualMessage = Message.getText().trim();
        String ExpectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(ActualMessage,ExpectedMessage);
        Thread.sleep(2000);

        driver.quit();
}
}