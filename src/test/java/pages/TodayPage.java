package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class TodayPage {

    String ADD_NEW_TASK_CSS = "#quick_add_task_holder";
    String CURRENT_URL = "https://todoist.com/app/#start";


    public TodayPage isPageOpened() {
        sleep(5000);
        assertEquals(url(), CURRENT_URL, "wrong homepage URL");
        return this;
    }

    public TodayPage clickTaskFastAdd() {
        $(ADD_NEW_TASK_CSS).click();
        return this;
    }

}
