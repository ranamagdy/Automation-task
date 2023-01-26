package POM;

import org.openqa.selenium.By;
public class NewCustomerPage {
    public void clickOnNewCustomer() {
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
    }
    public void FillCustomerName(String name)
    {
        BaseClass.getWebDriver().findElement(By.name("name")).sendKeys(name);
    }
    public void FillCustomerAddress(String address)
    {
        BaseClass.getWebDriver().findElement(By.name("addr")).sendKeys(address);
    }
    public void FillCustomerCity(String city)
    {
        BaseClass.getWebDriver().findElement(By.name("city")).sendKeys(city);
    }
    public void FillCustomerState(String state)
    {
        BaseClass.getWebDriver().findElement(By.name("state")).sendKeys(state);
    }
    public void FillCustomerPIN(String pin)
    {
        BaseClass.getWebDriver().findElement(By.name("pinno")).sendKeys(pin);
    }
    public void SubmitBtn()
    {
        BaseClass.getWebDriver().findElement(By.name("sub")).click();
    }
    public void ResetBtn()
    {
        BaseClass.getWebDriver().findElement(By.name("res")).click();
    }




}

