package Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.BaseClass;
import POM.LoginPAge;
import POM.NewCustomerPage;

public class NewCustomerTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        BaseClass Bc = new BaseClass();
        Bc.setup2();
        driver =BaseClass.getWebDriver();

    }

    //Name cannot be empty
    @Test (priority = 2)
    public void missingCustomerName()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.FillCustomerName("");
        BaseClass.getWebDriver().findElement(By.name("addr")).click();
        String msg = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();


        assertEquals(msg, "Customer name must not be blank");

    }

    //Name cannot be numeric
    @Test (priority = 3)
    public void NumericCustomerName()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.FillCustomerName("12336");

        String msg = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();


        assertEquals(msg, "Numbers are not allowed");

    }

    //Enter Special Character In NAME Field
    @Test (priority = 3)

    public void SpecialcharcterCustomerName()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.FillCustomerName("**#-");

        String msg = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();


        assertEquals(msg, "Special characters are not allowed");

    }

    //Name cannot have first character as blank space
    @Test (priority = 4)
    public void FirstBlankCustomerName()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.FillCustomerName(" kjfkfj");

        String msg = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();


        assertEquals(msg, "First character can not have space");

    }

    //Address cannot be empty
    @Test (priority = 5)
    public void missingAddress()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.FillCustomerAddress("");
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).click();

        String msg = driver.findElement(By.xpath("//*[@id=\"message3\"]")).getText();


        assertEquals(msg, "Address Field must not be blank");

    }

    //Address cannot have first blank space
    @Test (priority = 6)
    public void FistSpaceAddress()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.FillCustomerAddress(" 26 mama st");
        String msg = driver.findElement(By.xpath("//*[@id=\"message3\"]")).getText();
        assertEquals(msg, "First character can not have space");

    }

    //Check Radio Button
    @Test (priority = 6)
    public void CheckRadioBtn() throws InterruptedException
    {
        WebElement btnMale = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
        WebElement btnFemale = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        String genderToBeSelected ="Male";
        if (genderToBeSelected.equalsIgnoreCase("male"))
        {
            btnMale.click();
        }
        else
        {
            btnFemale.click();
        }

    }

    @Test (priority = 7)
    //click on submit button
    public void submitBtnwithMissingFeilds()
    {
        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.SubmitBtn();
        Alert alert=driver.switchTo().alert();
        String TextOnAlert=alert.getText();
        System.out.println(TextOnAlert);
        alert.accept();
        assertEquals(TextOnAlert,"please fill all fields");
    }
    //Click on reset button
    @Test(priority = 8)
    public void CheckReset() {

        NewCustomerPage NCP =new NewCustomerPage();
        NCP.clickOnNewCustomer();
        NewCustomerPage NC =new NewCustomerPage();
        NC.ResetBtn();

    }


    @AfterTest
    public void TearDown() {
        driver.close();
    }


}
