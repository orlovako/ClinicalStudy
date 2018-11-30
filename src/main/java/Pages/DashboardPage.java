package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class DashboardPage extends HtmlElement {

    @FindBy(xpath="//img[@alt='Add a New Patient']")
    public WebElement addPatient;

    @FindBy(xpath="//div[@id='btnSave_CD']")
    public static WebElement saveButton;

    @FindBy(xpath="//input[@id='PatientInitials_I']")
    public TextInput patientInitials;

    public void clickAddPatient(WebDriver driver){
        driver.findElement(By.xpath("//img[@alt='Add a New Patient']")).click();
    }




}
