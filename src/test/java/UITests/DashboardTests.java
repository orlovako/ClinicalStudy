package UITests;
import Pages.DashboardPage;
import Pages.NewPatientPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class DashboardTests {
    private static String driverPath = "C:\\Users\\Jamie\\IdeaProjects\\ClinicalStudy\\src\\main\\resources\\chromedriver.exe";
    private static String URL = "https://demos.devexpress.com/RWA/ClinicalStudy/DataCapture/Dashboard";
    private static WebDriver driver;

    private static String selectAccountXpath = "//img[@id='loginPhotoP_dmitchell']";
    private static String enterAccouuntXpath = "//div[@id='Logondmitchell_CD']";

    private DashboardPage dashboardPage;
    private NewPatientPage newPatientPage;

    private String patientInitials = "TB";
    private Boolean enrolled = true;
    private String enrollDate = "11/30/2018";

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
        newPatientPage = new NewPatientPage();

        dashboardPage.clickAddPatient(driver);
        newPatientPage.enterPatientInitials(driver, patientInitials);
        newPatientPage.selectEnrolled(driver, enrolled);
        newPatientPage.enterEnrollDate(driver, enrollDate);
        newPatientPage.clickSaveButton(driver);

        try{Thread.sleep(3000);}
        catch(InterruptedException ignored){}

        assertEquals("Patient Information - Subj A" + newPatientPage.getPatientNumber(driver), driver.findElement(By.xpath("//h2")).getText());
    }

    @Test
    public void createEmptyPatientCard(){
        dashboardPage = new DashboardPage();
        newPatientPage = new NewPatientPage();
        dashboardPage.clickAddPatient(driver);
        newPatientPage.clickSaveButton(driver);
        assertEquals("Please enter Patient Initials", newPatientPage.getErrorText(driver));
    }

    @AfterClass
    public static void closePage(){
        driver.quit();
    }
}
