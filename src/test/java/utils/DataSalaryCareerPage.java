package utils;

import com.github.javafaker.Faker;

public class DataSalaryCareerPage {
    private final Faker faker = new Faker();
    public int salaryOptions = (int) faker.number().randomNumber();
}
