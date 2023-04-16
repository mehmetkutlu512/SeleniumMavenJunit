package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıklayın

        driver.findElement(By.xpath("//button")).click();

        //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());
        //Bir webelementin görünürlüğünü implicitly wait ile sayfada çözemedik.

        //Hello World! Yazının sitede oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //1. Yol
        //WebElement helloWorld = wait.until(ExpectedConditions.
                                        //visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        // visibilityOfElementLocated() webelementin görünür olmasını bekler.
        //2. Yol
        WebElement helloWorld1 = driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWorld1));



        Assert.assertTrue(helloWorld1.isDisplayed());







    }
}
