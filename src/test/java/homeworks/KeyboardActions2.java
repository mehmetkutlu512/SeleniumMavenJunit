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

        WebElement videoElement = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(videoElement);

        WebElement play = driver.findElement(By.xpath("//*[@id='movie_player']/div[4]/button"));
        play.click();




        //5.videoyu calistirdiginizi test edin
    }
}
