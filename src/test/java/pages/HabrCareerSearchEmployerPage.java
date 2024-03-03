package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.HabrCareerSorting;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class HabrCareerSearchEmployerPage {
    HabrCareerSorting habrCareerSorting = new HabrCareerSorting();

    private final SelenideElement paymentField = $(".basic-section--appearance-sidebar")
            .$("input[placeholder='До']"),
            companyField = $(".basic-section--appearance-sidebar")
                    .$("input[placeholder='Выберите компанию']"),
            universityField = $(".basic-section--appearance-sidebar")
                    .$("input[placeholder='Выберите ВУЗ']"),
            onlineSchoolField = $(".basic-section--appearance-sidebar")
                    .$("input[placeholder='Выберите онлайн-школу']"),
            boxReadyForMoveWork = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 5),
            boxReadyForRemoteWork = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 6),
            extraBoxEducation0 = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 7),
            extraBoxEducation1 = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 8),
            extraBoxEducation2 = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 9),
            extraBoxEducation3 = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 10),
            extraBoxEducation4 = $(".basic-section--appearance-sidebar")
                    .$("[class='checkbox']", 11),
            checkboxDropDown = $(".suggestion-item"),
            typeWorkField = $(".basic-section--appearance-sidebar")
                    .$("select.select__input", 2),
            siteActivityField = $(".select__input", 4);


    @Step("Вввести вознаграждение {paymentOptions}")
    public HabrCareerSearchEmployerPage setPayment(int paymentOptions) {
        paymentField.setValue(valueOf(paymentOptions));
        return this;
    }

    @Step("Выбрать компанию {company}")
    public HabrCareerSearchEmployerPage selectCompany(String company) {
        companyField.click();
        companyField.setValue(company);
        checkboxDropDown.find(byText(company)).click();
        return this;
    }

    @Step("Выбрать высшее образование {university}")
    public HabrCareerSearchEmployerPage setUniversity(String university) {
        universityField.click();
        universityField.setValue(university);
        checkboxDropDown.find(byText(university)).click();
        return this;
    }

    @Step("Выбрать допобразование {school}")
    public HabrCareerSearchEmployerPage setOnlineSchool(String school) {
        onlineSchoolField.click();
        onlineSchoolField.setValue(school);
        checkboxDropDown.find(byText(school)).click();
        return this;
    }

    @Step("Выбрать тип готовности к работе")
    public HabrCareerSearchEmployerPage setCheckboxReadyToWork(String value) {
        typeWorkField.selectOptionByValue(value);
        return this;
    }

    @Step("Выбрать \"Готов к переезду\"")
    public HabrCareerSearchEmployerPage setCheckboxMoveWork() {
        boxReadyForMoveWork.click();
        return this;
    }

    @Step("Выбрать \"Готов к удаленной работе\"")
    public HabrCareerSearchEmployerPage setCheckboxRemoteWork() {
        boxReadyForRemoteWork.click();
        return this;
    }

    @Step("Проверка выбора \"Активность на сайте\"")
    public HabrCareerSearchEmployerPage selectActivityOnSite(String value) {
        siteActivityField.selectOptionByValue(value);
        return this;
    }

    @Step("Выбрать все чекбоксы \"Дополнительно\"")
    public HabrCareerSearchEmployerPage selectAllExtraBox() {
        extraBoxEducation0.click();
        extraBoxEducation1.click();
        extraBoxEducation2.click();
        extraBoxEducation3.click();
        extraBoxEducation4.click();
        return this;
    }

    @Step("Проверка заполнения вознаграждения {value}")
    public HabrCareerSearchEmployerPage checkResultsPayment(int value) {
        paymentField.shouldHave(exactValue((valueOf(value))));
        return this;
    }

    @Step("Проверка заполнения готовности к работе {value}")
    public HabrCareerSearchEmployerPage checkReadyToWork(String value) {
        typeWorkField.shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверка чек-бокса на активацию \"Готов к переезду\"")
    public HabrCareerSearchEmployerPage checkResultsCheckboxReadyMoveWork() {
        habrCareerSorting.checkActivityBoxReadyMoveWork();
        return this;
    }

    @Step("Проверка чек-бокса на активацию \"Готов к удаленной работе\"")
    public HabrCareerSearchEmployerPage checkResultsCheckboxReadyRemoteWork() {
        habrCareerSorting.checkActivityBoxReadyRemoteWork();
        return this;
    }

    @Step("Проверка пустого поля вознаграждения {value}")
    public HabrCareerSearchEmployerPage checkResultsPaymentAfterReset(String value) {
        paymentField.shouldHave(exactValue((value)));
        return this;
    }
}
