package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandlesMethod extends TestBase {

    @Test
    public void windowHandles() {
        //    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


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

       switchToWindow(1);


        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window", gercekBaslik);
        bekle(3);

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        //switchToWindow(0);
        window(0);
        Assert.assertEquals("The Internet", driver.getTitle());
        bekle(3);

        //    2. pencereye tekrar geçin.
        //switchToWindow(1);
        window(1);
        bekle(3);

        //    1. pencereye tekrar dönün.
        //switchToWindow(0);
        window(0);
    }


}
