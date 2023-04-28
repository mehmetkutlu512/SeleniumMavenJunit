package day18_ScreenShot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentsReportTestPractice extends TestBase {
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void test() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu = "testEkranGoruntuleri/extentRaporları/extentReport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Mehmet");
        extentHtmlReporter.config().setDocumentTitle("Extent Raporu");
        extentHtmlReporter.config().setReportName("Smoke Test");
        extentTest = extentReports.createTest("Extent Test", "Test Raporu");

        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusuna iphone yazılıp arama yapıldı");

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        extentTest.info("Sonuc yazısı konsola yazdırıldı");
        extentTest.pass("Sayfa kapatıldı");

        extentReports.flush();



    }
}
