package utils;

import com.github.javafaker.Faker;

public class DataCurrencySalaryCareerPage {
    private final Faker faker = new Faker();
    public String currencySalaryOptions = faker.options().option("RUR","EUR","USD","UAH","KZT");
}
