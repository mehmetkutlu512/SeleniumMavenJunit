package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileExists() {
        //https://testcenter.techproeducation.com/index.php?page=file-download

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        File silinecekDosya = new File("C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();
        /*
        //Eğer localinizden atomasyon ile bir dosya silmek için File class'ından obje oluşturup dosya yolumuzu
        içine yerleştiririz. Ve oluşturduğumuz obje ile delete() methodunu kullanarak o dosyayı silebiliriz.
        Bunu yapma sebebimiz test classlarımızı çalıştırdığımızda her çalıştırmada yeni bir dosya create edeceği için
        ordaki dosya kalabalığını önlemiş oluruz aynı zamanda doğrulama yaparken işimizi garantiye almış oluruz
        Birden fazlada dosya indirmis olsak aynı isimde her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
        o klasörün içinde bulunacağı için her zaman ilk dosyanın varlığını test etmiş oluruz
         */
        //b10 all test cases dosyasını indirelim

        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
        bekle(5);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        //ILK OLARAK DOSYA YOLUNU ALIYORUZ.
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/b10 all test cases, code.docx";

       // "C:\Users\Mehmet\Downloads\b10 all test cases, code.docx"
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
