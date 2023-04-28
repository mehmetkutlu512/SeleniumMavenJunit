package day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShotPractice extends TestBase {
    @Test
    public void screenShotTest1() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //1. adım Ilk olarak ekran resmi alacağımız dosyayı nereye kaydedececeğimizi belirtiriz.
        // Proje seviyesinden new directory deyip resim dosyalarımımzı
        //bu klasörün içine kaydetsin
        String dosyaYolu = "testEkranGoruntuleri/ekranGoruntusu.png";

        //2. adım TakesScreenshot arayüüznden obje oluşturmak.
        TakesScreenshot ts = (TakesScreenshot) driver;

        //3. adım
        /*
        FileUtils calss'ı file nesneleri ile birlikte kullanabileceğimiz methodlar içerir.
        Bu methodları kullanarak dosyalarda okuma, yazma, kopyalama ve silme işlemlerini çok daha kolay yapabiliriz.

         NOT: Files.write() methodu da aynı işlemi görür.
         */

        //Ekran resmini projemize kaydedelim
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }

    @Test
    public void screenShotTest2() throws IOException {
        driver.get("https://amazon.com");

        //Kaydettiğimiz ekran resmi her seferinde aynı dosyanın üzerine yazmaması için dosya isminden sonra bir tarih atayabiliriz.
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu = "testEkranGoruntuleri/ekranGoruntusu" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
