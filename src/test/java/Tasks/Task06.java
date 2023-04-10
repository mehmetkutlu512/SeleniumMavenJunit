package Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task06 extends TestBase {
    @Test
    public void iframe () {

        //// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");


        //// ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath(("//*[@id='emoojis']")));
        driver.switchTo().frame(1);

        WebElement ikinciEmoji = driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        ikinciEmoji.click();


        //// İkinci emoji öğelerini yazdırınız

        List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//div"));

        for (WebElement w : emojiList){
            System.out.println(w.getText());
        }


        //// Parent iframe e geri donun

        driver.switchTo().parentFrame();

        //// Formu doldurun,(Formu istediğiniz metinlerle doldurun)

        List<WebElement> personalize = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        String [] arr ={"1", "2", "3" , "4", "5" , "6" , "7", "8" ,"9" ,"10" ,"11"};

        int sayac = 0;
        for (WebElement w: personalize){
            w.sendKeys(arr[sayac]);
            sayac++;
        }


        //// Apply button a basiniz

        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }
}
