package day21_JSExecutor;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor_ClickPractice extends TestBase {
    @Test
    public void clickByJSTest() {
        //http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

        //Formu doldur
        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstname']"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB, Keys.TAB,faker.phoneNumber().cellPhone()
                );

        WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));

//        try {
//            submit.click();
//        } catch (Exception e) {
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("arguments[0].click;", submit);
//        }

        clickJSPractice(submit);

        //Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olup olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on", driver.getCurrentUrl());
    }
}
