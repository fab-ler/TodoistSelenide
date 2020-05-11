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

    //del
    String ADD_PROJECT_LINK = "//a[@class='action sel_add_project']";

    @Step("go to incoming tasks page")
    public IncomingTasksPage isPageOpened() {
        $(INCOMING_LINK_CSS).click();
        log.debug("Checking the IncomingTasksPage is opened.");
        $(INCOMING_TASKS_PROJECT_LINK_CSS).should(Condition.appear);
        return this;
    }


    //TODO написать метод проверки наличия созданных задач в массиве входящих
    public IncomingTasksPage checkForTasksAvailability() {
        $$(LIST_OF_TASKS).get(1).should(Condition.exist);
        return this;
    }

}
