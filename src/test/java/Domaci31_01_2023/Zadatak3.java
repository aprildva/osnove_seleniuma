package Domaci31_01_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {

//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();

        new Actions(driver).scrollToElement(driver.findElement(By.className("slider_bkgd"))).perform();

        List<WebElement> linkovi = driver.findElements(By.xpath("//*[@class='carousel-item']/img"));

        for (int i = 0; i < linkovi.size(); i++) {

            String src=linkovi.get(i).getAttribute("src");

            URL url = new URL(src);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            if (http.getResponseCode() >= 200 && http.getResponseCode() < 400) {
                new Helper().downloadUsingStream(src,"itbootcamp_slider/slika["+(i+1)+"].png");

        }}




        }
}
