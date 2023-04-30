package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    //TestBase class'tan obje oluşturulmasının önüne geçilmesi için abstract yapılabilir.
    //TestBase base = new TestBase();
    //Bu classı extend ettiğimiz test classlarından ulaşabiliriz.
    protected static WebDriver driver;

    protected static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter; //Raporu HTML formatında düzenler
    protected static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz

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
    //EXPLİCİT WAIT METHODS
    //VİSİBLE Wait
    public static void visibleWait (WebElement element, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void visibleWaitPractice (WebElement webElement, int sure){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sure));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    //Alert Wait
    public static void alertWait (int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());


    }
    //VisibleElementLocator Wait
    public static void visibleWait (By locator, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void visibleWaitPractice (By locator ,int sure){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sure));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Tüm sayfa ScreenShot
    public static void tumSayfaResmi (){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/screenShot" +tarih + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;

        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void tumSayfaResmiPractice (){
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu = "testEkranGoruntuleri/ekranGoruntusu" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //Webelement Screenshot
    public static void webElementResmi (WebElement webElement){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/webElementScreenShot" + tarih + ".png";
        try {
            FileUtils.copyFile(webElement.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementResmiPractice (WebElement webElement){
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String dosyaYolu = "testEkranGoruntuleri/ekranGoruntusu"+ tarih + ".png";
        try {
            FileUtils.copyFile(webElement.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ExtentReport
    public void extentReport(){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");
    }

    //WebTable
    public void printData(int satir, int sutun){

        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    //Click method
    public void click (WebElement webElement){
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", webElement);
        }
    }

    public void clickJSPractice (WebElement webElement){
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click;", webElement);
        }
    }

    //JS Scroll
    public void scroll (WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    //JS Sayfa Sonu Scroll
    public void scrollEnd () {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public void scrollHome () {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    //JS Sendkeys
    public void jsSendKeys (WebElement webElement, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='"+ text + "'", webElement);
    }

    //JS SendAttributeValue
    public void sendAttributeJS (WebElement webElement, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", webElement);

    }

    //JS GetAttributeValue
    public void getValueByJS(String id, String attributeName) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);

    }
}


