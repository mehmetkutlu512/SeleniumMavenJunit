package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    @Test
    public void actions() {

//    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragSource, dropTarget).perform();
    }

    @Test
    public void actions02() {

        //    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource). // Webelementi tutup bekler.
                        moveToElement(dropTarget). //mouse'u elementin üzerine taşır.
                        release().//mouse'u serbest bırakır
                        perform();
    }

    @Test
    public void actions3() {
        //https://jqueryui.com/droppable/ adresine gidin

        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.

        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).
                moveByOffset(166,106).//Webelementi istediğimiz kordinata taşır
                release().perform();
    }
}
