package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions01 extends TestBase {


    @Test
    public void actions() {
        //   https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //    Kutuya sağ tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        bekle(3);
        //Webelemente sağ click yapabilmek için Actions classından obje oluşturmalıyız.
        Actions actions = new Actions(driver);
        actions.
                contextClick(kutu). //Actions objesi ile sağ click methodu olan contextClick() methodunu kullanırız.
                                    perform(); //action'ı sonlandırmak için perform() methodunu kulanırız.

        bekle(3);
        //    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alertText);

        bekle(3);
        //    Tamam diyerek alert’i kapatın
        //driver.switchTo().alert().accept();
        alertAccept();
    }
}
