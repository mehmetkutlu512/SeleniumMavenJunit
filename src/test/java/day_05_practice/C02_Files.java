package day_05_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files {

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


    @Test
    public void test01() {

        //"C:\Users\Mehmet           \OneDrive\Masaüstü\text"

        String farkliKisim = System.getProperty("user.home");
        String ayniKisim = "\\OneDrive\\Masaüstü\\text";
        System.out.println(farkliKisim);
        System.out.println(ayniKisim);

        Assert.assertTrue(Files.exists(Paths.get(farkliKisim+ayniKisim)));

    }
}
