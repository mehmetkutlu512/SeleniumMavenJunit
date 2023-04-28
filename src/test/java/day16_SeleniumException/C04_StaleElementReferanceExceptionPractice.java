package day16_SeleniumException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceExceptionPractice extends TestBase {

    @Test
    public void StaleElementReferanceExceptionTest1() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().refresh();

        driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]")).click();
    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //Login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]"));

        driver.navigate().refresh();

        login.click();


    }

    @Test
    public void StaleElementReferanceExceptionTest3() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //Login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]"));

        driver.navigate().refresh();

        login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]"));
        login.click();


    }

    @Test
    public void StaleElementReferanceExceptionTest4() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //Login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();
        bekle(2);

        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().back();
        bekle(2);

        //logine tıklayınız
        //login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")); bu atamayı tekrar yaparsak exception almayız

        Assert.assertTrue(login.isDisplayed());
        //Webelemente yeni locate'ini atamadığımız için bu hatayı aldık


    }
}
