package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataCareer;
import io.qameta.allure.Step;
import pages.components.HabrCareerSorting;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class HabrCareerSearchJobPage {
    HabrCareerSorting habrCareerSorting = new HabrCareerSorting();
    DataCareer dataCareer = new DataCareer();

    private final SelenideElement specializationField = $(".specs-picker__specs-placeholder"),
            mainSpecialization = $(".specs-selector").$("div"),
            secondSpecialization = $(".specs-selector__categories-wrapper"),
            buttonApplySelectSpecialization = $(".basic-section--appearance-specs")
                    .find(byText("Применить")),
            qualificationField = $(".basic-section--appearance-sidebar")
                    .find("select.select__input"),
            skillsField = $(".basic-section--appearance-sidebar")
                    .$("input[placeholder='Выберите навык']"),
            dropDownSkills = $(".suggestion-results"),
            salaryField = $(".basic-section--appearance-sidebar")
                    .$("input[placeholder='От']"),
            resultSalaryField = $(".text-input__input", 3),
            locationField = $(".basic-section--appearance-sidebar").
                    $("input[placeholder='Введите город, область или страну']"),
            skillsList = $(".inline-list", 2),
            locationList = $(".inline-list", 3),
            resultSpecialization = $(".specs-picker__specs"),
            currencyList = $(".basic-section--appearance-sidebar")
                    .$("select.select__input", 1),
            boxTypeWork = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 1),
            boxCompany = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 2),
            resetSorting = $(".filters-controls").$(".button-comp"),
            employmentField = $(".select__input", 3),
            inputSearchField = $(".text-input__input"),
            checkboxDropDown = $(".suggestion-item"),
            typeWorkField = $(".basic-section--appearance-sidebar")
                    .$("select.select__input", 2);


    @Step("Выбрать специализацию {specialization}")
    public HabrCareerSearchJobPage selectFirstSpecialization(String specialization) {
        specializationField.click();
        mainSpecialization.find(byText(specialization)).click();
        return this;
    }

    @Step("Выбрать узкую направленность специализации {specialization}")
    public HabrCareerSearchJobPage selectSecondSpecialization(String specialization) {
        secondSpecialization.find((byText(specialization))).scrollTo().click();
        buttonApplySelectSpecialization.click();
        return this;
    }

    @Step("Выбрать квалификацию")
    public HabrCareerSearchJobPage selectQualification(String qualification) {
        qualificationField.selectOptionByValue(qualification);
        return this;
    }

    @Step("Выбрать профессиональные навыки {skill}")
    public HabrCareerSearchJobPage selectProfessionalSkills(String skill) {
        skillsField.click();
        skillsField.setValue(skill);
        dropDownSkills.find(byText(skill)).click();
        return this;
    }

    @Step("Вввести зарплату {salaryOptions}")
    public HabrCareerSearchJobPage setSalary(int salaryOptions) {
        salaryField.setValue(valueOf(salaryOptions));
        return this;
    }

    @Step("Выбрать тип валюты зарплаты {currency}")
    public HabrCareerSearchJobPage selectTypeSalary(String currency) {
        currencyList.selectOptionByValue(currency);
        return this;
    }

    @Step("Выбрать местоположение {location}")
    public HabrCareerSearchJobPage setLocation(String location) {
        locationField.click();
        locationField.setValue(location);
        checkboxDropDown.find(byText(location)).click();
        return this;
    }

    @Step("Выбрать тип занятости")
    public HabrCareerSearchJobPage selectTypeWork(String typeWork) {
        typeWorkField.selectOptionByValue(typeWork);
        return this;
    }

    @Step("Выбрать тип удаленной работы")
    public HabrCareerSearchJobPage setCheckboxWork() {
        boxTypeWork.click();
        return this;
    }

    @Step("Выбрать тип компаний")
    public HabrCareerSearchJobPage setCheckboxCompany() {
        boxCompany.click();
        return this;
    }

    @Step("Сбросить сортировку вакансий")
    public HabrCareerSearchJobPage resetCareerSorting() {
        resetSorting.click();
        return this;
    }

    @Step("Проверка значения поля зарплаты")
    public HabrCareerSearchJobPage checkResultsSalary(String value) {
        resultSalaryField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка выбора типа валюты")
    public HabrCareerSearchJobPage checkResultsCurrency(String value) {
        currencyList.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка значения поля специализации")
    public HabrCareerSearchJobPage checkResultsSpecialization(String value) {
        resultSpecialization.shouldHave(exactText(value));
        return this;
    }

    @Step("Проверка значения поля квалификации")
    public HabrCareerSearchJobPage checkResultsQualification(String value) {
        qualificationField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка значения поля профессиональные навыки")
    public HabrCareerSearchJobPage checkResultsSkills(String value) {
        skillsList.shouldHave(text(value));
        return this;
    }

    @Step("Проверка значения поля местоположения")
    public HabrCareerSearchJobPage checkResultsLocation(String value) {
        locationList.shouldHave(text(value));
        return this;
    }

    @Step("Проверка чек-бокса на активацию \"Можно удаленно\"")
    public HabrCareerSearchJobPage checkResultsCheckboxWork() {
        habrCareerSorting.checkboxWorkRemotely();
        return this;
    }

    @Step("Проверка чек-бокса на активацию IT-компаний")
    public HabrCareerSearchJobPage checkResultsCheckboxCompany() {
        habrCareerSorting.checkboxITCompany();
        return this;
    }

    @Step("Проверка чек-бокса на активацию \"Зарплата\"")
    public HabrCareerSearchJobPage checkResultsCheckboxSalary() {
        habrCareerSorting.checkboxTypeSalary();
        return this;
    }

    @Step("Проверка на заполнение типа занятости")
    public HabrCareerSearchJobPage checkResultsEmployment(String value) {
        employmentField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Специализации\" после сброса")
    public HabrCareerSearchJobPage checkResetSpecialization(String value) {
        specializationField.shouldHave(text(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Квалификации\" после сброса")
    public HabrCareerSearchJobPage checkResetQualification(String value) {
        qualificationField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Профессиональные навыки\" после сброса")
    public HabrCareerSearchJobPage checkResetProfessionalSkills() {
        skillsField.shouldHave(empty);
        return this;
    }

    @Step("Проверка на пустое поле \"Зарплата\" после сброса")
    public HabrCareerSearchJobPage checkResetSalary() {
        salaryField.shouldHave(empty);
        return this;
    }

    @Step("Проверка \"Типа валюты\" после сброса")
    public HabrCareerSearchJobPage checkResetCurrency(String value) {
        currencyList.shouldHave(value(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Местоположение\" после сброса")
    public HabrCareerSearchJobPage checkResetLocation() {
        locationField.shouldHave(empty);
        return this;
    }

    @Step("Проверка на пустое поле \"Тип занятости\" после сброса")
    public HabrCareerSearchJobPage checkResetTypeWorkAfterReset() {
        typeWorkField.shouldHave(exactValue(dataCareer.emptyString));
        return this;
    }

    @Step("Проверка чек-бокса удаленной работы после сброса")
    public HabrCareerSearchJobPage checkResultsCheckboxRemotelyAfterReset() {
        habrCareerSorting.checkDefaultColorBoxRemotely();
        return this;
    }

    @Step("Проверка чек-бокса IT-компаний после сброса")
    public HabrCareerSearchJobPage checkResultsCheckboxITCompanyAfterReset() {
        habrCareerSorting.checkDefaultColorBoxITCompany();
        return this;
    }

    @Step("Проверка поля поиска {value}")
    public HabrCareerSearchJobPage checkSearchField(String value) {
        inputSearchField.shouldHave(Condition.value((value)));
        return this;
    }
}
