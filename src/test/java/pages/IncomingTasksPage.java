package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import tests.utils.AllureUtils;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class IncomingTasksPage {

    String INCOMING_LINK_CSS = "#filter_inbox";
    String INCOMING_TASKS_PROJECT_LINK_CSS = ".project_link";
    String LIST_OF_TASKS = ".text.sel_item_content"; // .task_item_details
    String ACTION_CHECKBOX = ".ist_checkbox";
    String UNDO_TOAST = ".undo_toast_positioner";
    String EDIT_TASK_ITEMS = ".task_item_actions";
    String EDIT_CONTEXT_MENU = ".ist_menu";
    String NEXT_WEEK_RESCHDULE_ICON = ".icon_next_week";
    String DELETE_MENU_ITEM = ".sel_delete_task.danger.menu_item";
    String DELETE_MENU_ITEM_SELECTED = ".on";
    String DELETE_COMFIRMATION_ALERT = ".delete_confirmation";
    String DETELE_CONFIRM_SUMBIT_BUTTON = "//button[@type='submit']";

    public IncomingTasksPage isPageOpened() {
        $(INCOMING_LINK_CSS).click();
        log.debug("Checking the IncomingTasksPage is opened.");
        $(INCOMING_TASKS_PROJECT_LINK_CSS).should(Condition.appear);
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    public IncomingTasksPage checkForTasksAvailability() {
        $$(LIST_OF_TASKS).get(0).should(Condition.exist);
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    public IncomingTasksPage completeTask() {
        $(ACTION_CHECKBOX, 0).click();
        $(UNDO_TOAST).should(Condition.appear);
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    public IncomingTasksPage editTaskProperties() {
        $(EDIT_TASK_ITEMS, 0).contextClick();
        $(EDIT_CONTEXT_MENU).should(exist);
        AllureUtils.takeScreenshot(getWebDriver());
        $(NEXT_WEEK_RESCHDULE_ICON).click();
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    public IncomingTasksPage deleteTask() {
        $(EDIT_TASK_ITEMS, 0).contextClick();
        $(EDIT_CONTEXT_MENU).should(exist);
        AllureUtils.takeScreenshot(getWebDriver());
        $(DELETE_MENU_ITEM).hover();
        $(DELETE_MENU_ITEM_SELECTED).should(appear).click();
        $(DELETE_COMFIRMATION_ALERT).should(appear);
        $(By.xpath(DETELE_CONFIRM_SUMBIT_BUTTON)).click();
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

}
