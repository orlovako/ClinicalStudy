package UITests;
import Pages.BaselinePage;
import Pages.DashboardPage;
import Pages.NewPatientPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


import static Pages.DashboardPage.pause;
import static org.junit.Assert.assertEquals;

public class DashboardTests {
    private static String driverPath = "C:\\Users\\Jamie\\IdeaProjects\\ClinicalStudy\\src\\main\\resources\\chromedriver.exe";
    private static String URL = "https://demos.devexpress.com/RWA/ClinicalStudy/DataCapture/Dashboard";
    private static String URLaccounts = "https://demos.devexpress.com/RWA/ClinicalStudy/";
    private static WebDriver driver;

    private static String selectAccountXpath = "//img[@id='loginPhotoP_dmitchell']";
    private static String enterAccouuntXpath = "//div[@id='Logondmitchell_CD']";
    private static String logoutXpath = "//div[@id='btnLogout_CD']";

    private DashboardPage dashboardPage;
    private NewPatientPage newPatientPage;
    private BaselinePage baselinePage;

    private String patientInitials = "TB";
    private Boolean enrolled = true;
    private String enrollDate = "11/30/2018";
    private String baselinePath = "//a[@id='PatientVisitsTabt_T1T']";
    private String visitDate = "11/30/2018";
    private String expectedVisitDate = "11/30/2018";
    private String dateBirth = "12/12/2001";
    private String sex = "Male";
    private String otherData = "He likes cats";
    private String height = "180";
    private String weight = "70";
    private String temperature = "37";
    private String heartRate = "80";
    private String sPressure = "100";
    private String dPressure = "100";

    @BeforeClass
    public static void login(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.xpath(selectAccountXpath)).click();
        driver.findElement(By.xpath(enterAccouuntXpath)).click();
        assertEquals(URL, driver.getCurrentUrl());
    }

    @Test
    public void createPatientCard(){
        driver.get(URL);
        dashboardPage = new DashboardPage();
        newPatientPage = new NewPatientPage(driver);
        dashboardPage.clickAddPatient(driver);
        newPatientPage.enterPatientInitials(patientInitials);
        newPatientPage.selectEnrolled(enrolled);
        newPatientPage.enterEnrollDate(enrollDate);
        newPatientPage.clickSaveButton();
        pause(3000);
        assertEquals("Patient Information - Subj A" + newPatientPage.getPatientNumber(), driver.findElement(By.xpath("//h2")).getText());
    }

    @Test
    public void enterVisitInformation(){
        driver.get(URL);
        dashboardPage = new DashboardPage();
        newPatientPage = new NewPatientPage(driver);
        baselinePage = new BaselinePage(driver);
        dashboardPage.clickAddPatient(driver);
        newPatientPage.enterPatientInitials(patientInitials);
        newPatientPage.selectEnrolled(enrolled);
        newPatientPage.enterEnrollDate(enrollDate);
        newPatientPage.clickSaveButton();
        pause(300);
        driver.findElement(By.xpath(baselinePath)).click();
        baselinePage.enterVisitDate( visitDate);
        baselinePage.clickVisitTime();
        baselinePage.enterExpectedVisitDate(expectedVisitDate);
        pause(300);
        assertEquals("EDIT", baselinePage.editkButton());
    }

    @Test
    public void enterDemographicsCRF(){
        driver.get(URL);
        dashboardPage = new DashboardPage();
        newPatientPage = new NewPatientPage(driver);
        baselinePage = new BaselinePage(driver);
        dashboardPage.clickAddPatient(driver);
        newPatientPage.enterPatientInitials(patientInitials);
        newPatientPage.selectEnrolled(enrolled);
        newPatientPage.enterEnrollDate(enrollDate);
        newPatientPage.clickSaveButton();
        pause(300);
        driver.findElement(By.xpath(baselinePath)).click();
        baselinePage.enterDateOfBirth(dateBirth);
        baselinePage.selectRace();
        baselinePage.selectSex(sex);
        baselinePage.enterOther(otherData);
        baselinePage.saveButtonTwo();
        pause(300);
        assertEquals("EDIT", baselinePage.editkButtonTwo());
    }

    @Test
    public void enterVitalsCRF(){
        driver.get(URL);
        dashboardPage = new DashboardPage();
        newPatientPage = new NewPatientPage(driver);
        baselinePage = new BaselinePage(driver);
        dashboardPage.clickAddPatient(driver);
        newPatientPage.enterPatientInitials(patientInitials);
        newPatientPage.selectEnrolled(enrolled);
        newPatientPage.enterEnrollDate(enrollDate);
        newPatientPage.clickSaveButton();
        pause(300);
        driver.findElement(By.xpath(baselinePath)).click();
        baselinePage.enterActualTime();
        baselinePage.enterHeight(height);
        baselinePage.enterWeight(weight);
        baselinePage.enterTemperature(temperature);
        baselinePage.enterHeartRate(heartRate);
        baselinePage.enterSystolicPressure(sPressure);
        baselinePage.enterDiastolicPressure(dPressure);
        baselinePage.clickSaveButtonThree();
        pause(300);
        assertEquals("EDIT", baselinePage.editkButtonThree());
    }

    @Test
    public void createEmptyPatientCard(){
        driver.get(URL);
        dashboardPage = new DashboardPage();
        newPatientPage = new NewPatientPage(driver);
        dashboardPage.clickAddPatient(driver);
        newPatientPage.clickSaveButton();
        assertEquals("Please enter Patient Initials", newPatientPage.getErrorText());
    }

    @AfterClass
    public static void closePage(){
        driver.findElement(By.xpath(logoutXpath)).click();
        assertEquals(driver.getCurrentUrl(), URLaccounts);
        driver.quit();
    }
}
