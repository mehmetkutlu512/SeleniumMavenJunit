package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWorkPractice extends TestBase {

    @Test
    public void classWork() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

        //Sayfanın resmini alalım
        tumSayfaResmiPractice();

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Java", Keys.ENTER);

        //Sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmiPractice(sonucYazisi);

        //Yeni bir sekmede amazona gidelim

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //Sayfanın resmini alalım

        tumSayfaResmiPractice();

        //Arama bölümğnde Iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Sonuc yazısının resmini alalım
        WebElement sonucYazisi1 = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        webElementResmiPractice(sonucYazisi1);

        //Tekrar techproeducation sayfasına geçelim ve sayfa resmini alalım
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        tumSayfaResmi();
    }
}
