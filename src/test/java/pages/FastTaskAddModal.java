package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FastTaskAddModal {

    String ADD_TASK_ICON_CSS = ".item_editor_submit";
    String TASK_NAME_INPUT_CSS = ".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr";
    String TASK_SUBMIT_BUTTON_XPATH = "//button[@type='submit'][contains(.,'Добавить задачу')]";
    String TASK_DUE_TIME_INPUT_XPATH = "//*[@class='item_editor_assign_due']";
    String TASK_DUE_TIME_CALENDAR_VAL_XPATH = "//div[@class='scheduler-suggestions-item-label'][contains(.,'Сегодня')]";

    public FastTaskAddModal isPageOpened() {
        $(ADD_TASK_ICON_CSS).should(Condition.appear);
        return this;
    }

    public FastTaskAddModal fillInTaskDetails(String taskname) {
        $(TASK_NAME_INPUT_CSS).sendKeys(taskname);
        //    $(TASK_DUE_TIME_INPUT_XPATH).click();
        return this;
    }

    public FastTaskAddModal clickSubmitTaskButton() {
        //$(TASK_SUBMIT_BUTTON_XPATH).shouldBe(Condition.enabled, true).click();
        sleep(30);
        $(ADD_TASK_ICON_CSS).click();
        return this;
    }

}
