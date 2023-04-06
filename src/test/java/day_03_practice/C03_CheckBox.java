package day_03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CheckBox {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void name() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html adresine gidin

        driver.get("https://demo.guru99.com/test/radio.html");


        // checkbox elementlerini locate edin

        WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkbox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));


        // checkbox1 ve checkbox3  secili degil ise secin

        if (!checkbox1.isSelected()){

            checkbox1.click();
            Thread.sleep(2000);
        }

        if (!checkbox3.isSelected()){

            checkbox3.click();
            Thread.sleep(2000);
        }



        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox3.isSelected());


        // checkbox2 elementinin secili olmadıgını test edin

        Assert.assertFalse(checkbox2.isSelected());
    }
}
