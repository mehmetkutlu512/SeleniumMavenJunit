package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //TestBase class'tan obje oluşturulmasının önüne geçilmesi için abstract yapılabilir.
    //TestBase base = new TestBase();
    //Bu classı extend ettiğimiz test classlarından ulaşabiliriz.
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //driver.quit();
    }
    //HARD WAIT METHOD
    public static void bekle (int saniye)  {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //ALERT ACCEPT
    public static void alertAccept (){
        driver.switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss (){
        driver.switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText (){
        driver.switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertSendText (String text){
        driver.switchTo().alert().sendKeys(text);
    }

    /*
     Select select2 = new Select(gun);
     select2.selectByVisibleText("7");

       //ddmVisibleText(gun,"7"); -->Yukarıdaki kullanım yerine sadece method ile handle edebilirim.
     */

    //DropDown VisibleText
    public static void ddmVisibleText (WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex (WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue (WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow
    public static void switchToWindow (int sayi){
        List<String> tumWindowsHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowsHandles.get(sayi));
    }

    //SwitchToWindow
    public static void window (int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

    //Explicit Wait
    public static void visibleWait (WebElement element, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //Alert Wait
    public static void alertWait (int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());


    }
}
