package day16_SeleniumException;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerException {
            /*
        NullPointerException:
        Değişken yada obje oluşturup bu değişkene atama yapmadığımızda yada eşitlemediğimizde
        NullPointerException hatası alırız
        */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    int number;
    String isim;

    @Test
    public void nullPointerException1() {
        //driver=new ChromeDriver(); bu atamayı yapmadığım için bu hatayı aldık
        driver.get("https://amazon.com"); //java.lang.NullPointerException
        //driver obje'mize atama yapmadığım için java.lang.NullPointerException hatası alırız.

    }

    @Test
    public void nullPointerException2() {
        // faker = new Faker(); bu atamayı yapmadığımız için bu hatayı aldık
        System.out.println(faker.name().firstName()); // java.lang.NullPointerException
    }

    @Test
    public void nullPointerException3() {
        //actions = new Actions(driver); bu atamayı yapmadığımız için bu hatayı aldık
        actions.doubleClick().perform(); // java.lang.NullPointerException
    }

    @Test
    public void nullPointerException4() {
        //sayı değişkenine atama yapılmadığı için java.lang.NullPointerException hatası aldık.
        //sayi = 5;
        System.out.println(sayi + 5); // java.lang.NullPointerException
    }

    @Test
    public void nullPointerException5() {
        //isim değişkenine atama yapılmadığı için java.lang.NullPointerException hatası aldık.
        //isim = Mehmet;
        System.out.println(isim.charAt(0));
    }

    @Test
    public void nullPointerException6() {
        System.out.println(number);
    }
}
