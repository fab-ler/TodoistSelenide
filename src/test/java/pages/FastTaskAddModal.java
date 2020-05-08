package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class FastTaskAddModal {

    String ADD_TASK_ICON_CSS = ".item_editor_submit";
    String TASK_NAME_INPUT_CSS = ".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr";
    String SELECT_TASK_DATE_CSS = ".item_editor_assign_due.item_editor_assign_due--has_date";
    String SUBMIT_BUTTON_XPATH = "//*[@id='reactist-modal-box-0']/section/form/div[2]/button";
    ElementsCollection SELECT_TASK_DATE_ICON_CSS = $$(".scheduler-suggestions-item-icon");

    public FastTaskAddModal isPageOpened() {
        $(ADD_TASK_ICON_CSS).should(Condition.appear);
        return this;
    }

    public FastTaskAddModal FastAddNewTaskWithTerm(String taskname, int dateIndex) {
        $(TASK_NAME_INPUT_CSS).sendKeys(taskname);
        sleep(30);
        $(SELECT_TASK_DATE_CSS).click();
        SELECT_TASK_DATE_ICON_CSS.get(dateIndex).click();
        sleep(30);
        $(By.xpath(SUBMIT_BUTTON_XPATH)).click();
        return this;
    }
}
