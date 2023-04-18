package day_04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void windowHandleTest() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();


        // 2- url'in 'amazon' icerdigini test edelim
        boolean iceriyorMu = driver.getCurrentUrl().contains("amazon");
        Assert.assertTrue(iceriyorMu);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        boolean bestBuy = driver.getTitle().contains("Best Buy");
        Assert.assertTrue(bestBuy);

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);


        // 6- arama sonuclarının 'Java' icerdigini test edelim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        boolean javaİceriyormu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText().contains("Java");

        Assert.assertTrue(javaİceriyormu);

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyWindowHandle);


        // 8- logonun gorundugunu test edelim
        boolean logoGoronurmu = driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed();
        Assert.assertTrue(logoGoronurmu);

    }
}
