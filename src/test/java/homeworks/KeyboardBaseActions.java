package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardBaseActions extends TestBase {
    @Test
    public void test() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");


        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverFirst).perform();

        //3. Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();

        //4. Popup mesajini yazdirin
        System.out.println("Popup mesajı : " + driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. “Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("clickHold.getText() = " + clickHold.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClick).perform();
    }
}
