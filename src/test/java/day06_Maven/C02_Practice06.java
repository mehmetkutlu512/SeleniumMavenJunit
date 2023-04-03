package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice06 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();

        //Login alanine  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        //Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        //Sign in buttonuna tiklayin
        WebElement signIn = driver.findElement(By.xpath("//*[@type='submit']"));
        signIn.click();
        driver.navigate().back();

        //Pay Bills sayfasina gidin-->Pay Bills bölümüne ulaşabilmek için önce Online Banking bölümüne tıklamalıyız
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("50");

        //tarih kismina “2020-09-10” yazdirin
        WebElement tarih = driver.findElement(By.xpath("//*[@id='sp_date']"));
        tarih.sendKeys("2020-09-10");

        //Pay buttonuna tiklayin
        WebElement pay = driver.findElement(By.xpath("//*[@id='pay_saved_payees']"));
        pay.click();

        //“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        System.out.println(mesaj.isDisplayed());

        //Sayfayı kapatınız
        driver.close();

    }
}
