package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.components.HabrCareerSorting;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Tag("")
@Feature("Форма регистрации студента DemoQa")
@DisplayName("Заполнение формы регистрации студента DemoQa")
public class HabrCareerPage {
    private final SelenideElement searchCareerInput = $(".l-page-title__input"),
            searchCareerSubmit = $(".l-page-title__form-submit"),
            choiceSpecializationField = $(".specs-picker__specs-placeholder"),
            choiceSpecializationTestingQa = $(".specs-selector").$("div",7),
            choiceSpecializationAutoTestingAqA = $("#category-10"),
            buttonApplyChoiceSpecialization = $(".basic-section--appearance-specs").find(byText("Применить")),
            choiceQualificationField = $(".basic-section--appearance-sidebar").find("select.select__input"),
            choiceSkills = $(".basic-section--appearance-sidebar").$("input[placeholder='Выберите навык']"),
            applySkills = $("div[data-suggestion-value='1012']"),
            setSalaryField = $(".basic-section--appearance-sidebar").$("input[placeholder='От']"),
            setLocationField = $(".basic-section--appearance-sidebar").$("input[placeholder='Введите город, область или страну']"),
            applyLocation = $("div[data-suggestion-value='ct_444']"),
            choiceTypeWork = $(".basic-section--appearance-sidebar").find("select.select__input",2),
            checkBoxTypeWork = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 1),
            checkBoxCompany = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 2),
            resetSorting = $(".filters-controls").$(".button-comp"),
            employmentField = $(".select__input",3),
            defaultSpecializationF = $(".specs-picker__specs-placeholder"),
            defaultQualificationF = $(".select__input",1),
            defaultTypeWorkF = $(".select__input",3),
            checkInputSearchField = $(".text-input__input");

    HabrCareerSorting habrCareerSorting = new HabrCareerSorting();
    @Step("Открыть главную страницу {value}")
    public HabrCareerPage openCareerPage(String value) {
        open(value);
        return this;
    }
    @Step("Отключить баннеры")
    public HabrCareerPage disableBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Ввести в поле поиска {value}")
    public HabrCareerPage searchTesting(String value) {
        searchCareerInput.setValue(value);
        searchCareerSubmit.click();
        return this;
    }
    @Step("Выбрать специализацию")
    public HabrCareerPage choiceSpecializationTesting() {
        choiceSpecializationField.click();
        choiceSpecializationTestingQa.click();
        choiceSpecializationAutoTestingAqA.click();
        buttonApplyChoiceSpecialization.click();
        return this;
    }
    @Step("Выбрать квалификацию {value}")
    public HabrCareerPage choiceQualification(String value) {
        choiceQualificationField.selectOptionByValue(value);
        return this;
    }
    @Step("Выбрать профессиональные навыки {value}")
    public HabrCareerPage choiceProfessionalSkills(String value) {
        choiceSkills.setValue(value);
        applySkills.click();
        return this;
    }
    @Step("Вввести зарплату {value}")
    public HabrCareerPage setSalary(String value) {
        setSalaryField.setValue(value);
        return this;
    }
    @Step("Ввести местоположение {value}")
    public HabrCareerPage setLocation(String value) {
        setLocationField.setValue(value);
        applyLocation.click();
        return this;
    }
    @Step("Выбрать тип занятости")
    public HabrCareerPage setTypeWork(String value) {
        choiceTypeWork.selectOptionByValue(value);
        return this;
    }
    @Step("Выбрать тип удаленную работу")
    public HabrCareerPage setCheckBoxWork() {
        checkBoxTypeWork.click();
        return this;
    }
    @Step("Выбрать тип компаний")
    public HabrCareerPage setCheckBoxCompany() {
        checkBoxCompany.click();
        return this;
    }
    @Step("Сбросить сортировку вакансий")
    public HabrCareerPage resetCareerSorting() {
        resetSorting.click();
        return this;
    }
    @Step("Проверка таблицы с введенными данными")
    public HabrCareerPage checkResultsSorting(String value) {
        habrCareerSorting.checkResult(value);
        return this;
    }
    @Step("Проверка на цвет чек-бокса удаленной работы")
    public HabrCareerPage checkBoxWork() {
        habrCareerSorting.checkBoxWorkRemotely();
        return this;
    }
    @Step("Проверка на цвет чек-бокса IT-компаний")
    public HabrCareerPage checkBoxCompany() {
        habrCareerSorting.checkBoxITCompany();
        return this;
    }
    @Step("Проверка на цвет чек-бокса зарплаты")
    public HabrCareerPage checkBoxSalary() {
        habrCareerSorting.checkBoxTypeSalary();
        return this;
    }
    @Step("Проверка на заполнение типа занятости")
    public HabrCareerPage checkEmployment(String value) {
        employmentField.shouldHave(text(value));
        return this;
    }
    @Step("Проверка на пустое поле \"Специализации\" после сброса")
    public HabrCareerPage checkResetSpecialization(String value) {
        defaultSpecializationF.shouldHave(text(value));
        return this;
    }
    @Step("Проверка на пустое поле \"Квалификации\" после сброса")
    public HabrCareerPage checkResetQualification (String value) {
        defaultQualificationF.shouldHave(text(value));
        return this;
    }
    @Step("Проверка на пустое поле \"Профессиональные навыки\" после сброса")
    public HabrCareerPage checkResetProfessionalSkills() {
        choiceSkills.shouldHave(empty);
        return this;
    }
    @Step("Проверка на пустое поле \"Зарплата\" после сброса")
    public HabrCareerPage checkResetSalary() {
        setSalaryField.shouldHave(empty);
        return this;
    }
    @Step("Проверка на пустое поле \"Местоположение\" после сброса")
    public HabrCareerPage checkResetLocation() {
        setLocationField.shouldHave(empty);
        return this;
    }
    @Step("Проверка на пустое поле \"Тип занятости\" после сброса")
    public HabrCareerPage checkResetTypeWork(String value) {
        defaultTypeWorkF.shouldHave(text(value));
        return this;
    }
    @Step("Проверка на цвет чек-бокса удаленной работы после сброса")
    public HabrCareerPage checkDefaultBoxRemotely() {
        habrCareerSorting.defaultBoxRemotely();
        return this;
    }
    @Step("Проверка на цвет чек-бокса IT-компаний после сброса")
    public HabrCareerPage checkDefaultBoxITCompany() {
        habrCareerSorting.defaultBoxITCompany();
        return this;
    }
    @Step("Проверка поля поиска на \"Тестирование\"")
    public HabrCareerPage checkSearchField(String value) {
        checkInputSearchField.shouldHave(Condition.value((value)));
        return this;
    }


}
