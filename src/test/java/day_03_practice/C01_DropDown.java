package day_03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void name() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");


        // dropdown'dan "Books" secenegini secin
        // DropDown 3 adımda handle edilir.
        // 1) DropDown locate edilmelidir.
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        // 2) Select objesi oluşturulmalıdır.
        Select select = new Select(ddm);

        // 3) Opsiyonlardan biri seçilir.
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");


        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);


        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucuElementi.getText().contains("Java"));





    }
}
