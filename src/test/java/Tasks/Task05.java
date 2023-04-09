package Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Task05 extends TestBase {
    @Test
    public void alert () {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        bekle(2);



        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        bekle(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        bekle(2);



        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        bekle(2);


        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();



        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("mehmet");
        bekle(2);
        driver.switchTo().alert().accept();

        //-Çıkan mesajı konsola yazdırınız
        System.out.println(driver.findElement(By.id("demo1")).getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello mehmet How are you today", driver.findElement(By.id("demo1")).getText());
    }
}
