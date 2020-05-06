package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TodayPage {

    String APP_ELEMENT_CSS = "#todoist_app";

    //TODO уточнить как словить лоадер +Condition ShouldNotBe visible
    public TodayPage isPageOpened() {
        sleep(5000);
        $(APP_ELEMENT_CSS).waitUntil(Condition.appear, 30);
        return this;
    }


}
