package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUpload() {

          /*
        Bir Web sayfasında upload işlemi yapmamız gerekirse;
            1-Öncelikle upload edeceğimiz webelementi locate ederiz
            2-Upload edeceğimiz dosya yolunu bir string'e assingn ederiz
            3-Locate ettiğimiz webelement'e sendkeys() methodu ile dosyayolunu aldığımız string değişkeni göndeririz
         */

        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");


        //b129.txt dosyasını yükleyin(upload)

        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        bekle(3);

        String dosyaYolu = "C:\\Users\\Mehmet\\OneDrive\\Masaüstü\\b129.txt";
        //String dosyaYolu = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\b129.txt";

        dosyaSec.sendKeys(dosyaYolu);
        bekle(3);
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin görüntülendiğini test edin
        WebElement fileUploaded = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
    }

}
