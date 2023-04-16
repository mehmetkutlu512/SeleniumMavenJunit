package day16_SeleniumException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import javax.crypto.KeyAgreementSpi;

public class C01_NoSuchElementExceptions extends TestBase {
    @Test
    public void NoSuchElementException() {
           /*
        NoSuchElementException;
            -Sayfada bulunmayan bir elemente erişim sağlamaya çalışıldığında karşılaşılır
         */
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için


        //SearchBox elementini locate edelim

        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);
        //org.openqa.selenium.NoSuchElementException: no such element: Webelementin locatini değiştirdiğimiz için 25. satırda
        //                                                    //NoSuchElementException hatası aldık
        //                                                    //SearchBox'ın locatini yeniden almamız gerekir



    }
}
