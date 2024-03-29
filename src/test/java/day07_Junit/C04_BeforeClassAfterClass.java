package day07_Junit;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass sadece static methodlar ile çalışır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tüm testlerden önce bir kez çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Tüm testlerden sonra bir defa çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce ");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra ");
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
