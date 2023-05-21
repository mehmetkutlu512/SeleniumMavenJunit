package day_06_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_Screenshot extends TestBase {

    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc sayisini yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // iki ArrowDown sayfayı asagiya kaydirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz


    @Test
    public void test01() throws IOException, InterruptedException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        Thread.sleep(3000);


        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("Devamkee");
        }

        // arama cubuguna oppo yazip enter'a basınız
        WebElement aramaCubugu = driver.findElement(By.id("search-input"));
        aramaCubugu.sendKeys("Oppo", Keys.ENTER);
        Thread.sleep(3000);

        // sonuc sayisini yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("Sonuc Yazisi = " + sonucYazisi.getText());
        Thread.sleep(3000);

        // ilk urunun fotografını cekin

        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class='prd-link gowitPlp-js'])[1]"));

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        File kayit = new File("target/ekranGoruntusu/tumSayfa" + tarih +".jpeg");

        File gecici = ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,kayit);
        Thread.sleep(3000);


        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        Thread.sleep(3000);

        // sepete ekleyiniz butonu görününceye kadar iki PAGE DOWN sayfayi aşağıya kaydırın
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);


        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        Thread.sleep(3000);



        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(3000);



        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti =driver.findElement(By.xpath("//*[text()='Sipariş Özeti']"));
        System.out.println(siparisOzeti.getText());
        Thread.sleep(3000);

        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        Thread.sleep(3000);

        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        System.out.println(driver.findElement(By.xpath("//div[@class='lrp-title']")).getText());
    }
}
