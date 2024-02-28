package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataLocationCareer {
    private final Faker faker = new Faker(new Locale("ru"));
    public String locationOptions = faker.address().city();
}
