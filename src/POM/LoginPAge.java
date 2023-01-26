package POM;

import org.openqa.selenium.By;

public class LoginPAge {
    public void login(String id  , String password )
    {
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(id);
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
        BaseClass.getWebDriver().findElement(By.name("btnLogin")).click();
    }
    public void Reset(String id , String password)
    {
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(id);
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
        BaseClass.getWebDriver().findElement(By.name("btnReset")).click();
    }
    public void SetData(String id  , String password )
    {
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(id);
        BaseClass.getWebDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);

    }

}