package Domaci26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter
//        Validira da li je novi todo dodat na stranici
//        Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//        Validirati da je na kraju programa broj todo-a na stranici 0.
//        Cekanje od 5s
//        Zatvorite pretrazivac


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions actions= new Actions(driver);


        ArrayList<String> todoovi = new ArrayList<>();

        todoovi.add("Visit Paris");
        todoovi.add("Visit Prague");
        todoovi.add("Visit London");
        todoovi.add("Visit New York");
        todoovi.add("Visit Belgrade");
        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");
        driver.manage().window().maximize();

        for (int i = 0; i < todoovi.size(); i++) {

            int brojac=2;
            driver.findElement(By.className("new-todo")).sendKeys(todoovi.get(i));
            driver.findElement(By.xpath("//a[contains(text(),'Completed')]")).click();
            brojac++;

            if (driver.findElement(By.xpath("//ul[contains(@class,'todo-list')]/li["+brojac+"]/div/label")).isDisplayed()) {
                System.out.println("Novi todo je dodat ");
            } else {
                System.out.println("Nije dodat novi todo");
            }

            Thread.sleep(2000);

        }

      List<WebElement> elements = driver.findElements((By.xpath("//button[contains(@class,'destroy')]")));
        elements.forEach(element -> {
            actions.moveToElement(element.findElement(By.xpath("./.."))).build().perform();
            element.click();
        });

        List<WebElement> provera = driver.findElements((By.xpath("//button[contains(@class,'destroy')]")));

       if(provera.size()==0) {
            System.out.println("Stranice je prazna");
        }
        else {
            System.out.println("Stranica nije prazna");
        }


        driver.quit();

    }
}
