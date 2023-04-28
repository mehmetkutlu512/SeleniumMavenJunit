package day16_SeleniumException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementExceptionsPractice extends TestBase {
    @Test
    public void noSuchElementException() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için


        //SearchBox elementini locate edelim
        WebElement search = driver.findElement(By.xpath("//input[@type='seearch']"));
        search.sendKeys("Java", Keys.ENTER);
    }
}
