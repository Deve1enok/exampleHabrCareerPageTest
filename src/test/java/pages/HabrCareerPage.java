package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.HabrCareerSorting;
import utils.DataExtraPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.valueOf;

public class HabrCareerPage {
    DataExtraPage dataDops = new DataExtraPage();
    private final SelenideElement searchCareerInput = $(".l-page-title__input"),
            searchCareerSubmit = $(".l-page-title__form-submit"),
            specializationField = $(".specs-picker__specs-placeholder"),
            mainSpecialization = $(".specs-selector").$("div"),
            secondSpecialization = $(".specs-selector__categories-wrapper"),
            buttonApplyChoiceSpecialization = $(".basic-section--appearance-specs").find(byText("Применить")),
            qualificationField = $(".basic-section--appearance-sidebar").find("select.select__input"),
            skillsField = $(".basic-section--appearance-sidebar").$("input[placeholder='Выберите навык']"),
            dropDownSkills = $(".suggestion-results"),
            salaryField = $(".basic-section--appearance-sidebar").$("input[placeholder='От']"),
            resultSalaryField = $(".text-input__input", 3),
            locationField = $(".basic-section--appearance-sidebar").$("input[placeholder='Введите город, область или страну']"),
            checkBoxDropDown = $(".suggestion-item"),
            skillsList = $(".inline-list", 2),
            locationList = $(".inline-list", 3),
            resultSpecialization = $(".specs-picker__specs"),
            currencyList = $(".basic-section--appearance-sidebar").$("select.select__input", 1),
            typeWorkField = $(".basic-section--appearance-sidebar").$("select.select__input", 2),
            boxTypeWork = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 1),
            boxCompany = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 2),
            resetSorting = $(".filters-controls").$(".button-comp"),
            employmentField = $(".select__input", 3),
            inputSearchField = $(".text-input__input"),
            employerSwitchButton = $("[href='/info/employer']"),
            paymentField = $(".basic-section--appearance-sidebar").$("input[placeholder='До']"),
            companyField = $(".basic-section--appearance-sidebar").$("input[placeholder='Выберите компанию']"),
            universityField = $(".basic-section--appearance-sidebar").$("input[placeholder='Выберите ВУЗ']"),
            onlineSchoolField = $(".basic-section--appearance-sidebar").$("input[placeholder='Выберите онлайн-школу']"),
            boxReadyForMoveWork = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 5),
            boxReadyForRemoteWork = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 6),
            extraBoxEducation0 = $(".basic-section--appearance-sidebar").$("[class='checkbox']",7),
            extraBoxEducation1 = $(".basic-section--appearance-sidebar").$("[class='checkbox']",8),
            extraBoxEducation2 = $(".basic-section--appearance-sidebar").$("[class='checkbox']",9),
            extraBoxEducation3 = $(".basic-section--appearance-sidebar").$("[class='checkbox']",10),
            extraBoxEducation4 = $(".basic-section--appearance-sidebar").$("[class='checkbox']",11),
            siteActivityField = $(".select__input", 4);

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

    @Step("Ввести в поле поиска пустое значение")
    public HabrCareerPage setSearchTesting(String value) {
        searchCareerInput.setValue(value);
        searchCareerSubmit.click();
        return this;
    }

    @Step("Выбрать специализацию {specialization}")
    public HabrCareerPage choiceFirstSpecialization(String specialization) {
        specializationField.click();
        mainSpecialization.find(byText(specialization)).click();
        return this;
    }

    @Step("Выбрать узкую направленность специализации {specialization}")
    public HabrCareerPage choiceSecondSpecialization(String specialization) {
        secondSpecialization.find((byText(specialization))).scrollTo().click();
        buttonApplyChoiceSpecialization.click();
        return this;
    }

    @Step("Выбрать квалификацию")
    public HabrCareerPage choiceQualification(String qualification) {
        qualificationField.selectOptionByValue(qualification);
        return this;
    }

    @Step("Выбрать профессиональные навыки {skill}")
    public HabrCareerPage choiceProfessionalSkills(String skill) {
        skillsField.click();
        skillsField.setValue(skill);
        dropDownSkills.find(byText(skill)).click();
        return this;
    }

    @Step("Вввести зарплату {salaryOptions}")
    public HabrCareerPage setSalary(int salaryOptions) {
        salaryField.setValue(valueOf(salaryOptions));
        return this;
    }

    @Step("Выбрать тип валюты зарплаты {currency}")
    public HabrCareerPage choiceTypeSalary(String currency) {
        currencyList.selectOptionByValue(currency);
        return this;
    }

    @Step("Выбрать местоположение {location}")
    public HabrCareerPage setLocation(String location) {
        locationField.click();
        locationField.setValue(location);
        checkBoxDropDown.find(byText(location)).click();
        return this;
    }

    @Step("Выбрать тип занятости")
    public HabrCareerPage choiceTypeWork(String typeWork) {
        typeWorkField.selectOptionByValue(typeWork);
        return this;
    }

    @Step("Выбрать тип удаленной работы")
    public HabrCareerPage setCheckBoxWork() {
        boxTypeWork.click();
        return this;
    }

    @Step("Выбрать тип компаний")
    public HabrCareerPage setCheckBoxCompany() {
        boxCompany.click();
        return this;
    }

    @Step("Сбросить сортировку вакансий")
    public HabrCareerPage resetCareerSorting() {
        resetSorting.click();
        return this;
    }

    @Step("Проверка значения поля зарплаты")
    public HabrCareerPage checkResultsSalary(String value) {
        resultSalaryField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка выбора типа валюты")
    public HabrCareerPage checkResultsCurrency(String value) {
        currencyList.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка значения поля специализации")
    public HabrCareerPage checkResultsSpecialization(String value) {
        resultSpecialization.shouldHave(exactText(value));
        return this;
    }

    @Step("Проверка значения поля квалификации")
    public HabrCareerPage checkResultsQualification(String value) {
        qualificationField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка значения поля профессиональные навыки")
    public HabrCareerPage checkResultsSkills(String value) {
        skillsList.shouldHave(text(value));
        return this;
    }

    @Step("Проверка значения поля местоположения")
    public HabrCareerPage checkResultsLocation(String value) {
        locationList.shouldHave(text(value));
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
    public HabrCareerPage checkColorBoxSalary() {
        habrCareerSorting.checkBoxTypeSalary();
        return this;
    }

    @Step("Проверка на заполнение типа занятости")
    public HabrCareerPage checkResultsEmployment(String value) {
        employmentField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Специализации\" после сброса")
    public HabrCareerPage checkResetSpecialization(String value) {
        specializationField.shouldHave(text(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Квалификации\" после сброса")
    public HabrCareerPage checkResetQualification(String value) {
        qualificationField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Профессиональные навыки\" после сброса")
    public HabrCareerPage checkResetProfessionalSkills() {
        skillsField.shouldHave(empty);
        return this;
    }

    @Step("Проверка на пустое поле \"Зарплата\" после сброса")
    public HabrCareerPage checkResetSalary() {
        salaryField.shouldHave(empty);
        return this;
    }

    @Step("Проверка \"Типа валюты\" после сброса")
    public HabrCareerPage checkResetCurrency(String value) {
        currencyList.shouldHave(value(value));
        return this;
    }

    @Step("Проверка на пустое поле \"Местоположение\" после сброса")
    public HabrCareerPage checkResetLocation() {
        locationField.shouldHave(empty);
        return this;
    }

    @Step("Проверка на пустое поле \"Тип занятости\" после сброса")
    public HabrCareerPage checkResetTypeWork(String value) {
        typeWorkField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка на цвет чек-бокса удаленной работы после сброса")
    public HabrCareerPage checkColorBoxRemotelyAfterReset() {
        habrCareerSorting.checkDefaultColorBoxRemotely();
        return this;
    }

    @Step("Проверка на цвет чек-бокса IT-компаний после сброса")
    public HabrCareerPage checkColorBoxITCompanyAfterReset() {
        habrCareerSorting.checkDefaultColorBoxITCompany();
        return this;
    }

    @Step("Проверка поля поиска {value}")
    public HabrCareerPage checkSearchField(String value) {
        inputSearchField.shouldHave(Condition.value((value)));
        return this;
    }

    @Step("Выбрать поиск для работодателей")
    public HabrCareerPage choiceEmployerButton() {
        employerSwitchButton.click();
        return this;
    }

    @Step("Вввести вознаграждение {paymentOptions}")
    public HabrCareerPage setPayment(int paymentOptions) {
        paymentField.setValue(valueOf(paymentOptions));
        return this;
    }

    @Step("Выбрать компанию {company}")
    public HabrCareerPage choiceCompany(String company) {
        companyField.click();
        companyField.setValue(company);
        checkBoxDropDown.find(byText(company)).click();
        return this;
    }
    @Step("Выбрать высшее образование {university}")
    public HabrCareerPage setUniversity(String university) {
        universityField.click();
        universityField.setValue(university);
        checkBoxDropDown.find(byText(university)).click();
        return this;
    }
    @Step("Выбрать допобразование {school}")
    public HabrCareerPage setOnlineSchool(String school) {
        onlineSchoolField.click();
        onlineSchoolField.setValue(school);
        checkBoxDropDown.find(byText(school)).click();
        return this;
    }
    @Step("Выбрать тип готовности к работе")
    public HabrCareerPage setCheckBoxReadyToWork(String value) {
        typeWorkField.selectOptionByValue(value);
        return this;
    }
    @Step("Выбрать \"Готов к переезду\"")
    public HabrCareerPage setCheckBoxMoveWork() {
        boxReadyForMoveWork.click();
        return this;
    }
    @Step("Выбрать \"Готов к удаленной работе\"")
    public HabrCareerPage setCheckBoxRemoteWork() {
        boxReadyForRemoteWork.click();
        return this;
    }
    @Step("Проверка выбора \"Активность на сайте\"")
    public HabrCareerPage choiceActivityOnSite(String value) {
        siteActivityField.selectOptionByValue(value);
        return this;
    }
    @Step("Выбрать дополнительно {value} и проверить цвет выбранной ячейки")
    public HabrCareerPage setExtraBoxAndCheckColorBoxAfterSet(int value) {

        if(dataDops.randomNum == 0){
            extraBoxEducation0.click();
            extraBoxEducation0.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation0.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
        }else if(dataDops.randomNum == 1){
            extraBoxEducation1.click();
            extraBoxEducation1.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation1.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
        }else if(dataDops.randomNum == 2){
            extraBoxEducation2.click();
            extraBoxEducation2.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation2.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
        }else if(dataDops.randomNum == 3){
            extraBoxEducation3.click();
            extraBoxEducation3.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation3.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
        }else if(dataDops.randomNum == 4){
            extraBoxEducation4.click();
            extraBoxEducation4.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation4.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
        }else{
            extraBoxEducation0.click();
            extraBoxEducation0.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation0.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
            extraBoxEducation1.click();
            extraBoxEducation1.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation1.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
            extraBoxEducation2.click();
            extraBoxEducation2.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation2.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
            extraBoxEducation3.click();
            extraBoxEducation3.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation3.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
            extraBoxEducation4.click();
            extraBoxEducation4.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
            extraBoxEducation4.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
        }
        return this;
    }
    @Step("Проверка заполнения вознаграждения {value}")
    public HabrCareerPage checkResultsPayment (int value) {
        paymentField.shouldHave(exactValue((valueOf(value))));
        return this;
    }
    @Step("Проверка заполнения готовности к работе {value}")
    public HabrCareerPage checkReadyToWork(String value) {
        typeWorkField.shouldHave(exactValue(value));
        return this;
    }
    @Step("Проверка на цвет чек-бокса \"Готов к переезду\"")
    public HabrCareerPage checkCSSBoxReadyMoveWork() {
        habrCareerSorting.checkActivityBoxReadyMoveWork();
        return this;
    }
    @Step("Проверка на цвет чек-бокса \"Готов к удаленной работе\"")
    public HabrCareerPage checkCSSBoxReadyRemoteWork() {
        habrCareerSorting.checkActivityBoxReadyRemoteWork();
        return this;
    }
    @Step("Проверка пустого поля вознаграждения {value}")
    public HabrCareerPage checkResultsPaymentAfterReset (String value) {
        paymentField.shouldHave(exactValue((value)));
        return this;
    }
}