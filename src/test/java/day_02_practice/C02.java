package day_02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");
        Thread.sleep(2000);

        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);


        // bulunan sonuc sayısını yazdırın
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonuc = sonucSayisi.getText().split( " ")[1];
        System.out.println(sonuc);
        String sonuc1 = sonuc.replaceAll("\\D", "");
        System.out.println(sonuc1);
        // sonuc sayısının 100000000  fazla oldugunu test edin
        int sonuc2 = Integer.parseInt(sonuc1);
        if (sonuc2>100000000){
            System.out.println("Sonuç 100000000'dan fazla ");
        } else System.out.println("Sonuç 100000000'dan az");

        // sayfayı kapatın
        driver.close();






    }
}
