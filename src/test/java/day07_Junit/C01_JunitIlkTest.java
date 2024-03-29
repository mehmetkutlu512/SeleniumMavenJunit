package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_JunitIlkTest {

    @Test
    public void techpro (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.get("https://techproeducation.com");
        driver.close();

    }

    @Test
    public void amazon() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://amazon.com");
        driver.close();

    }
}
