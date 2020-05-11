package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class IncomingTasksPage {

    String INCOMING_LINK_CSS = "#filter_inbox";
    String INCOMING_TASKS_PROJECT_LINK_CSS = ".project_link";
    String LIST_OF_TASKS = ".text.sel_item_content"; // .task_item_details
    String ACTION_CHECKBOX = ".ist_checkbox";
    String UNDO_TOAST = ".undo_toast_positioner";


    @Step("go to incoming tasks page")
    public IncomingTasksPage isPageOpened() {
        $(INCOMING_LINK_CSS).click();
        log.debug("Checking the IncomingTasksPage is opened.");
        $(INCOMING_TASKS_PROJECT_LINK_CSS).should(Condition.appear);
        return this;
    }

    @Step("check that an array of tasks created is not empty")
    public IncomingTasksPage checkForTasksAvailability() {
        $$(LIST_OF_TASKS).get(1).should(Condition.exist);
        return this;
    }

    @Step("complete a task")
    public IncomingTasksPage completeTask() {
        $(ACTION_CHECKBOX, 1).click();
        $(UNDO_TOAST).should(Condition.appear);
        return this;
    }

}
