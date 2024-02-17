package utils;

import com.github.javafaker.Faker;

public class DataUniversityPage {
    private final Faker faker = new Faker();
    public String universityOptions = faker.options().option("МГУ им. Ломоносова","КФУ","АГНИ","УГНТУ","КГТУ","МГУ-Валетта","ИНТУИТ");
}
