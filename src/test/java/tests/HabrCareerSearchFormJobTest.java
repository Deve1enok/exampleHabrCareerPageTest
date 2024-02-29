package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HabrCareerPage;
import data.*;
import pages.HabrCareerSearchJobPage;

@Tag("habrCareerTests")
@Epic("Форма поиска habrCareer")
@DisplayName("Заполнение формы поиска работы")
public class HabrCareerSearchFormJobTest extends BaseTest {
    HabrCareerPage habrCareerPage = new HabrCareerPage();
    HabrCareerSearchJobPage habrCareerVacancies = new HabrCareerSearchJobPage();
    DataCareer dataCareerPage = new DataCareer();
    DataSpecializationsCareer dataFakerSpecialization = new DataSpecializationsCareer();
    DataQualificationsCareer dataFakerQualification = new DataQualificationsCareer();
    DataProfessionalSkillsCareer dataFakerSkills = new DataProfessionalSkillsCareer();
    DataSalaryCareer dataFakerSalary = new DataSalaryCareer();
    DataLocationCareer dataFakerLocation = new DataLocationCareer();
    DataTypeWorkCareer dataFakerTypeWork = new DataTypeWorkCareer();
    DataCurrencySalaryCareer dataFakerCurrency = new DataCurrencySalaryCareer();
    DataSearchValueCareer dataFakerSearchValue = new DataSearchValueCareer();

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска работы habrCareer")
    @DisplayName("Поиск работы с заполнением поля поиска и пустой сортировкой")
    @Story("Позитивные тесты")
    void searchCareerFormShouldHaveTestingPage() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions);

        habrCareerVacancies.checkSearchField(dataFakerSearchValue.searchValueOptions);
    }

    @Test
    @Tag("negative_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска работы habrCareer")
    @DisplayName("Поиск работы c пустым полем поиска и сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmptyShouldHaveWorkPage() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .setSearchTesting(dataCareerPage.emptyString);

        habrCareerVacancies.checkSearchField(dataCareerPage.emptyString);
    }

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска работы habrCareer")
    @DisplayName("Поиск работы с заполнением поля поиска и сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormShouldHaveFullSorting() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions);
        habrCareerVacancies.selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setSalary(dataFakerSalary.salaryOptions)
                .selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .selectTypeWork(dataFakerTypeWork.typeWorkOptions)
                .setCheckboxWork()
                .setCheckboxCompany()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResultsSkills(dataFakerSkills.profSkillsOptions)
                .checkResultsSalary(String.valueOf(dataFakerSalary.salaryOptions))
                .checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions)
                .checkResultsEmployment(dataFakerTypeWork.typeWorkOptions)
                .checkResultsCheckboxWork()
                .checkResultsCheckboxCompany()
                .checkResultsCheckboxSalary();
    }

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска работы habrCareer")
    @DisplayName("Поиск работы с заполнением поля поиска и сортировки с последующим сбросом сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormFullSortingShouldBeReset() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions);
        habrCareerVacancies.selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setSalary(dataFakerSalary.salaryOptions)
                .selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .selectTypeWork(dataFakerTypeWork.typeWorkOptions)
                .setCheckboxWork()
                .setCheckboxCompany()
                .resetCareerSorting()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResetSpecialization(dataCareerPage.defaultSpecializationField)
                .checkResetQualification(dataCareerPage.emptyString)
                .checkResetProfessionalSkills()
                .checkResetSalary()
                .checkResetCurrency(dataCareerPage.defaultTypeSalary)
                .checkResetLocation()
                .checkResetTypeWork(dataCareerPage.emptyString)
                .checkResultsCheckboxSalary()
                .checkResultsCheckboxRemotelyAfterReset()
                .checkResultsCheckboxITCompanyAfterReset();
    }

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска работы habrCareer")
    @DisplayName("Поиск работы c пустым полем и заполненной сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmptyShouldHaveFullSorting() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .setSearchTesting(dataCareerPage.emptyString);
        habrCareerVacancies.selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setSalary(dataFakerSalary.salaryOptions)
                .selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .selectTypeWork(dataFakerTypeWork.typeWorkOptions)
                .setCheckboxWork()
                .setCheckboxCompany()

                .checkSearchField(dataCareerPage.emptyString)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResultsSkills(dataFakerSkills.profSkillsOptions)
                .checkResultsSalary(String.valueOf(dataFakerSalary.salaryOptions))
                .checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions)
                .checkResultsEmployment(dataFakerTypeWork.typeWorkOptions)
                .checkResultsCheckboxWork()
                .checkResultsCheckboxCompany()
                .checkResultsCheckboxSalary();
    }
}
