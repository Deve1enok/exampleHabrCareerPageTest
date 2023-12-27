package utils;

import com.github.javafaker.Faker;

public class DataProfessionalSkillsCareerPage {
        private final Faker faker = new Faker();
        public String profSkillsOptions = faker.options().option("C","C++","C#","CSS","Java",
            "Python", "JavaScript","JSON","CIO","Postman","SQL","1C: ERP");
}
