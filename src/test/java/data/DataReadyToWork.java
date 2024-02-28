package data;

import com.github.javafaker.Faker;

public class DataReadyToWork {
    private final Faker faker = new Faker();
    public String readyToWorkOptions = faker.options().option("", "not_search", "search", "ready");
}
