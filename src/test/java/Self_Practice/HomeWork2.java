package Self_Practice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.concurrent.Callable;

public class HomeWork2 {
    @Test
    public static void Test1() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle.equals(expectedTitle));
        WebElement Username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        Username.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        WebElement LoginButton = driver.findElement(By.cssSelector(".button"));
        LoginButton.click();
        String ActulaTitle2 = driver.getTitle();
        String ExpectedTitle2 = "Web Orders";
        Assert.assertEquals(ActulaTitle2, ExpectedTitle2);

        WebElement Header = driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        String ActualHEader = BrowserUtils.getText(Header);
        String ExpectedHeader = "List of All Orders";
        Assert.assertEquals(ActualHEader, ExpectedHeader);
    }

    @Test

    public static void Test2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement Username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        Username.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        WebElement LoginButton = driver.findElement(By.cssSelector(".button"));
        LoginButton.click();

        WebElement AllProducts = driver.findElement(By.linkText("View all products"));
        Thread.sleep(1000);
        Assert.assertTrue(AllProducts.isEnabled());
        AllProducts.click();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath("//h2[contains (text(),'List of Products')]"));
        String ActualHeader = BrowserUtils.getText(header);
        String ExpectedHeader = "List of Products";
        Assert.assertEquals(ActualHeader, ExpectedHeader);
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));


    }

    @Test

    public static void Test3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement Username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        Username.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        WebElement LoginButton = driver.findElement(By.cssSelector(".button"));
        LoginButton.click();

        WebElement ViewAllOrders = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        String AllOrdersLink=   ViewAllOrders.getAttribute("href");
        System.out.println(ViewAllOrders.getAttribute("href"));

        WebElement ViewAllProducts = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
       String AllProductLink= ViewAllProducts.getAttribute("href");
        System.out.println(ViewAllProducts.getAttribute("href"));

        WebElement Orders = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        String OrdersLink = Orders.getAttribute("href");
        System.out.println(Orders.getAttribute("href"));
        Assert.assertTrue(AllOrdersLink.contains("Default.aspx"));
        Assert.assertTrue(AllProductLink.contains("Products.aspx"));
        Assert.assertTrue(OrdersLink.contains("Process.aspx"));
    }
    @Test
    public void Task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement Username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        Username.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        WebElement LoginButton = driver.findElement(By.cssSelector(".button"));
        LoginButton.click();

        WebElement OrderButton = driver.findElement(By.linkText("Order"));
       OrderButton.click();
       WebElement ProductList = driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
        Select AllProductList = new Select(ProductList);
       BrowserUtils.selectBy(ProductList,"ScreenSaver", "text");

       WebElement Quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
       Quantity.clear();
       Thread.sleep(2000);
       Quantity.sendKeys("5");

       WebElement CustomerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
       CustomerName.sendKeys("CodeFish IT School");

       WebElement Street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
       Street.sendKeys("2200 E devon");

       WebElement City = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
       City.sendKeys("Des Plaines");

       WebElement State = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
       State.sendKeys("Illinois");
       Thread.sleep(1000);
       WebElement ZipCode = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
       ZipCode.sendKeys("60018");
       WebElement Card = driver.findElement(By.xpath("//input[@value='MasterCard']"));
       Card.click();
       Thread.sleep(2000);
       WebElement CardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
       CardNumber.sendKeys("444993876233");
       WebElement ExpirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
       ExpirationDate.sendKeys("03/24");
       WebElement ProcessButton = driver.findElement(By.linkText("Process"));
       ProcessButton.click();
        WebElement Message = driver.findElement(By.xpath(" //strong[contains(text(),'New order has been successfully added.')]"));
        String ActualMessage=  BrowserUtils.getText(Message);
        String ExpectedMessage = "New order has been successfully added.";
        Assert.assertEquals(ActualMessage,ExpectedMessage);

        WebElement ViewAllOrdersButton = driver.findElement(By.linkText("View all orders"));
        ViewAllOrdersButton.click();

        List<WebElement> ViewAllOrdersActual=driver.findElements(By.xpath("//tr[2]//td"));
        List<String> ViewAllOrdersExpected = Arrays.asList("CodeFish IT School","ScreenSaver","5","06/02/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24");

        for(int i =1, j=0; i< ViewAllOrdersActual.size()-1; i++, j++ ){

                System.out.println(BrowserUtils.getText(ViewAllOrdersActual.get(i)) );
                Assert.assertEquals(ViewAllOrdersActual.get(i).getText(),ViewAllOrdersExpected.get(j));
            }
            }
        }







