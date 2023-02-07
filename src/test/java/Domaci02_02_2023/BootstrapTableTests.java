package Domaci02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
//    Kreirati BootstrapTableTests klasu koja ima:
//    Base url: https://s.bootsnipp.com
//    Test #1: Edit Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Edit dugme prvog reda
//    Sacekati da dijalog za Editovanje bude vidljiv
//    Popuniti formu podacima.
//    Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//    Klik na Update dugme
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//    Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//    Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #2: Delete Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Delete dugme prvog reda
//    Sacekati da dijalog za brisanje bude vidljiv
//    Klik na Delete dugme iz dijaloga
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da je broj redova u tabeli za jedan manji
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #3: Take a Screenshot
//    Koraci:
//    Ucitati stranu  /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Kreirati screenshot stranice.
//    Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png


    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl ="https://s.bootsnipp.com";

    private String firstName="Marko";

    private String lastName="Maric";

    private String middleName="Aca";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @BeforeMethod
    public void before (){
        driver.get(baseUrl);

    }

    @Test(priority = 1)
    @Description("Edit Row")

    public void  editRow () {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com", "Page is correct");
        driver.findElement(By.xpath("//tr[@id='d1']/td[5]/button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-dialog")));
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys(middleName);
        driver.findElement(By.id("up")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-dialog")));

        Assert.assertTrue(driver.findElement(By.id("f1")).getText().contains(firstName),"Invalid first name");
        Assert.assertTrue(driver.findElement(By.id("l1")).getText().contains(lastName),"Invalid last name");
        Assert.assertTrue(driver.findElement(By.id("m1")).getText().contains(middleName),"Invalid middle name");


    }

    @Test (priority = 20)
    @Description("Delete Row")

    public void deleteRow() {
        driver.get(baseUrl + "/iframe/K5yrx");
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@id ='d1']/td[6]/button"));
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com","Page is correct");
        driver.findElement(By.xpath("//tr[@id ='d1']/td[6]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='delete']/div[2]/div")));
        driver.findElement(By.id("del")).click();
        List<WebElement> rowsdel = driver.findElements(By.xpath("//tr[@id ='d1']/td[6]/button"));
        Assert.assertEquals(rowsdel.size(),rows.size()-1, "Table element is not deleted");

    }

    @Test (priority = 3)
    @Description("Take a Screenshot")

    public void takeAScreenshot() throws InterruptedException {
        driver.get(baseUrl + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com","Page is correct");

        TakesScreenshot ts=(TakesScreenshot)driver;

        try {
            FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\fjevt\\OneDrive\\Radna površina\\github\\osnove_seleniuma\\screenshots\\Screenshot.png"));
        } catch (WebDriverException e) {

        } catch (IOException e) {

        }}

    @AfterMethod
    public void afterMethod(){

        }

        @AfterClass
        public void afterClass() throws InterruptedException {
            Thread.sleep(5000);
            driver.quit();
        }

}



