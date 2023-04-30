package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_TypePractice extends TestBase {

    @Test
    public void typeTest() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@placeholder='Search...']"));
        //aramaKutusu.sendKeys("QA");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].value='QA'", aramaKutusu);
//        aramaKutusu.submit();

         /*
        Eğer jse.executeScript("arguments[0].value='QA'",aramaKutusu); bu kullanımdaki gibi metin gönderemezsek
        aşağıdaki örnekte gibi value attribute'ne değer atayabiliriz.
         */

        //jse.executeScript("arguments[0].setAttribute('value', 'QA')", aramaKutusu);
        sendAttributeJSPractice(aramaKutusu,"QA");
    }
}
