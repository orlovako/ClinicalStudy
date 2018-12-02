package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class NewPatientPage extends HtmlElement {

    private WebDriver driver;

    public NewPatientPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSaveButton(){
        driver.findElement(By.xpath("//div[@id='btnSave_CD']")).click();
    }

    public String getErrorText(){
        return driver.findElement(By.xpath("//td[@id='PatientInitials_ETC']")).getText();
    }

    public String getPatientNumber(){
        return driver.findElement(By.xpath("//*[@id='PatientNumber']")).getAttribute("value");
    }

    public void enterPatientInitials(String pathientInitials){
        driver.findElement(By.xpath("//input[@id='PatientInitials_I']")).sendKeys(pathientInitials);
    }

    public void selectEnrolled(Boolean enrolled){
        if (enrolled)
        driver.findElement(By.xpath("//span[@id='IsEnrolled_S_D']")).click();
    }

    public void enterEnrollDate(String enrollDate){
        driver.findElement(By.xpath("//input[@id='EnrollDate_I']")).sendKeys(enrollDate);
    }

    public void clickBaseline(){
        driver.findElement(By.xpath("//a[@id='PatientVisitsTabt_AT1T']")).click();
    }


}
