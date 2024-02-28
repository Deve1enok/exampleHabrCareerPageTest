package data;

import com.github.javafaker.Faker;

public class DataSalaryCareer {
    private final Faker faker = new Faker();
    public int salaryOptions = (int) faker.number().randomNumber();
}
