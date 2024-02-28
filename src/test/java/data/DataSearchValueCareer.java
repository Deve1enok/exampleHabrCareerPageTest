package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataSearchValueCareer {
    private final Faker faker = new Faker(new Locale("ru"));
    public String searchValueOptions = faker.options().option("Специалист по тестированию", "Тестировщик", "Разработчик", "Java", "Аналитик", "Developer",
            "Дизайнер", "Веб-дизайнер", "Директор", "Менеджер", "DevOps", "Руководитель", "Архитектор", "Администратор", "Админ", "Лентяй", "Спец", "Сис", "Р");

}
