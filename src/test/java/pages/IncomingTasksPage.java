package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class IncomingTasksPage {

    String INCOMING_LINK_CSS = "#filter_inbox";
    String INCOMING_TASKS_PROJECT_LINK_CSS = ".project_link";
    String LIST_OF_TASKS = ".text.sel_item_content"; // .task_item_details

    @Step("go to incoming tasks page")
    public IncomingTasksPage isPageOpened() {
        $(INCOMING_LINK_CSS).click();
        $(INCOMING_TASKS_PROJECT_LINK_CSS).should(Condition.appear);
        return this;
    }

//    public IncomingTasksPage checkForTasksAvailability () {
//        $$(LIST_OF_TASKS).shouldHave(sizeGreaterThan(1));
//        return this;
//    }

}
