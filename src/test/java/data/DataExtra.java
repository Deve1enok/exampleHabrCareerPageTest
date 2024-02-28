package data;

import com.github.javafaker.Faker;

public class DataExtra {
    private final Faker faker = new Faker();
    public int randomNum = faker.number().numberBetween(0, 5);
}
