package Domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Zadatak2 {
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
//        Cekanje od 5s
//        Zatvorite pretrazivac


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        ArrayList<String> todoovi = new ArrayList<>();

        todoovi.add("Visit Paris");
        todoovi.add("Visit Prague");
        todoovi.add("Visit London");
        todoovi.add("Visit New York");
        todoovi.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        for (int i = 0; i < todoovi.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(todoovi.get(i));
            driver.findElement(By.xpath("//a[contains(text(),'Completed')]")).click();

            Thread.sleep(5000);

        }

        driver.quit();


    }
}
