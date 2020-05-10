package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

@Log4j2
public class TodayPage {

    String ADD_NEW_TASK_CSS = "#quick_add_task_holder";
    String CURRENT_URL = "https://todoist.com/app/#start";

    @Step("open homepage (Today)")
    public TodayPage isPageOpened() {
        sleep(5000);
        assertEquals(url(), CURRENT_URL, "wrong homepage URL");
        return this;
    }

    @Step("Click add a new task")
    public TodayPage clickTaskFastAdd() {
        $(ADD_NEW_TASK_CSS).click();
        return this;
    }

}
