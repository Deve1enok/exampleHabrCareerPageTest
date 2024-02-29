package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class HabrCareerPage {

    private final SelenideElement searchCareerInput = $(".l-page-title__input"),
            searchCareerSubmit = $(".l-page-title__form-submit"),
            employerSwitchButton = $("[href='/info/employer']");


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

    @Step("Выбрать поиск для работодателей")
    public HabrCareerPage selectEmployerButton() {
        employerSwitchButton.click();
        return this;
    }
}