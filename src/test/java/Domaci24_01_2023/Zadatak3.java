package Domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji vrsi dodavanje 5 redova
//        Maksimizirati prozor
//        Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//        Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//        Klik na dugme Add New
//        Unesite name,departmant i phone (uvek iste vrednost)
//        Trazenje po name atributu
//        Kliknite na zeleno Add dugme.
//                PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete
//                ali zbog prirode reda neki dugmici se vide a neki ne.
//                Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath.
//                Koristan link last mehnizma




        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[@type='button']")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("name")).sendKeys("Peter Hod");
            Thread.sleep(2000);
            driver.findElement(By.name("department")).sendKeys("IT");
            Thread.sleep(2000);
            driver.findElement(By.name("phone")).sendKeys("(011) 123-456");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//tr[last()]/td[4]/a[@class='add']/i")).click();

            Thread.sleep(2000);
        }

        driver.quit();

        }

    }

