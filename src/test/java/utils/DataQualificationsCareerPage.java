package utils;

import com.github.javafaker.Faker;

public class DataQualificationsCareerPage {
    private final Faker faker = new Faker();
    public String qualificationOptions = faker.options().option("","1","3","4","5", "6");
}

