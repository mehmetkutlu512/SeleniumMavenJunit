package day16_SeleniumException;


import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerExceptionPractice  {

    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    int number;
    String isim;

    @Test
    public void nullPointerException1() {
        driver.get("https://amazon.com");
    }

    @Test
    public void nullPointerException2() {

        System.out.println(faker.name().lastName());
    }

    @Test
    public void nullPointerException3() {
        actions.click().perform();
    }

    @Test
    public void nullPointerException5() {
        isim.charAt(1);
    }

    @Test
    public void nullPointerException6() {
        System.out.println(number);
    }
}
