package Domaci27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//
//        Zadatak
//        Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik na svako dugme od PRIMARY do DARK
//        Sacekati da se toasts u desnom gornjem uglu pojavi
//        Pauza izmedju klikova 1s
//        Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");


        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[1]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Primary Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts ");
        }



        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[2]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Secondary Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }




        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[3]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Success Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }



        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[4]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Danger Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }




        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[5]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Warning Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }



        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[6]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Info Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }



        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[7]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Light Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }



        driver.findElement(By.xpath("//div[contains(@class,'container text-center')]/button[8]")).click();
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//div[contains(text(), 'Dark Basic Example')]")).isDisplayed()) {
            System.out.println("Vidi se toasts");
        } else {
            System.out.println("Ne vidi se toasts");
        }

        driver.quit();

    }
}
