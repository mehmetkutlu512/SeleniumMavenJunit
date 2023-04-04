package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {
        //    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");



        //    İlk sayfanın ID'sini(Window Handle değerini) alın.
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String sayfaTexti = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", sayfaTexti);

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle);

        //    "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //    Açılan pencereye geçin.
            /*
                Eger bir butona click yaptigimizda bizim kontrolumuz disinda yeni bir pencere aciliyorsa
             o pencere icindeki web elementleri handle edebilmem icin switchto() methodu ile gecis yapmam gerekir.
             Fakat kontrolumuz disinda acildigi icin handle degerini bilmedigimiz icin tum acilan pencereleri
             getWindowHandles methodunu kullanarak bir SET'e assig ederiz. Yada ArrayList'e assign ederiz.
             */

        Set<String> tumPencereler = driver.getWindowHandles();
        for (String w : tumPencereler){
            if (!w.equals(ilkSayfaWindowHandle)){
                driver.switchTo().window(w);
            }
        } // Burada amaç bizim kontrolümüz dışında açılan pencereye gitmek.

        /*
        List<String> tumWindowsHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowsHandles.get(1));
         */



        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window", gercekBaslik);
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();
        bekle(3);

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals("The Internet", driver.getTitle());
        bekle(3);

        //    2. pencereye tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(3);

        //    1. pencereye tekrar dönün.
        driver.switchTo().window(ilkSayfaWindowHandle);
    }
}
