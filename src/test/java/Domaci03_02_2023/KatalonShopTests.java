package Domaci03_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class KatalonShopTests {
//    Zadatak
//    Kreirati KatalonShopTests klasu:
//    baseUrl: https://cms.demo.katalon.com

//    Test #1:  Adding product with quantity to the cart
//    Prioritet = 10
//    Koraci:
//    Ucitati stranicu /product/flying-ninja/
//    Unesite kolicinu 3
//    Klik na Add to cart dugme
//    Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//    Klik na Cart link iz navigacije
//    Verifikovati da u url-u stoji /cart ruta
//    Verifikovati da je broj proizvoda u korpi jednako 1
//
//    Test #2:  Removing product from cart
//    Prioritet = 20
//    Koraci:
//    Klik na Cart link iz navigacije
//    Verifikovati da u url-u stoji /cart ruta
//    Verifikovati da je broj proizvoda u korpi jednako 1
//    Klik na remove dugme iz prvog reda
//    Verifikovati da je broj proizvoda u korpi jedako 0

//    Test #3:  Verify error is displayed when username is missing
//    Prioritet = 30
//    Koraci:
//    Kliknite na my account link
//    Klik na login dugme
//    Verifikovati da je prikazana poruka Error: Username is required.
//
//    Test #4:  Verify error is displayed when password is missing
//    Prioritet = 40
//    Koraci:
//    Kliknite na my account link
//    Unesite username customer
//    Klik na login dugme
//    Verifikovati da je prikazana poruka ERROR: The password field is empty.
//
//    Test #5:  Verify error is displayed when password is wrong
//    Prioritet = 50
//    Koraci:
//    Kliknite na my account link
//    Unesite username customer
//    Unesite nevalidan pass invalidpassword
//    Klik na login dugme
//    Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost your password?
//
//
//    Test #6:  Verify error is displayed when user does not exist
//    Prioritet = 60
//    Koraci:
//    Kliknite na my account link
//    Unesite username invaliduser
//    Unesite nevalidan pass (ex: pass1234)
//    Klik na login dugme
//    Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?
//
//    Test #7:  Verify successful login
//    Prioritet = 70
//    Koraci:
//    Kliknite na my account link
//    Unesite username customer
//    Unesite validan pass crz7mrb.KNG3yxv1fbn
//    Klik na login dugme
//    Verifikovati na stranici pise Hello Katalon Parlitul_Changed


    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl ="https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @BeforeMethod
    public void before (){
        driver.get(baseUrl);

    }

    @Test(priority = 10)
    @Description("Adding product with quantity to the cart")

    public void addingProductWithQuantityToTheCart() throws InterruptedException {

        driver.get(baseUrl + "/product/flying-ninja/");
        for (int i = 0; i < 2; i++) {

            driver.findElement(By.xpath("//div[@class='quantity-button quantity-up']")).click();
        }
        driver.findElement(By.name("add-to-cart")).click();

        Assert.assertTrue(driver.findElement(By.className("woocommerce-message")).getText().
                contains("Flying Ninja"), "Message does not contain Flying Ninja");

        driver.findElement(By.xpath("//a[@class='button wc-forward']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Invalid URL text");

        List<WebElement> product = driver.findElements(By.xpath("//*[@class='woocommerce-cart-form__cart-item cart_item']"));

        Assert.assertEquals(product.size(), 1);
    }


     @Test(priority = 20)
     @Description(" Removing product from cart")
     public void removingProductFromCart() throws InterruptedException {

         driver.findElement(By.xpath("//*[@id='primary-menu']//li/a")).click();
         Assert.assertEquals(driver.getCurrentUrl(),baseUrl+ "/cart/", "Url is not right");

         int cartProizvodi = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
         Assert.assertEquals(cartProizvodi,1,"There are no products in the cart");

         driver.findElement(By.xpath("//*[@class='product-remove']/a")).click();

         Thread.sleep(3000);

         cartProizvodi = driver.findElements(By.xpath("//*[@class='entry-content']/div/form")).size();
         Assert.assertEquals(cartProizvodi,0,"There are no products in the cart");


     }

    @Test(priority = 30)
    @Description("Verify error is displayed when username is missing")

    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a")).click();
        driver.findElement(By.name("login")).click();
        String errorMessage = driver.findElement(By
                        .xpath("//*[@class='woocommerce-error']/li"))
                .getText();

        Assert.assertEquals(errorMessage, "Error: Username is required.",
                "Error message is wrong" );

    }

    @Test(priority = 40)
    @Description("Verify error is displayed when password is missing")
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.name("username")).sendKeys("customer");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: The password field is empty."));

    }

    @Test(priority = 50)
    @Description("Verify error is displayed when password is wrong")
    public void verifyErrorIsDisplayedWhenPasswordIsWrong(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.name("username")).sendKeys("customer");
        driver.findElement(By.name("password")).sendKeys("invalidpassword");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: The password you entered for the username customer is incorrect. Lost your password?"));
    }

    @Test(priority = 60)
    @Description("Verify error is displayed when user does not exist")
    public void verifyErrorIsDisplayedWhenUserDoesNotExist(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.name("username")).sendKeys("invaliduser");
        driver.findElement(By.name("password")).sendKeys("pass1234");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: Invalid username. Lost your password?"));
    }

    @Test(priority = 70)
    @Description("Verify successful login")
    public void verifySuccessfuLogin(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.name("username")).sendKeys("customer");
        driver.findElement(By.name("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='post-10']//p[1]"))
                .getText().contains("Hello Katalon Parlitul_Changed"));
    }

    @AfterMethod
    public void afterMethod(){


    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
