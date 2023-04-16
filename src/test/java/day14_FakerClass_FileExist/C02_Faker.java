package day14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker {



    @Test
    public void faker () {
        // 1. Faker objesi oluştururuz.
        Faker faker = new Faker();

        //YADA Faker.instance() static methodu ile de kullanabiliriz. Faker.instance().name().firstName();

        //First name  yazdıralım.
        System.out.println("Fake firstname: " + faker.name().firstName());
        System.out.println(Faker.instance().name().firstName());

        //Last name yazdıralım.
        System.out.println(faker.name().lastName());

        //Kullanıcı adı yazdıralım.
        System.out.println(faker.name().username());

        //Meslek ismi yazdıralım.
        System.out.println(faker.name().title());
        System.out.println(faker.job().position());


        //Şehir ismi yazdıralım.
        System.out.println(faker.address().city());

        //Ülke ismi yazdıralım.
        System.out.println(faker.address().country());

        //Adress yazdıralım.
        System.out.println(faker.address().fullAddress());

        //Tel no yazdıralım.
        System.out.println(faker.phoneNumber().cellPhone());


        //Rastgele 15 haneli bir numara
        System.out.println(faker.number().digits(15));
    }
}
