package day07_Junit;

import org.junit.*;

public class C04_Practice07 {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tüm testlerden önce sadece bir kez çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Tüm testlerden sonra sadece bir kez çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test öncesi ");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test sonrası ");
    }

    @Test
    public void test02() {
        System.out.println("Test02");
    }

    @Test
    public void test01() {
        System.out.println("Test01");
    }


}
