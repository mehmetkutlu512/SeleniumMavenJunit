package day09_DropDownAlerts;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //techproeducation sayfasına gidelim
        //Başlığın Bootcamp içerdiğini test edelim.
        driver.get("https://techproeducation.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
