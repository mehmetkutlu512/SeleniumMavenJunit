package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıklayın

        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test edin

        WebElement helloWorld1 = driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWorld1,15);

        Assert.assertTrue(helloWorld1.isDisplayed());

    }
}
