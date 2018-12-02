package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaselinePage {

    public void enterVisitDate(WebDriver driver, String visitDate){
        driver.findElement(By.xpath("//input[@id='VisitDate_I']")).sendKeys(visitDate);
    }

    public void enterVisitTime(WebDriver driver, String visitTime){
        driver.findElement(By.xpath("//input[@id='VisitTime_I']")).sendKeys(visitTime);
    }

    public void clickVisitTime(WebDriver driver){
        driver.findElement(By.xpath("//div[@id='VisitTime_B-2']")).click();
    }

    public void enterExpectedVisitDate(WebDriver driver, String expectedVisitDate){
        driver.findElement(By.xpath("//input[@id='ExpectedVisitDate_I']")).sendKeys(expectedVisitDate);
    }

    public void saveButton(WebDriver driver){
        driver.findElement(By.xpath("//div[@id='btnSave_Visit442_CD']")).click();
    }

    public String editkButton(WebDriver driver){
        return driver.findElement(By.xpath("//div[@id='btnEditVisit_CD']")).getText();
    }
}
