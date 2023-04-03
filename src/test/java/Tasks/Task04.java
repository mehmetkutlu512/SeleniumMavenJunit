package Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Task04 extends TestBase {
    @Test
    public void test() {
        // -Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement dropDownMenu = driver.findElement(By.xpath("//select"));
        Select select = new Select(dropDownMenu);
        List<WebElement> menuListesi = select.getOptions();

//        select.selectByIndex(1);
//        driver.findElement(By.id("nav-search-submit-button")).click();


        for (WebElement w : menuListesi){
            System.out.println(w.getText());
        }

        //menuListesi.stream().skip(1).limit(5).forEach(t-> System.out.println(t.getText()));


        // -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        // -başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        for (int i =1; i<6; i++){
            Select select1 = new Select(driver.findElement(By.xpath("//select")));
            select1.selectByIndex(i);
            driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
            bekle(2);

        }

    }
}
