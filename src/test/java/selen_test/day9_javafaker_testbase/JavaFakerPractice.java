package selen_test.day9_javafaker_testbase;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {
    @Test
    public void testName() {
        Faker faker = new Faker( new Locale("fr"));
        System.out.println(faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println(faker.numerify("###-###-####"));
        System.out.println(faker.numerify("888-###-####"));
        System.out.println("faker.letterify(\"????-????\") = " + faker.letterify("????-????"));
        System.out.println("faker.bothify(\"##??-####-?????-#?\") = " + faker.bothify("##??-####-?????-#?"));
        System.out.println("faker.chuckNorris() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Muhtar"));

        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());

    }
}
