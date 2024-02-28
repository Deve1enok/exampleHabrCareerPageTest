package data;

import com.github.javafaker.Faker;

public class DataCurrencySalaryCareer {
    private final Faker faker = new Faker();
    public String currencySalaryOptions = faker.options().option("RUR", "EUR", "USD", "UAH", "KZT");
}
