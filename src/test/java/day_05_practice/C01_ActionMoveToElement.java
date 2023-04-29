package day_05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {



    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilMenusu = driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilMenusu).perform();
        bekle(3);

        // Change country/region butonuna basiniz

        driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();
        bekle(2);


        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[text()='Changing country/region website']")).click();
        /*
        Drop down option listesi 'Go to website' butonuna basmamıza engel oldugu icin
        herhangi bir yere click yapıp drop down option listesinin toparlanmasını sagladık
         */
        //driver.findElement(By.xpath("//a[@id='icp-dropdown_18']")); //Türkiye'ye click yaptık
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();


        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        Set<String> windowHandlesSeti = driver.getWindowHandles();
        System.out.println("Tum Sayfaların Handle Degeri: " + windowHandlesSeti);
        System.out.println("sayfa1Handle: " + sayfa1Handle);

        String sayfa2Handle = "";

        for (String windowHandle : windowHandlesSeti){
            if (!windowHandle.equals(sayfa1Handle)){
                sayfa2Handle = windowHandle;

            }
        }

        System.out.println("sayfa2Handle: " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
    }
}
