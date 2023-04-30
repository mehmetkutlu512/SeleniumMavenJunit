package day22_Log4j;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Log4jTestPractice extends TestBase {
    @Test
    public void log4jTest1() {
        Logger logger = LogManager.getLogger(C02_Log4jTestPractice.class);
        //http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");
        logger.info("Sayfaya gidildi");
        System.out.println("Sayfaya gidildi");

        //Formu doldur
        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB,Keys.TAB, Keys.TAB, faker.phoneNumber().cellPhone());
        logger.warn("Alanlar dolduruldu");
        System.out.println("Alanlar dolduruldu");
        //Submit tuşuna tıkla
        /*
        org.openqa.selenium.ElementClickInterceptedException : Eğer JS kodlrıyla webelement oluşturulmuşsa
        normal click() methodunda bu exception'ı alırız.
         */

        WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));

//        try {
//            submit.click();
//        } catch (Exception e) {
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("arguments[0].click();", submit);
//        }

        click(submit);
        logger.fatal("Submit tıklandı");
        System.out.println("Submit tıklandı");


        //Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olup olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on", driver.getCurrentUrl());
        logger.info("Url kontrol edildi");
        System.out.println("Url kontrol edildi");
    }
}
