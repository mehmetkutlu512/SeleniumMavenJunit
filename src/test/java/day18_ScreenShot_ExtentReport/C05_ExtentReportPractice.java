package day18_ScreenShot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C05_ExtentReportPractice extends TestBase {

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;
    @Test
    public void test() throws IOException {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu = "testEkranGoruntuleri/extentRaporları/extentReport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Mehmet");
        extentHtmlReporter.config().setDocumentTitle("Extent Raporu");
        extentHtmlReporter.config().setReportName("Regression Testi");
        extentTest = extentReports.createTest("Techproeducation Testi");

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        extentTest.pass("Techproeducation sayfasına gidildi");
        bekle(2);
        extentTest.pass("2 saniye bekletildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        extentTest.fail("Reklam kapatıldı");

        //Sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String tarih1 = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu1 = "testEkranGoruntuleri/ekranGoruntusu" + tarih + ".png";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu1));
        extentTest.info("Ekran resmi alındı");

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);
        extentTest.info("Arama kutusunda java aratıldı");

        //Sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu1));
        extentTest.info("Sonuc yazısı ekran görüntüsü alındı");
        extentTest.fail("Test failed oldu");

        extentReports.flush();




    }
}
