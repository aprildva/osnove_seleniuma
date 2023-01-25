package Domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://artplayer.org/");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//i[@aria-label='Play']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@aria-label='Mute']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[contains(@class, 'screenshot')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-pip')]")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//i[@class='art-icon art-icon-pip']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-fullscreenWebOn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='art-icon art-icon-fullscreenWebOff']")).click();
        Thread.sleep(5000);

        driver.quit();

    }

    }

