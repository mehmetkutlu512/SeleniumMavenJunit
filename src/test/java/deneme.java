import org.junit.Test;
import utilities.TestBase;

public class deneme extends TestBase {
    @Test
    public void name() {
        driver.get("https://amazon.com");
        //driver.close();
        driver.get("https://techproeducation.com");
    }
}
