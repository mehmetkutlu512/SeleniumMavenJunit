package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
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
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx"; //ide içerisinde
        //String dosyaYolu1 = "C:/Users/Mehmet/Downloads/Capitals.xlsx"; //indirilenler klasörü içinde
        //String dosyaYolu2 = "\"C:\\Users\\Mehmet\\Downloads\\Capitals.xlsx\""; ////indirilenler klasörü içinde

        //2- Dosyayı okuyabilmek için akışa almam gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3- Java ortamında bir excel dosyası oluşturmamız gerekir
        Workbook workbook = WorkbookFactory.create(fis); //create(fis) ile excel'de bu dosyayı okuruz.

        //4- Sayfayı(Sheet) seçmemiz gerekir.
        Sheet sheet = workbook.getSheet("Sheet1");

        //5- Satır(row) seçmemiz gerekir.
        Row row = sheet.getRow(0); //1. satır. Çünkü index 0 dan başlar.

        //6- Hücreyi(cell) seçmemiz gerekir.
        Cell cell = row.getCell(0); //1. sütun. Çünkü index 0 dan başlar.
        System.out.println(cell);


    }

    @Test
    public void readExcelTest2() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //1. satır 1. sütun daki bilgiyi yazdırınız
        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(satir1Sutun1);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));
    }

    @Test
    public void readExcelTest3() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        // Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        //1 .Yol:
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("1. Satır 1. Sutun : " + cell);

        //2. Yol:
        System.out.println("1. Satır 1. Sutun : " + workbook.getSheet("Sheet1").getRow(0).getCell(1));

        // 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin

        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. Satır 1. Sütun Bilgisi = " + satir3Sutun1);
        Assert.assertEquals("France", satir3Sutun1);

        // Kullanılan satır sayısın bulun

        System.out.println("Kullanılan satır sayısı : " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //Excel tablosunda kullanılan satır sayısını getPhysicalNumberOfRows() ile alabiliriz.

        System.out.println("Son satır sayııs : " + workbook.getSheet("Sheet1").getLastRowNum());
        //Excel tablosundaki son satır sayısını getSheet("Sheet1) yani sayfayı belirledikten sonra
        // getLastRowNum() methodu ile alabiliriz.



        System.out.println("Son sütun sayısı : " + workbook.getSheet("Sheet1").getRow(0).getLastCellNum());
        System.out.println("Kullanılan sütun sayısı : " +workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());

        // Ülke-Başkent şeklinde verileri yazdırın
        Map<String, String> ulkeVeBaskentler = new HashMap<>();
        for (int index = 1; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); index++) {
            String ulke = workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String baskent = workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();

            ulkeVeBaskentler.put(ulke,baskent + "\n");

        }
        System.out.println("Ulke ve başkentler : " + ulkeVeBaskentler);

    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        // Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");

            }
            System.out.println();

        }
    }
}
