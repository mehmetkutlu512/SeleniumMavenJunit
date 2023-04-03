package day_02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";

        if (actualTagName.equals(expectedTagName)){
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String actualAttributeName = aramaKutusu.getAttribute("name");
        String expectedAttributeName = "field-keywords";

        if (actualAttributeName.equals(expectedAttributeName)){
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        // sayfayi kapatiniz
        driver.close();
    }
}
