package utils;

import com.github.javafaker.Faker;

public class DataReadyToWorkPage {
    private final Faker faker = new Faker();
    public String readyToWorkOptions = faker.options().option("", "not_search", "search", "ready");
}
