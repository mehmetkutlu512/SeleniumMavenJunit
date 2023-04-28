package day19_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class C01_WebTablesPractice extends TestBase {


    @Test
    public void webTablesTest1() {

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Table1");
        System.out.println(table1.getText());

        System.out.println("**************************************");
        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement satir3 = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        String[] arr = satir3.getText().split(" ");
        System.out.println(Arrays.toString(arr));
        System.out.println("**************************************");

        //2. yol:
        List<WebElement> satir3List = driver.findElements(By.xpath("(//table)[1]//tr[3]//td"));
        for (WebElement element: satir3List){
            System.out.println(element.getText());
        }
        System.out.println("**************************************");

        //    Task 3 : Son satırın verilerini yazdırın
        List<WebElement> sonSatirList = driver.findElements(By.xpath("(//tbody)[1]//tr[last()]//td"));
        sonSatirList.forEach(t-> System.out.print (t.getText() + " - "));

        System.out.println("**************************************");
        //    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("5. Sutun Verileri");
        WebElement sutun5Header = driver.findElement(By.xpath("(//table)[1]//thead//th[5]"));
        System.out.print(sutun5Header.getText() + " - ");
        List<WebElement> sutun5List = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        sutun5List.forEach(t-> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTablesTest2() {


    }
}
