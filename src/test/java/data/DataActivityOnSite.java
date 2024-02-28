package data;

import com.github.javafaker.Faker;

public class DataActivityOnSite {
    private final Faker faker = new Faker();
    public String activityValue = faker.options().option("", "two_years", "year", "half_year", "three_months");
}
