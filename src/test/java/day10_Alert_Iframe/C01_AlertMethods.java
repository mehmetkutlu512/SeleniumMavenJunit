package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_AlertMethods extends TestBase {

    @Test
    public void acceptAlert() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // Bir metod olusturun: acceptAlert
        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(4);
        alertAccept();
        bekle(4);
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        Assert.assertEquals("You successfully clicked an alert", mesaj.getText());

    }

    //Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        bekle(4);
        alertDismiss();
        //“successfuly” icermedigini test edin.
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertFalse(actualText.contains("succesfully"));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        bekle(4);
        alertSendText("mehmet");
        alertAccept();
        bekle(3);
        String yazi = driver.findElement(By.xpath("//*[text()='You entered: mehmet']")).getText();
        Assert.assertTrue(yazi.contains("mehmet"));
    }
}
