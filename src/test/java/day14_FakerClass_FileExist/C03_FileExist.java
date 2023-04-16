package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void fileExist() {
        //Masaüstünde bir dosya oluşturalım
        //Dosyanın varlığını doğrulayalım
        System.out.println(System.getProperty("user.dir")); //C:\Users\Mehmet\IdeaProjects\B129SeleniumMavenJunit
        //Projemizin içinde bulunduğu yolu verir.

        System.out.println(System.getProperty("user.home")); //C:\Users\Mehmet
        //Lokalimizdeki kullanıcı yolunu verir.

        //String dosyaYolu ="\"C:\\Users\\Mehmet\\OneDrive\\Masaüstü\\b129.txt\"";
        String farkliKisim = System.getProperty("user.home"); //Her kullanıcının ana yolu farklı olduğu için farklı dedik.
        String ortakKisim = "\\OneDrive\\Masaüstü\\b129.txt"; //Aynı yerde oluşturulduğu için ortakKısım dedik
        String dosyaYolu = farkliKisim + ortakKisim; //Dosya yolu olarak farkliKisim ve ortakKisim aldık.

        Assert.assertTrue( Files.exists(Paths.get(dosyaYolu))); //Files.exists methodu ile dosyanın varlığını doğruladık.



    }
}
