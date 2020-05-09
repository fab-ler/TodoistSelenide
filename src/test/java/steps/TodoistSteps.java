package steps;

import pages.FastTaskAddModal;
import pages.IncomingTasksPage;
import pages.LoginPage;
import pages.TodayPage;

public class TodoistSteps {
    LoginPage loginPage;
    TodayPage todayPage;
    FastTaskAddModal fastTaskAddModal;
    IncomingTasksPage incomingTasksPage;

    public TodoistSteps() {
        loginPage = new LoginPage();
        todayPage = new TodayPage();
        fastTaskAddModal = new FastTaskAddModal();
        incomingTasksPage = new IncomingTasksPage();
    }

    public TodoistSteps wrongCredsErrorCheck() {
        loginPage.openPage();
        loginPage.checkForErrorMessage();
        return this;
    }

    public TodoistSteps signIn(String user, String password) {
        loginPage.openPage();
        loginPage.signIn(user, password);
        todayPage.isPageOpened();
        return this;
    }

    public TodoistSteps newTaskAdd(String taskName, int dateIndex) {
        todayPage.clickTaskFastAdd();
        fastTaskAddModal.isPageOpened();
        fastTaskAddModal.FastAddNewTaskWithTerm(taskName, dateIndex);
        return this;
    }

    public TodoistSteps checkForIncomingTasks() {
        incomingTasksPage.isPageOpened();
//        incomingTasksPage.checkForTasksAvailability();
        return this;
    }

}
