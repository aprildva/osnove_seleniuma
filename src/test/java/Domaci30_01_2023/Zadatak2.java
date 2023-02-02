package Domaci30_01_2023;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
//        Napisati program koji:
//        Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//        Implicitno cekanje za trazenje elemenata je maksimalno 10s
//        Implicitno cekanje za ucitavanje stranice je 5s
//        Ucitava stranicu https://docs.katalon.com/
//        Maksimizuje prozor
//        Od html elementa cita data-theme atribut.
//                Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//        Klikce na dugme za zamenu tema
//        Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//        Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//        Ceka da se dijalog za pretragu pojavi
//        Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//        Zatvara pretrazivac


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        driver.get("https://docs.katalon.com/");


      String data =  driver.findElement(By.xpath("//html")).getAttribute("data-theme");

      if (data.equals("light")) {

          System.out.println("Jeste light");
      } else {
          System.out.println("Nije light");
      }

      driver.findElement(By.xpath("//button[contains(@class,'clean-btn toggleButton_rCf9')]")).click();

        String data1 =  driver.findElement(By.xpath("//html")).getAttribute("data-theme");

        if (data1.equals("dark")) {

            System.out.println("Jeste dark");
        } else {
            System.out.println("Nije dark");
        }


        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();

        System.out.println( "Vrednost atributa je " + wait.until(ExpectedConditions.presenceOfElementLocated(By.className("DocSearch-Input"))).getAttribute("type"));


    }
}
