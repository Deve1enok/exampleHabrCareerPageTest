package data;

import com.github.javafaker.Faker;

public class DataTypeWorkCareer {
    private final Faker faker = new Faker();
    public String typeWorkOptions = faker.options().option("", "full_time", "part_time");

}
