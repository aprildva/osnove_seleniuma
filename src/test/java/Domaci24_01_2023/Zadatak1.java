package Domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//
//        Maksimizirati prozor
//        Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//        Prijavite se na sistem
//        Username: Admin
//        Password: admin123
//        Cekanje od 5s
//        U input za pretragu iz navigacije unesite tekst Me
//        Kliknite na prvi rezultat pretrage (to ce biti Time)
//        Cekanje od 1s
//        Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//        Klinkite na logout
//        Cekanje od 5s
//        Zatvorite pretrazivac


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("Admin");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("admin123");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[contains(@class,'oxd-form-actions orangehrm-login-action')]/button")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[contains(@class,'oxd-input oxd-input--active')]")).sendKeys("Me");

        Thread.sleep(2000);

        driver.findElement(By.className("oxd-main-menu-item")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-caret-down-fill oxd-userdropdown-icon')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        Thread.sleep(2000);

        driver.quit();









    }
}
