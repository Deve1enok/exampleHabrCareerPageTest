package data;

import com.github.javafaker.Faker;

public class DataOnlineSchool {
    private final Faker faker = new Faker();
    public String schoolOptions = faker.options().option("Яндекс Практикум", "Stepik", "Skillbox", "Udemy",
            "Skypro", "Javarush", "Тинькофф Образование");
}
