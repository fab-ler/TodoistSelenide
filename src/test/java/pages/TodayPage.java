package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TodayPage {

    // иконка на странице сегодня "Вы выполнили все задачи на неделю! #TodoistZero" при отсутствии задач
    String EMPTY_TASKLIST_ICON_CSS = ".empty-state-header";
    String ADD_NEW_TASK_CSS = "#quick_add_task_holder";


    public TodayPage isPageOpened() {
        sleep(5000);
        $(EMPTY_TASKLIST_ICON_CSS).waitUntil(Condition.appear, 30);
        return this;
    }

    public TodayPage clickTaskFastAdd() {
        $(ADD_NEW_TASK_CSS).click();
        return this;
    }

}
