package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import tests.utils.AllureUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class FastTaskAddModal {

    String ADD_TASK_ICON_CSS = ".item_editor_submit";
    String TASK_NAME_INPUT_CSS = ".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr";
    String SELECT_TASK_DATE_CSS = ".item_editor_assign_due.item_editor_assign_due--has_date";
    String SUBMIT_BUTTON_XPATH = "//*[@id='reactist-modal-box-0']/section/form/div[2]/button";
    ElementsCollection SELECT_TASK_DATE_ICON_CSS = $$(".scheduler-suggestions-item-icon");

    @Step("click fast task modal")
    public FastTaskAddModal isPageOpened() {
        log.debug("Checking the FastTaskAddModal is opened.");
        $(ADD_TASK_ICON_CSS).should(Condition.appear);
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }

    @Step("add a new task fast task modal")
    public FastTaskAddModal FastAddNewTaskWithTerm(String taskname, int dateIndex) {
        $(TASK_NAME_INPUT_CSS).sendKeys(taskname);
        AllureUtils.takeScreenshot(getWebDriver());
        $(SELECT_TASK_DATE_CSS).click();
        AllureUtils.takeScreenshot(getWebDriver());
        SELECT_TASK_DATE_ICON_CSS.get(dateIndex).click();
        AllureUtils.takeScreenshot(getWebDriver());
        $(By.xpath(SUBMIT_BUTTON_XPATH)).click();
        AllureUtils.takeScreenshot(getWebDriver());
        return this;
    }
}
