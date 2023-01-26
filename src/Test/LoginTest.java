package Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.BaseClass;
import POM.LoginPAge;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        BaseClass Bc = new BaseClass();
        Bc.setup1();
        driver =BaseClass.getWebDriver();


    }



    // Login with a valid username and vaild password .
    @Test(priority = 10)
    public void VerifyLogin() {

        LoginPAge LG = new LoginPAge();
        LG.login("mngr472981","tAmezAg");
        String loginsuccessfuly = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).getText();
        assertEquals(loginsuccessfuly, loginsuccessfuly);

    }



    // verify Reset button
    @Test(priority = 1)
    public void CheckReset() {

        LoginPAge LG = new LoginPAge();
        LG.Reset("mngr472981","tAmezAg");

    }

    // Login with valid id and missing password
    @Test (priority = 2)
    public void missingPasswordFeild()  {
        LoginPAge LG = new LoginPAge();
        LG.login("mngr472981","");


        //Alert alert=driver.switchTo().alert();
       // String TextOnAlert=alert.getText();
        //System.out.println(TextOnAlert);
       // alert.accept();
       // assertEquals(TextOnAlert,TextOnAlert);
        String msgPassword = driver.findElement(By.id("message18")).getText();
        assertEquals(msgPassword, "Password must not be blank");

    }



    //Login with valid password and missing id
    @Test(priority = 4)
    public void missingIdFeild()  {

        LoginPAge LG = new LoginPAge();
        LG.login("","tAmezAg");

        Alert alert=driver.switchTo().alert();
        String TextOnAlert=alert.getText();
       alert.accept();
       assertEquals(TextOnAlert,"User or Password is not valid");
    }


    //  leave both the password and id are empty without click on login
    @Test(priority =7 )
    public void EmptyFeildsWithoutLogin() {

        LoginPAge LG = new LoginPAge();

        LG.SetData("","");
        // when click on the same page
        driver.findElement(By.xpath("/html/body")).click();
        String msgId = driver.findElement(By.id("message23")).getText();
        String msgPassword = driver.findElement(By.id("message18")).getText();
        System.out.println(msgId);
        assertEquals(msgId, "User-ID must not be blank");
        assertEquals(msgPassword, "Password must not be blank");

    }


    //Login with leave both the password and id are empty fields.
    @Test(priority = 4)
    public void EmptyFeildsWithLogin() {

        LoginPAge LG = new LoginPAge();
        LG.login("","");


        //when click on login button .

        Alert alert=driver.switchTo().alert();
        String TextOnAlert=alert.getText();
        System.out.println(TextOnAlert);
        alert.accept();
        assertEquals(TextOnAlert,"User or Password is not valid");

    }


    //Login with valid id and invalid password

    @Test(priority = 9)
    public void LoinwithValidId() {

        LoginPAge LG = new LoginPAge();
        LG.login("mngr472981","23698");


        Alert alert=driver.switchTo().alert();
        String TextOnAlert=alert.getText();
        System.out.println(TextOnAlert);
        alert.accept();
        assertEquals(TextOnAlert,"User or Password is not valid");


    }


    //Login with invalid id and valid password .
    @Test(priority = 6)

    public void LoinwithValidPassword() {

        LoginPAge LG = new LoginPAge();
        LG.login("mama12554","tAmezAg");
        Alert alert=driver.switchTo().alert();
        String TextOnAlert=alert.getText();
        System.out.println(TextOnAlert);
        alert.accept();
        assertEquals(TextOnAlert,"User or Password is not valid");

    }
    @AfterTest
    public void TearDown() {
        driver.quit();
    }



}