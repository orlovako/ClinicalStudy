package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BaselinePage {
    private WebDriver driver;

    public BaselinePage(WebDriver driver){
        this.driver = driver;
    }

    public void enterVisitDate(String visitDate){
        driver.findElement(By.xpath("//input[@id='VisitDate_I']")).sendKeys(visitDate);
    }

    public void enterVisitTime(String visitTime){
        driver.findElement(By.xpath("//input[@id='VisitTime_I']")).sendKeys(visitTime);
    }

    public void clickVisitTime(){
        driver.findElement(By.xpath("//div[@id='VisitTime_B-2']")).click();
    }

    public void enterExpectedVisitDate(String expectedVisitDate){
        driver.findElement(By.xpath("//img[@id='ExpectedVisitDate_B-1Img']")).click();
        driver.findElement(By.xpath("//td[@id='ExpectedVisitDate_DDD_C_mc_37']")).click();
        driver.findElement(By.xpath("//input[@id='ExpectedVisitDate_I']")).sendKeys(Keys.ENTER);
    }

    public void saveButton(){
        driver.findElement(By.xpath("//div[@id='btnSave_Visit442_CD']")).click();
    }

    public String editkButton(){
        return driver.findElement(By.xpath("//div[@id='btnEditVisit_CD']")).getText();
    }

    public void enterDateOfBirth(String dateBirth){
        driver.findElement(By.xpath("//input[@id='DateOfBirth_I']")).sendKeys(dateBirth);
    }

    public void selectRace(){
        driver.findElement(By.xpath("//input[@id='Race_I']")).sendKeys("Asian");
    }

    public void selectSex(String sex){
        driver.findElement(By.xpath("//input[@id='Sex_I']")).sendKeys(sex);
    }

    public void enterOther(String otherData){
        driver.findElement(By.xpath("//textarea[@id='Other_I']")).sendKeys(otherData);
    }

    public void saveButtonTwo(){
        driver.findElement(By.xpath("//div[@id='btnSave1147_CD']")).click();
    }

    public String editkButtonTwo(){
        return driver.findElement(By.xpath("//div[@id='btnEditDemog_CD']")).getText();
    }

    public void enterActualTime(){
        driver.findElement(By.xpath("//div[@id='ActualTime_B-3']")).click();
    }

    public void enterHeight(String height){
        driver.findElement(By.xpath("//input[@id='Height_I']")).sendKeys(height);
    }

    public void enterWeight(String weight){
        driver.findElement(By.xpath("//input[@id='Weight_I']")).sendKeys(weight);
    }

    public void enterTemperature(String temperature){

        driver.findElement(By.xpath("//input[@id='Temperature_I']")).sendKeys(temperature);
    }

    public void enterHeartRate(String heartRate){
        driver.findElement(By.xpath("//input[@id='HeartRate_I']")).sendKeys(heartRate);
    }

    public void enterSystolicPressure(String sPressure){
        driver.findElement(By.xpath("//input[@id='BloodPressureSystolic_I']")).sendKeys(sPressure);
    }

    public void enterDiastolicPressure(String dPressure){
        driver.findElement(By.xpath("//input[@id='BloodPressureDiastolic_I']")).sendKeys(dPressure);
    }

    public void clickSaveButtonThree(){
        driver.findElement(By.xpath("(//div[@class=\"dxbButton_DarkPink_ClinicalStudyTheme dxbButtonSys dxbTSys\"])[last()]")).click();
    }

    public String editkButtonThree(){
        return driver.findElement(By.xpath("//div[@id='btnEditVitals_CD']")).getText();
    }
}
