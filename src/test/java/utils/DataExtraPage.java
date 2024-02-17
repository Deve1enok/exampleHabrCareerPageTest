package utils;

import com.github.javafaker.Faker;

public class DataExtraPage {
    private final Faker faker = new Faker();
    public int randomNum = faker.number().numberBetween(0,5);
}
