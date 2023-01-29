package Domaci26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) {

//        Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element
//        obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//        POMOC: Brisite elemente odozdo.
//        (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        driver.manage().window().maximize();

        for (int i = 0; i < 5; i++) {

            int brojac=5;

            driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]/div[last()]/button")).click();

            boolean elementExist = true;

        try {

            WebElement div=driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]/div["+brojac+"]"));

            }

         catch (NoSuchElementException error) {
            elementExist=false;

           }

            if(elementExist){

            System.out.println("Element postoji");
        }
        else {
            System.out.println("Element ne postoji");
        }

        brojac--;

        }

        driver.quit();


    }
}
