package day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice08 {

//        1)https://amazon.com adresine gidin
//        2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
//        ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
//        ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
//        ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
//        ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com");

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void titleTest() {
    //○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    String actualTitle = driver.getTitle();
    String expectedTitle = "Amazon";
        Assert.assertTrue("Sayfa başlığı Amazon içermiyor", actualTitle.contains(expectedTitle));
        assert driver.getTitle().contains("Amazon"); // Mesaj veremiyoruz.

    }

    @Test
    public void imageTest() {
    //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue("Logo görünmüyor",logo.isDisplayed());

    }

    @Test
    public void searchBox() {
    //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        assert searchBox.isEnabled();

    }

    @Test
    public void wrongTitleTest() {
    //○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın

    //Assert.assertFalse(driver.getTitle().contains("amazon"));
    Assert.assertFalse("Sayfa başlığı amazon içermiyor. ", driver.getTitle().contains("amazon"));

    }
}
