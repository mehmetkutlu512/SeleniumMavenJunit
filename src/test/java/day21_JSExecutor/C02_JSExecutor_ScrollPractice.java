package day21_JSExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_JSExecutor_ScrollPractice extends TestBase {

    @Test
    public void jsExecutorScrollTest() throws IOException {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));

       /*
       Actions actions= new Actions(driver);
        actions.moveToElement(weOffer).perform();
         */
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", weOffer);

        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu = "testEkranGoruntuleri/ekranGoruntusu"+tarih+".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        FileUtils.copyFile(enrollFree.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        scrollJSPractice(whyUs);
        FileUtils.copyFile(whyUs.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //Sayfayı en alta scroll yapalım
       // jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Sayfayi en üste scroll yapalım
        //jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }
}
