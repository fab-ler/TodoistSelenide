package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FastTaskAddModal {

    String ADD_TASK_ICON_CSS = ".item_editor_submit";
    String TASK_NAME_INPUT_CSS = ".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr";
    String SUBMIT_BUTTON_TEST = "//*[@id='reactist-modal-box-0']/section/form/div[2]/button";

    public FastTaskAddModal isPageOpened() {
        $(ADD_TASK_ICON_CSS).should(Condition.appear);
        return this;
    }

    public FastTaskAddModal FastAddNewTaskWithTerm(String taskname) {
        $(TASK_NAME_INPUT_CSS).sendKeys(taskname);
        sleep(30);
        $(By.xpath(SUBMIT_BUTTON_TEST)).click();
        return this;
    }
}
