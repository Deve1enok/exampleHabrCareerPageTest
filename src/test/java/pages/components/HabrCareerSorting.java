package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;

public class HabrCareerSorting {
    private final SelenideElement boxTypeWork = $("span.checkbox__button", 1);
    private final SelenideElement boxTypeCompany = $("span.checkbox__button", 2);
    private final SelenideElement boxTypeSalary = $("span.checkbox__button", 0);
    private final SelenideElement boxReadyForMoveWork = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 5);
    private final SelenideElement boxReadyForRemoteWork = $(".basic-section--appearance-sidebar").$("[class='checkbox']", 6);

    public void checkBoxWorkRemotely() {
        boxTypeWork.shouldHave(cssValue("border-color", "rgb(102, 102, 102)"));
    }
    public void checkBoxITCompany() {
        boxTypeCompany.shouldHave(cssValue("border-color", "rgb(102, 102, 102)"));
    }
    public void checkBoxTypeSalary() {
        boxTypeSalary.shouldHave(cssValue("border-color", "rgba(0, 0, 0, 0)"));
    }
    public void checkDefaultColorBoxRemotely() {
        boxTypeSalary.shouldHave(cssValue("border-color", "rgba(0, 0, 0, 0)"));
    }
    public void checkDefaultColorBoxITCompany() {
        boxTypeSalary.shouldHave(cssValue("border-color", "rgba(0, 0, 0, 0)"));
    }
    public void checkActivityBoxReadyMoveWork() {
        boxReadyForMoveWork.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
        boxReadyForMoveWork.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
    }
    public void checkActivityBoxReadyRemoteWork() {
        boxReadyForRemoteWork.shouldHave(cssValue("border-color", "rgb(70, 70, 70)"));
        boxReadyForRemoteWork.shouldHave(cssValue("background-color", "rgba(0, 0, 0, 0)"));
    }
}