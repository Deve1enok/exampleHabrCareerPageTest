package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HabrCareerPage;
import utils.*;

@Tag("habrCareerTests")
@Feature("Форма поиска работы habrCareer")
@DisplayName("Заполнение формы поиска работы")
public class HabrCareerPageTest extends BaseTest {
    HabrCareerPage habrCareerPage = new HabrCareerPage();
    DataCareerPage dataCareerPage = new DataCareerPage();
    DataSpecializationsCareerPage dataFakerSpecialization = new DataSpecializationsCareerPage();
    DataQualificationsCareerPage dataFakerQualification = new DataQualificationsCareerPage();
    DataProfessionalSkillsCareerPage dataFakerSkills = new DataProfessionalSkillsCareerPage();
    DataSalaryCareerPage dataFakerSalary = new DataSalaryCareerPage();
    DataLocationCareerPage dataFakerLocation = new DataLocationCareerPage();
    DataTypeWorkCareerPage dataFakerTypeWork = new DataTypeWorkCareerPage();
    DataCurrencySalaryCareerPage dataFakerCurrency = new DataCurrencySalaryCareerPage();
    DataSearchValueCareerPage dataFakerSearchValue = new DataSearchValueCareerPage();


    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы с заполнением поля поиска и пустой сортировкой")
    @Story("Позитивные тесты")
    void searchCareerFormShouldHaveTestingPage () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions)

                .checkSearchField(dataFakerSearchValue.searchValueOptions);
    }
    @Test
    @Tag("negative_test")
    @DisplayName("Поиск работы c пустым полем поиска и сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmptyShouldHaveWorkPage () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .setSearchTesting(dataCareerPage.searchValueEmpty)

                .checkSearchField(dataCareerPage.searchValueEmpty);
    }
    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы с заполнением поля поиска и сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormShouldHaveFullSorting () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions)
                .choiceFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .choiceSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .choiceQualification(dataFakerQualification.qualificationOptions)
                .choiceProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setSalary(dataFakerSalary.salaryOptions)
                .choiceTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .choiceTypeWork(dataFakerTypeWork.typeWorkOptions)
                .setCheckBoxWork()
                .setCheckBoxCompany()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResultsSkills(dataFakerSkills.profSkillsOptions)
                .checkResultsSalary(String.valueOf(dataFakerSalary.salaryOptions))
                .checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions)
                .checkResultsEmployment(dataFakerTypeWork.typeWorkOptions)
                .checkBoxWork()
                .checkBoxCompany()
                .checkBoxSalary();
    }
    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы с заполнением поля поиска и сортировки с последующим сбросом сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormFullSortingShouldBeReset () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions)
                .choiceFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .choiceSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .choiceQualification(dataFakerQualification.qualificationOptions)
                .choiceProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setSalary(dataFakerSalary.salaryOptions)
                .choiceTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .choiceTypeWork(dataFakerTypeWork.typeWorkOptions)
                .setCheckBoxWork()
                .setCheckBoxCompany()
                .resetCareerSorting()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResetSpecialization(dataCareerPage.defaultSpecializationField)
                .checkResetQualification(dataCareerPage.defaultQualificationField)
                .checkResetProfessionalSkills()
                .checkResetSalary()
                .checkResetCurrency(dataCareerPage.defaultTypeSalary)
                .checkResetLocation()
                .checkResetTypeWork(dataCareerPage.defaultTypeWork)
                .checkColorBoxRemotelyAfterReset()
                .checkColorBoxITCompanyAfterReset()
                .checkBoxSalary()
                .checkColorBoxRemotelyAfterReset()
                .checkColorBoxITCompanyAfterReset();
    }
    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы c пустым полем и заполненной сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmptyShouldHaveFullSorting () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .setSearchTesting(dataCareerPage.searchValueEmpty)
                .choiceFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .choiceSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .choiceQualification(dataFakerQualification.qualificationOptions)
                .choiceProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setSalary(dataFakerSalary.salaryOptions)
                .choiceTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .choiceTypeWork(dataFakerTypeWork.typeWorkOptions)
                .setCheckBoxWork()
                .setCheckBoxCompany()

                .checkSearchField(dataCareerPage.searchValueEmpty)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResultsSkills(dataFakerSkills.profSkillsOptions)
                .checkResultsSalary(String.valueOf(dataFakerSalary.salaryOptions))
                .checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions)
                .checkResultsEmployment(dataFakerTypeWork.typeWorkOptions)
                .checkBoxWork()
                .checkBoxCompany()
                .checkBoxSalary();
    }
}
