package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    static WebDriver driver;

    @BeforeTest
    public void setup1() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rana magdy\\Desktop\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/");


    }
    public void setup2() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");


    }
    public static WebDriver getWebDriver() {
        return driver;
    }

}