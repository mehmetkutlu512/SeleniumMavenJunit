package day07_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_Practice07 {

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test öncesi bir kez çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test sonrası bir kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk test");
    }

    @Test
    public void test02() {
        System.out.println("İkinci test");
    }
}
