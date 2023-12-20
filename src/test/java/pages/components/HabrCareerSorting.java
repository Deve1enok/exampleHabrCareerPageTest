package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HabrCareerSorting {
    private final SelenideElement tableCareerSorting = $(".content-wrapper__sidebar");
    private final SelenideElement boxTypeWork = $("span.checkbox__button", 1);
    private final SelenideElement boxTypeCompany = $("span.checkbox__button", 2);
    private final SelenideElement boxTypeSalary = $("span.checkbox__button", 0);

    public void checkResult(String value) {
        tableCareerSorting.shouldHave(text(value));
    }

    public void checkBoxWorkRemotely() {
        boxTypeWork.shouldHave(cssValue("border-color", "rgb(102, 102, 102)"));
    }

    public void checkBoxITCompany() {
        boxTypeCompany.shouldHave(cssValue("border-color", "rgb(102, 102, 102)"));
    }

    public void checkBoxTypeSalary() {
        boxTypeSalary.shouldHave(cssValue("border-color", "rgba(0, 0, 0, 0)"));
    }
    public void defaultBoxRemotely() {
        boxTypeSalary.shouldHave(cssValue("border-color", "rgba(0, 0, 0, 0)"));
    }
    public void defaultBoxITCompany() {
        boxTypeSalary.shouldHave(cssValue("border-color", "rgba(0, 0, 0, 0)"));
    }
}