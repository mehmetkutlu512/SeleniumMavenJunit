package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class HandleIframeOdev extends TestBase {
    //1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
    //2) sayfadaki toplam iframe sayısını bulunuz.
    //3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    //4) Paragrafdaki yaziyi silelim
    //5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    //6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    @Test
    public void iframeTest() {
        //1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //2) sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.xpath("//iframe"));
        int count = 0;
        for (WebElement w : iframeSayisi){
            count ++;
        }
        System.out.println("Iframe sayısı = " + count);


        //3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        boolean isContains = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText().contains("Editor");
        Assert.assertTrue(isContains);

        //4) Paragrafdaki yaziyi silelim
        driver.findElement(By.xpath("//*[text()='File']")).click();
        driver.findElement(By.xpath("//*[text()='New document']")).click();


        //5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("body[id='tinymce']")).sendKeys("iframein icindeyim");


        //6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        boolean iceriyormu = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText().contains("Elemental Selenium");
        Assert.assertTrue(iceriyormu);
    }
}
