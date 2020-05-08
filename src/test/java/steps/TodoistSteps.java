package steps;

import pages.FastTaskAddModal;
import pages.LoginPage;
import pages.TodayPage;

public class TodoistSteps {
    LoginPage loginPage;
    TodayPage todayPage;
    FastTaskAddModal fastTaskAddModal;

    public TodoistSteps() {
        loginPage = new LoginPage();
        todayPage = new TodayPage();
        fastTaskAddModal = new FastTaskAddModal();
    }

    public TodoistSteps login(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
        todayPage.isPageOpened();
        return this;
    }

    public TodoistSteps newTaskAdd(String taskName, int dateIndex) {
        todayPage.clickTaskFastAdd();
        fastTaskAddModal.isPageOpened();
        fastTaskAddModal.FastAddNewTaskWithTerm(taskName, dateIndex);

        return this;
    }
}
