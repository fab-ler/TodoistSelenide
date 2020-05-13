package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import tests.utils.AllureUtils;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class EditTaskModal {

    String TASK_NAME_TEXT = ".task_item_content_text";
    String CLOSE_MODAL_ICON = ".item_detail_close";
    String MORE_ACTIONS_ICON = ".item_action.item_actions_more";
    String DELETE_OPTION_ITEM = ".danger_menu";
    String DELETE_COMFIRMATION_BUTTON = ".ist_button_red";
    String EDIT_TASK_ITEMS = ".task_item_actions";
    String EDIT_CONTEXT_MENU = ".ist_menu";
    String NEXT_WEEK_RESCHDULE_ICON = ".icon_next_week";
    String DELETE_MENU_ITEM = ".sel_delete_task.danger.menu_item";
    String DELETE_MENU_ITEM_SELECTED = ".on";
    String DELETE_COMFIRMATION_ALERT = ".delete_confirmation";
    String DETELE_CONFIRM_SUMBIT_BUTTON = "//button[@type='submit']";

    public EditTaskModal openModal() {
        log.info("Opening edit task modal");
        $(TASK_NAME_TEXT, 0).click();
        try {
            isModalOpened();
        } catch (NoSuchElementException e) {
            log.error("edit task modal is not opened");
            screenshot("edit_task_modal_not_opened");
            Assert.fail("edit task modal cannot be opened.");
        }
        return this;
    }

    void isModalOpened() {
        log.debug("Checking the edit modal page is opened.");
        $(CLOSE_MODAL_ICON).waitUntil(Condition.appear, 30);
        AllureUtils.takeScreenshot(getWebDriver());
    }

    public EditTaskModal deleteTaskThroughModal() {
        $(MORE_ACTIONS_ICON).click();
        sleep(30);
        AllureUtils.takeScreenshot(getWebDriver());
        $(DELETE_OPTION_ITEM).click();
        $(DELETE_COMFIRMATION_ALERT).should(Condition.appear);
        AllureUtils.takeScreenshot(getWebDriver());
        sleep(30);
        $(DELETE_COMFIRMATION_BUTTON).click();
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    public EditTaskModal editTaskProperties() {
        $(EDIT_TASK_ITEMS, 0).contextClick();
        $(EDIT_CONTEXT_MENU).should(exist);
        AllureUtils.takeScreenshot(getWebDriver());
        $(NEXT_WEEK_RESCHDULE_ICON).click();
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    public EditTaskModal deleteTask() {
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
