package day09_DropDownAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    /*
    -DropDown Nedir : Alt başlıkların olduğu açılır menü listesidir.
    -DropDown nasıl automate edilir (Handle);
        a-DropDown menüyü ilk olarak locate ederiz.
        b-Select objesi oluştururuz.
        c-Select objesinin ddm menü webelementinin içeriğine ve seçeneklerine
          erişim sağlaması için SELECT sınıfına ait arguman olarak locate ettiğimiz webelementi koyarız.
          Syntax: Select select = new Select(ddm webelement);
        d-Select class'ı, sadece <select> tag'ı ile oluşturulmuş dropdown menulere uygulanabilir.
        e-select objesi ile ddm'yi handle etmek için 3 method kullanılır
            -selectByVisibleText() --> DDM'deki elemente görünür metin ile ulaşmak için kullanılır.
            -selectByIndex() --> Index ile ulaşmak için kullanılır.
            -selectByValue() --> Elementin değeri ile ulaşmak için kullanılır.(option tagındaki değer ile)
        f-getOptions() -->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür.
        g-getFirstSelectionOption() --> En son seçili kalan ilk seçeneği bize döndürür.
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım
      /*  WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
        stateList.forEach(t-> System.out.println(t.getText())); */
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        tumEyaletler.stream().skip(1).forEach(t-> System.out.println(t.getText()));

        //Sadece Alaska almak için -->(//select)[5]//option[text()='Alaska']
        System.out.println("**************************");
        //b. Sayfadaki tüm ddm lerdeki tüm seçenekleri konsolda yazalım
        List<WebElement> tumEyaletler1 = driver.findElements(By.tagName("select"));
        tumEyaletler1.forEach(t-> System.out.println(t.getText()));





    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
