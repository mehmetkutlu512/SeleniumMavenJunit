package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutor_GetValuePractice extends TestBase {
    @Test
    public void jsGetValueTest() {
        //	2)https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();



        //  3)Tarih kısmını JS ile locate ediniz. Yazili metinleri al ve yazdırınız
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //WebElement date = (WebElement) jse.executeScript("return document.getElementById('checkin_date')");
        WebElement date = (WebElement) jse.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        sendAttributeJS(date,"20/05/2023");

         /*
        Eğer bir webelementin attribute değerini yazdırmak istersek aşağıdaki örnekte ki gibi yaparız.
         */

        String attributeDegeri = (String) jse.executeScript("return document.getElementById('checkin_date').value");
        System.out.println(attributeDegeri);
    }
}
