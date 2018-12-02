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

    public void clickAddPatient(WebDriver driver){
        driver.findElement(By.xpath("//img[@alt='Add a New Patient']")).click();
    }
    public static void pause(Integer time){
        try{Thread.sleep(time);}
        catch(InterruptedException ignored){}
    }



}
