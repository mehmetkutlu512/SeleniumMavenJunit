package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardActions2 extends TestBase {
    @Test
    public void test() {
        //1.Bir Class olusturalim KeyboardActions2
        //2.https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3.video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();



        //4.videoyu izlemek icin Play tusuna basin
        Actions actions1 = new Actions(driver);

        WebElement videoElement = driver.findElement(By.xpath("//*[@frameborder='0']"));
        //driver.switchTo().frame(videoElement);


        actions1.click(videoElement).perform();

        //videoElement.click();
        //actions.moveByOffset(419,750).click().perform();

        //5.videoyu calistirdiginizi test edin
    }
}
