package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class EditTaskModal {

    String TASK_NAME_TEXT = ".task_item_content_text";
    String CLOSE_MODAL_ICON = ".item_detail_close";
    String PRIORITY_SELECT_ICON = ".item_actions_priority";
    String PRIORITY_NAME = ".priority_picker_item_name";

    String SUBTASK_ADD_BUTTON = ".plus_add_button";
    String SUBTASK_NAME_INPUT = ".DraftEditor-editorContainer";
    String SUBTASK_PICK_DATE_BUTTON = ".item_editor_assign_due";
    String SUBTASK_DATE_ITEM = ".scheduler-suggestions-item-label";
    String SUBMIT_SUBTASK_BUTTON = "//button[@type='submit']";


    String MORE_ACTIONS_ICON = ".item_action.item_actions_more";
    String DELETE_OPTION_ITEM = ".danger_menu";
    String DELETE_COMFIRMATION_ALERT = ".delete_confirmation";
    String DELETE_COMFIRMATION_BUTTON = ".ist_button_red";


    String EDIT_TASK_ITEMS = ".task_item_actions";
    String EDIT_CONTEXT_MENU = ".ist_menu";
    String NEXT_WEEK_RESCHDULE_ICON = ".icon_next_week";
    String UNDO_TOAST = ".undo_toast_positioner";


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
    }

    public EditTaskModal deleteTask() {
        $(MORE_ACTIONS_ICON).click();
        sleep(30);
        $(DELETE_OPTION_ITEM).click();
        $(DELETE_COMFIRMATION_ALERT).should(Condition.appear);
        sleep(30);
        $(DELETE_COMFIRMATION_BUTTON).click();
//        sleep(30);
//        $(UNDO_TOAST).should(appear);
        return this;
    }



    public EditTaskModal editTaskProperties() {
        $(EDIT_TASK_ITEMS, 0).contextClick();
        $(EDIT_CONTEXT_MENU).should(exist);
        sleep(30);
        $(NEXT_WEEK_RESCHDULE_ICON).click();
        sleep(30);
        return this;
    }

}
