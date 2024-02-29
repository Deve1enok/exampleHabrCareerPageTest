package tests;

import data.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HabrCareerPage;
import pages.HabrCareerSearchEmployerPage;
import pages.HabrCareerSearchJobPage;

public class HabrCareerSearchFormEmployerTest extends BaseTest {
    HabrCareerPage habrCareerPage = new HabrCareerPage();
    HabrCareerSearchEmployerPage habrCareerSearchEmployer = new HabrCareerSearchEmployerPage();
    HabrCareerSearchJobPage habrCareerVacancies = new HabrCareerSearchJobPage();
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
                .setSearchTesting(dataFakerSearchValue.searchValueOptions);
        habrCareerVacancies.selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions);
        habrCareerSearchEmployer.setPayment(dataFakerSalary.salaryOptions);
        habrCareerVacancies.selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions);
        habrCareerSearchEmployer.selectCompany(dataCompanyValue.companyOptions);
        habrCareerVacancies.setCheckboxCompany();
        habrCareerSearchEmployer.setUniversity(dataUniversityValue.universityOptions)
                .setOnlineSchool(dataOnlineSchoolValue.schoolOptions)
                .setCheckboxReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .setCheckboxMoveWork()
                .setCheckboxRemoteWork()
                .selectActivityOnSite(dataActivityOnSiteValue.activityValue)
                .selectRandomExtraBox();

        habrCareerVacancies.checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResetProfessionalSkills();
        habrCareerSearchEmployer.checkResultsPayment(dataFakerSalary.salaryOptions);
        habrCareerVacancies.checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions);

        habrCareerSearchEmployer.checkReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
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
                .setSearchTesting(dataCareerPage.emptyString);

        habrCareerVacancies.checkSearchField(dataCareerPage.emptyString);
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
                .setSearchTesting(dataFakerSearchValue.searchValueOptions);

        habrCareerVacancies.checkSearchField(dataFakerSearchValue.searchValueOptions);
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
                .setSearchTesting(dataFakerSearchValue.searchValueOptions);
        habrCareerVacancies.selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions);
        habrCareerSearchEmployer.setPayment(dataFakerSalary.salaryOptions);
        habrCareerVacancies.selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions);
        habrCareerSearchEmployer.selectCompany(dataCompanyValue.companyOptions);
        habrCareerVacancies.setCheckboxCompany();
        habrCareerSearchEmployer.setUniversity(dataUniversityValue.universityOptions)
                .setOnlineSchool(dataOnlineSchoolValue.schoolOptions)
                .setCheckboxReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .setCheckboxMoveWork()
                .setCheckboxRemoteWork()
                .selectActivityOnSite(dataActivityOnSiteValue.activityValue)
                .selectRandomExtraBox();
        habrCareerVacancies.resetCareerSorting()

                .checkSearchField(dataFakerSearchValue.searchValueOptions)
                .checkResetSpecialization(dataCareerPage.defaultSpecializationField)
                .checkResetQualification(dataCareerPage.emptyString)
                .checkResetProfessionalSkills();
        habrCareerSearchEmployer.checkResultsPaymentAfterReset(dataCareerPage.emptyString);
        habrCareerVacancies.checkResetCurrency(dataCareerPage.defaultTypeSalary)
                .checkResetLocation();
        habrCareerSearchEmployer.checkReadyToWork(dataCareerPage.emptyString)
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
                .setSearchTesting(dataCareerPage.emptyString);
        habrCareerVacancies.selectFirstSpecialization(dataFakerSpecialization.specializationOptions)
                .selectSecondSpecialization(dataFakerSpecialization.getSpecializationOption)
                .selectQualification(dataFakerQualification.qualificationOptions)
                .selectProfessionalSkills(dataFakerSkills.profSkillsOptions);
        habrCareerSearchEmployer.setPayment(dataFakerSalary.salaryOptions);
        habrCareerVacancies.selectTypeSalary(dataFakerCurrency.currencySalaryOptions)
                .setLocation(dataFakerLocation.locationOptions);
        habrCareerSearchEmployer.selectCompany(dataCompanyValue.companyOptions);
        habrCareerVacancies.setCheckboxCompany();
        habrCareerSearchEmployer.setUniversity(dataUniversityValue.universityOptions)
                .setOnlineSchool(dataOnlineSchoolValue.schoolOptions)
                .setCheckboxReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .setCheckboxMoveWork()
                .setCheckboxRemoteWork()
                .selectActivityOnSite(dataActivityOnSiteValue.activityValue)
                .selectRandomExtraBox();

        habrCareerVacancies.checkSearchField(dataCareerPage.emptyString)
                .checkResultsSpecialization(dataFakerSpecialization.getSpecializationOption)
                .checkResultsQualification(dataFakerQualification.qualificationOptions)
                .checkResetProfessionalSkills();
        habrCareerSearchEmployer.checkResultsPayment(dataFakerSalary.salaryOptions);
        habrCareerVacancies.checkResultsCurrency(dataFakerCurrency.currencySalaryOptions)
                .checkResultsLocation(dataFakerLocation.locationOptions);

        habrCareerSearchEmployer.checkReadyToWork(dataReadyToWorkValue.readyToWorkOptions)
                .checkResultsCheckboxReadyMoveWork()
                .checkResultsCheckboxReadyRemoteWork();
    }
}
