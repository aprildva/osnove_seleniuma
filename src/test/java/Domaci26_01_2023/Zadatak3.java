package Domaci26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Napisati program koji ucitava stranicu https://geodata.solutions/
//        Bira Country, State i City po vasoj zelji
//        Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//        I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//        Izabrerit Country, State i City tako da imate podatke da selektujete!

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        driver.get("https://geodata.solutions/");



        WebElement selectCountry = driver.findElement(By.id("countryId"));
        Select country = new Select(selectCountry);
        country.selectByVisibleText("Cuba");


        WebElement selectState = driver.findElement(By.id("stateId"));
        Select state = new Select(selectState);
        state.selectByVisibleText("Las Tunas");

        WebElement selectCity = driver.findElement(By.id("cityId"));
        Select city = new Select(selectCity);
        city.selectByValue("Amancio");




        driver.quit();

    }
}
