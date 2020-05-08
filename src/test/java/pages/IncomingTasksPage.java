package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class IncomingTasksPage {

    String INCOMING_LINK_CSS = "#filter_inbox";
    String INCOMING_TASKS_PROJECT_LINK_CSS = ".project_link";
    String LIST_OF_TASKS = ".text.sel_item_content";

    public IncomingTasksPage isPageOpened() {
        $(INCOMING_LINK_CSS).click();
        $(INCOMING_TASKS_PROJECT_LINK_CSS).should(Condition.appear);
        return this;
    }
/*
    public IncomingTasksPage checkForTasksAvailability () {
        $$(LIST_OF_TASKS).shouldBe(empty);
    }
*/
}
