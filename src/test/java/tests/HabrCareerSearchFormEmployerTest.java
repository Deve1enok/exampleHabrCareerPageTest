package tests;

import data.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HabrCareerPage;

public class HabrCareerSearchFormEmployerTest extends BaseTest {
    HabrCareerPage habrCareerPage = new HabrCareerPage();
    DataCareer dataCareerPage = new DataCareer();
    DataSpecializationsCareer dataFakerSpecialization = new DataSpecializationsCareer();
    DataQualificationsCareer dataFakerQualification = new DataQualificationsCareer();
    DataProfessionalSkillsCareer dataFakerSkills = new DataProfessionalSkillsCareer();
    DataSalaryCareer dataFakerSalary = new DataSalaryCareer();
    DataLocationCareer dataFakerLocation = new DataLocationCareer();
    DataCurrencySalaryCareer dataFakerCurrency = new DataCurrencySalaryCareer();
    DataSearchValueCareer dataFakerSearchValue = new DataSearchValueCareer();
    DataCompany dataCompanyValue = new DataCompany();
    DataUniversity dataUniversityValue = new DataUniversity();
    DataOnlineSchool dataOnlineSchoolValue = new DataOnlineSchool();
    DataReadyToWork dataReadyToWorkValue = new DataReadyToWork();
    DataActivityOnSite dataActivityOnSiteValue = new DataActivityOnSite();

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска специалистов habrCareer")
    @DisplayName("Поиск специалистов с заполнением поля поиска и сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormEmployerFullSorting() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .selectEmployerButton()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions)
                .selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setPayment(dataFakerSalary.salaryOptions)
                .selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .selectCompany(dataCompanyValue.companyOptions)
                .setCheckboxCompany()
                .setUniversity(dataUniversityValue.universityOptions)
                .setOnlineSchool(dataOnlineSchoolValue.schoolOptions)
                .setCheckboxReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .setCheckboxMoveWork()
                .setCheckboxRemoteWork()
                .selectActivityOnSite(dataActivityOnSiteValue.activityValue)
                .selectRandomExtraBox()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResetProfessionalSkills()
                .checkResultsPayment(dataFakerSalary.salaryOptions)
                .checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions)

                .checkReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .checkResultsCheckboxReadyMoveWork()
                .checkResultsCheckboxReadyRemoteWork();
    }

    @Test
    @Tag("negative_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска специалистов habrCareer")
    @DisplayName("Поиск специалистов c пустым полем поиска и сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmployerEmptyShouldHaveWorkPage() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .selectEmployerButton()
                .setSearchTesting(dataCareerPage.emptyString)

                .checkSearchField(dataCareerPage.emptyString);
    }

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска специалистов habrCareer")
    @DisplayName("Поиск специалистов с заполнением поля поиска и пустой сортировкой")
    @Story("Позитивные тесты")
    void searchCareerFormEmployerShouldHaveTestingPage() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .selectEmployerButton()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions)

                .checkSearchField(dataFakerSearchValue.searchValueOptions);
    }

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска специалистов habrCareer")
    @DisplayName("Поиск специалистов с заполнением поля поиска и сортировки с последующим сбросом сортировки")
    @Story("Позитивные тесты")
    void searchCareerFormEmployerFullSortingShouldBeReset() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .selectEmployerButton()
                .setSearchTesting(dataFakerSearchValue.searchValueOptions)
                .selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setPayment(dataFakerSalary.salaryOptions)
                .selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .selectCompany(dataCompanyValue.companyOptions)
                .setCheckboxCompany()
                .setUniversity(dataUniversityValue.universityOptions)
                .setOnlineSchool(dataOnlineSchoolValue.schoolOptions)
                .setCheckboxReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .setCheckboxMoveWork()
                .setCheckboxRemoteWork()
                .selectActivityOnSite(dataActivityOnSiteValue.activityValue)
                .selectRandomExtraBox()
                .resetCareerSorting()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResetSpecialization(dataCareerPage.defaultSpecializationField)
                .checkResetQualification(dataCareerPage.emptyString)
                .checkResetProfessionalSkills()
                .checkResultsPaymentAfterReset(dataCareerPage.emptyString)
                .checkResetCurrency(dataCareerPage.defaultTypeSalary)
                .checkResetLocation()
                .checkReadyToWork(dataCareerPage.emptyString)
                .checkResultsCheckboxReadyMoveWork()
                .checkResultsCheckboxReadyRemoteWork();
    }

    @Test
    @Tag("positive_test")
    @Owner("Fazlyakhemtov D.A.")
    @Feature("Форма поиска специалистов habrCareer")
    @DisplayName("Поиск специалистов c пустым полем и заполненной сортировкой")
    @Story("Негативные тесты")
    void searchCareerFormEmployerEmptyShouldHaveFullSorting() {

        habrCareerPage.openCareerPage(dataCareerPage.emptyString)
                .disableBanner()
                .selectEmployerButton()
                .setSearchTesting(dataCareerPage.emptyString)
                .selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions)
                .setPayment(dataFakerSalary.salaryOptions)
                .selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions)
                .selectCompany(dataCompanyValue.companyOptions)
                .setCheckboxCompany()
                .setUniversity(dataUniversityValue.universityOptions)
                .setOnlineSchool(dataOnlineSchoolValue.schoolOptions)
                .setCheckboxReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .setCheckboxMoveWork()
                .setCheckboxRemoteWork()
                .selectActivityOnSite(dataActivityOnSiteValue.activityValue)
                .selectRandomExtraBox()

                .checkSearchField(dataCareerPage.emptyString)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResetProfessionalSkills()
                .checkResultsPayment(dataFakerSalary.salaryOptions)
                .checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions)

                .checkReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .checkResultsCheckboxReadyMoveWork()
                .checkResultsCheckboxReadyRemoteWork();
    }
}
