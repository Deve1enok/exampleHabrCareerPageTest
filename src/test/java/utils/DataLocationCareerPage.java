package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataLocationCareerPage {
    private final Faker faker = new Faker(new Locale("ru"));
    public String locationOptions = faker.address().city();
}
