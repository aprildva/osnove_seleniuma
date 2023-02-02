package Domaci30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        Napisati program koji testira infinity scroll.
//        Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//        Selektujte delay od 2000ms, koristeci Select klasu.
//        Skrol do Show more dugmeta koje se nalazi na dnu stranice
//        Sacekajte da dugme bude klikljivo
//        Klik na Show more dugme
//        Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//        Sacekajte da dugme vise ne bude klikljivo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        WebElement selectEl = driver.findElement(By.id("delay-select"));
        Select select = new Select(selectEl);
        select.selectByValue("2000");

        WebElement button= driver.findElement(By.id("infinite-scroll-button"));

        new Actions(driver)
                .scrollToElement(button)
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("active-text")));


        driver.findElement(By.id("infinite-scroll-button")).click();

        wait.until(
                ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.className("item"), 8));

        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id("infinite-scroll-button"))));








    }
}
