package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HabrCareerPage;
import utils.DataCareerPage;

@Tag("habrCareerTests")
@Feature("Форма поиска работы habrCareer")
@DisplayName("Заполнение формы поиска работы")
public class HabrCareerPageTest extends BaseTest {
    HabrCareerPage habrCareerPage = new HabrCareerPage();
    DataCareerPage dataCareerPage = new DataCareerPage();

    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы \"тестирование\" c пустой сортировкой")
    @Story("Позитивные тесты")
    void searchCareerFormShouldHaveTestingPage () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .searchTesting(dataCareerPage.searchValue)

                .checkSearchField(dataCareerPage.searchValue);
    }
    @Test
    @Tag("negative_test")
    @DisplayName("Поиск работы c пустым полем и пустой сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmptyShouldHaveWorkPage () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .searchTesting(dataCareerPage.searchValueEmpty)

                .checkSearchField(dataCareerPage.searchValueEmpty);
    }
    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы \"тестирование\" с заполнением сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormShouldHaveFullSorting () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .searchTesting(dataCareerPage.searchValue)
                .choiceSpecializationTesting()
                .choiceQualification(dataCareerPage.qualificationValue)
                .choiceProfessionalSkills(dataCareerPage.professionalSkillsValue)
                .setSalary(dataCareerPage.salaryValue)
                .setLocation(dataCareerPage.locationValue)
                .setTypeWork(dataCareerPage.typeWorkValue)
                .setCheckBoxWork()
                .setCheckBoxCompany()

                .checkSearchField(dataCareerPage.searchValue)
                .checkResultsSorting(dataCareerPage.qualificationValue)
                .checkResultsSorting(dataCareerPage.professionalSkillsValue)
                .checkResultsSorting(dataCareerPage.salaryValue)
                .checkResultsSorting(dataCareerPage.locationValue)
                .checkEmployment(dataCareerPage.checkTypeWorkValue)
                .checkBoxWork()
                .checkBoxCompany()
                .checkBoxSalary();
    }
    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы \"тестирование\" с заполнением сортировки и её сброса")
    @Story("Позитивные тесты")
    void searchCareerFormFullSortingShouldBeReset () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .searchTesting(dataCareerPage.searchValue)
                .choiceSpecializationTesting()
                .choiceQualification(dataCareerPage.qualificationValue)
                .choiceProfessionalSkills(dataCareerPage.professionalSkillsValue)
                .setSalary(dataCareerPage.salaryValue)
                .setLocation(dataCareerPage.locationValue)
                .setTypeWork(dataCareerPage.typeWorkValue)
                .setCheckBoxWork()
                .setCheckBoxCompany()
                .resetCareerSorting()

                .checkSearchField(dataCareerPage.searchValue)
                .checkResetSpecialization(dataCareerPage.defaultSpecializationField)
                .checkResetQualification(dataCareerPage.defaultQualificationField)
                .checkResetProfessionalSkills()
                .checkResetSalary()
                .checkResetLocation()
                .checkResetTypeWork(dataCareerPage.defaultTypeWorkField)
                .checkBoxSalary()
                .checkDefaultBoxRemotely()
                .checkDefaultBoxITCompany();
    }
    @Test
    @Tag("positive_test")
    @DisplayName("Поиск работы c пустым полем и заполненной сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmptyShouldHaveFullSorting () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        habrCareerPage.openCareerPage(dataCareerPage.openPage)
                .disableBanner()
                .searchTesting(dataCareerPage.searchValueEmpty)
                .choiceSpecializationTesting()
                .choiceQualification(dataCareerPage.qualificationValue)
                .choiceProfessionalSkills(dataCareerPage.professionalSkillsValue)
                .setSalary(dataCareerPage.salaryValue)
                .setLocation(dataCareerPage.locationValue)
                .setTypeWork(dataCareerPage.typeWorkValue)
                .setCheckBoxWork()
                .setCheckBoxCompany()
                .resetCareerSorting()

                .checkSearchField(dataCareerPage.searchValueEmpty)
                .checkResetSpecialization(dataCareerPage.defaultSpecializationField)
                .checkResetQualification(dataCareerPage.defaultQualificationField)
                .checkResetProfessionalSkills()
                .checkResetSalary()
                .checkResetLocation()
                .checkResetTypeWork(dataCareerPage.defaultTypeWorkField)
                .checkBoxSalary()
                .checkDefaultBoxRemotely()
                .checkDefaultBoxITCompany();
    }
}
