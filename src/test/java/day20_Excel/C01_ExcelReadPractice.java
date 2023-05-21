package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelReadPractice {

    @Test
    public void excelReadTest1() throws IOException {
       /*
            Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
            3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
            Kullanılan satır sayısın bulun
            Ülke-Başkent şeklinde verileri yazdırın
        */

        //Excel dosyasından bir veri okuyabilmek için;
        //1- Dosya yolunun alırız.
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        //2- Dosyayı okuyabilmek için akışa almam gerekir
        FileInputStream  fis = new FileInputStream(dosyaYolu);

        //3- Java ortamında bir excel dosyası oluşturmamız gerekir
        Workbook workbook = WorkbookFactory.create(fis);

        //4- Sayfayı(Sheet) seçmemiz gerekir.
        Sheet sheet = workbook.getSheet("Sheet1");

        Row row = sheet.getRow(2);

        Cell cell = row.getCell(0);

        String row3cell1 = cell.getStringCellValue();
        System.out.println(row3cell1);
        Assert.assertEquals("France", row3cell1);

    }

    @Test
    public void readExcelTest2() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        Assert.assertEquals("France", satir3sutun1);

    }

    @Test
    public void readExcelTest3() throws IOException {
        // Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        // Kullanılan satır sayısın bulun
        System.out.println("Kullanılan satır sayısı: " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());

        System.out.println("Son satır sayısı: " + workbook.getSheet("Sheet1").getLastRowNum());

        // Ülke-Başkent şeklinde verileri yazdırın





    }
}
