package Domaci31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='active-face']/img")).click();
        driver.findElement(By.id("image-option-remove")).click();


        List<String> slike = new ArrayList<>();
        slike.add("slike/front.jpg");
        slike.add("slike/right.jpg");
        slike.add("slike/left.jpg");
        slike.add("slike/back.jpg");

        for (int i = 0; i < slike.size(); i++) {

            driver.findElement(By.xpath("//div[@id='active-face']/img")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));
            driver.findElement(By.id("imageUpload")).sendKeys(new File(slike.get(i)).getAbsolutePath());
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"),i+1));
            driver.findElement(By.id("image-option-0")).click();
            driver.findElement(By.id("image-crop-done-button")).click();
            Thread.sleep(3000);

        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next-button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next-button"))).click();
        driver.findElement(By.id("textareaID")).sendKeys("Kocka kockica");
        driver.findElement(By.id("text-editor-done")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("next-button")).click();


//        Napisati program koji:
//        Podesava:
//        implicitno cekanje za trazenje elemenata od 10s
//        implicitno cekanje za ucitavanje stranice od 10s
//        eksplicitno cekanje podeseno na 10s
//        Podaci:
//        Potrebno je u projektu ukljuciti 4 slike:
//        front.jpg
//        left.jpg
//        right.jpg
//        back.jpg
//        Koraci:
//        Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//        Maksimizuje prozor
//        Klik na edit ikonicu
//        Klik na delete iz iskacuceg dijaloga
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte front.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 1.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte right.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 2.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Sacekajte da Next dugme bude klikljivo
//        Klik na Next dugme
//        Unesite tekst
//        Klik na Next
//        Klik na Preview
//        Klik na Add to cart
//        Sacekajte 5s
//        Quit




    }
}
