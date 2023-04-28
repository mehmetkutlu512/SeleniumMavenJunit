package day18_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShotPractice extends TestBase {
    @Test
    public void webElementScreenShot() throws IOException {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Arama bölümünde Iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Sonuç yazısının remini alımız
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[text()='1-16 of 162 results for']"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu ="testEkranGoruntuleri/ekranGoruntusu" + tarih + ".png";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
