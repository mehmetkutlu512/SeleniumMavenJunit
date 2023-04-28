package day16_SeleniumException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TimeOutExceptionPractice extends TestBase {
    @Test
    public void timeOutException1() {
        driver.get("https://techproeducation.com");
        bekle(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        visibleWaitPractice(By.name("Yanlis locator"), 10);
    }

    @Test
    public void timeOutException2() {
        //https://the-internet.herokuapp.com/dynamic_loading/1 adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //start butonuna tıklayalım
        driver.findElement(By.xpath("//button")).click();

        //Hello World textinin çıktığını doğrulayınız
        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));
        visibleWaitPractice(helloWorld, 3);
        Assert.assertTrue(helloWorld.isDisplayed());

    }
}
