package day14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions = new Actions(driver);
        actions.keyDown(search, Keys.SHIFT). //Arama kutusu üzerinde shift tuşuna basılı tutar.
                sendKeys("techpro").
                keyUp(Keys.SHIFT). //shift tuşuna basma işlemi sonlanır.
                sendKeys(" education", Keys.ENTER).
                perform();

        //Sayfayı Rihmon college Enrolment Form linkine kadar scroll yapalım
        WebElement richmonCollege = driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(richmonCollege).perform();

        //scrollToElement() methodu ile locate ettiğiniz bir webelemente kadar yani o element görünene kadar
        //scroll yapabilirsiniz.
    }
}
