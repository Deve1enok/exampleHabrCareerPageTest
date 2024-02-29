package data;

import com.github.javafaker.Faker;

public class DataCompany {
    private final Faker faker = new Faker();
    public String companyOptions = faker.options().option("СберТех", "МегаФон", "Хабр", "ТехСофт",
            "Газпромбанк", "КИБЕРПРОТЕКТ", "Яндекс", "Яндекс.Маркет");
}
