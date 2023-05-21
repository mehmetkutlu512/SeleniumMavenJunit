package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelYeniPractice {

    @Test
    public void excelReadTest1() throws IOException {
        String dosyaYolu = "src/test/java/resources/Takımlar.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(0);
        //System.out.println(row);

        Cell cell = row.getCell(0);
        System.out.println(cell);

        // Kullanılan satır sayısın bulun
        System.out.println(sheet.getPhysicalNumberOfRows());

        //Excel tablosundaki son satır sayısını getSheet("Sheet1) yani sayfayı belirledikten sonra
        System.out.println(sheet.getLastRowNum());


    }
}
