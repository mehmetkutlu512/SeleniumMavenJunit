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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Practice08 {
    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void test01() {
    //  a. Yil,ay,gün dropdown menu'leri locate ediniz
    //  b. Select objesi olustur
    //  c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        Select select = new Select(yil);
        select.selectByIndex(1); // 2022
        //yil.sendKeys("2022");

        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        Select select1 = new Select(ay);
        select1.selectByValue("1"); // February

        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));
        Select select2 = new Select(gun);
        select2.selectByVisibleText("3"); //3

    }

    @Test
    public void test02() {
    // a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletIsimleri = driver.findElement(By.xpath("//*[@id='state']"));
        Select select= new Select(eyaletIsimleri);
        List<WebElement> eyaletListesi = select.getOptions();
        for (WebElement w : eyaletListesi){
            System.out.println(w.getText());
        }
    }

    @Test
    public void test03() {
    // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletIsimleri = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletIsimleri);
        WebElement seciliSecenek = select.getFirstSelectedOption();

        Assert.assertTrue("Yanlış", seciliSecenek.getText().equals("Select a State"));
        Assert.assertEquals(seciliSecenek.getText(),"Select a State");
    }
}
