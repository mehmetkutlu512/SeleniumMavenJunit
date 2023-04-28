package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScreenShotPractice extends TestBase {
    @Test
    public void screenShotTest1() {
        //Tech proeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın resmini alalım
        tumSayfaResmiPractice();

        //Sonra amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Amazon sayfasının ekran görüntüsünü alalım
        tumSayfaResmiPractice();
    }
}
