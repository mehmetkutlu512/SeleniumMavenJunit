package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecutor_Scroll extends TestBase {
    @Test
    public void jsExecutorScrollTest() {
        JavascriptExecutor jse;

        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        bekle(2);
        //jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        scroll(weOffer);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));

        /*
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        */
        scroll(enrollFree);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", whyUs);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        /*
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", enrollFree);
        */
        scroll(enrollFree);
        bekle(2);
        tumSayfaResmi();

        //Sayfayı en alta scroll yapalım
        //Sayfayi en üste scroll yapalım

    }
}
