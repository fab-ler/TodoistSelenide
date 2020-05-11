package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.*;

@Log4j2
public class TodoistSteps {
    LoginPage loginPage;
    TodayPage todayPage;
    FastTaskAddModal fastTaskAddModal;
    IncomingTasksPage incomingTasksPage;
    AddProjectModal addProjectModal;

    public TodoistSteps() {
        loginPage = new LoginPage();
        todayPage = new TodayPage();
        fastTaskAddModal = new FastTaskAddModal();
        incomingTasksPage = new IncomingTasksPage();
        addProjectModal = new AddProjectModal();
    }

    @Step("signin attempt check with wrong Credendials")
    public TodoistSteps wrongCredsErrorCheck() {
        loginPage.openPage();
        loginPage.checkForErrorMessage();
        return this;
    }

    @Step("sign in with correct creds")
    public TodoistSteps signIn(String user, String password) {
        loginPage.openPage();
        loginPage.signIn(user, password);
        todayPage.isPageOpened();
        return this;
    }

    @Step("new task add")
    public TodoistSteps newTaskAdd(String taskName, int dateIndex) {
        todayPage.clickTaskFastAdd();
        fastTaskAddModal.isPageOpened();
        fastTaskAddModal.FastAddNewTaskWithTerm(taskName, dateIndex);
        return this;
    }

    @Step("go to incoming tasks page and check their availability")
    public TodoistSteps checkForIncomingTasks() {
        incomingTasksPage.isPageOpened();
        incomingTasksPage.checkForTasksAvailability();
        return this;
    }

    @Step("Logout")
    public TodoistSteps logOut() {
        loginPage.logOut();
        return this;
    }

    @Step("Add a new project")
    public TodoistSteps addNewProject() {
        addProjectModal.openProjectModal();
        return this;
    }

    @Step("complete an existing task")
    public TodoistSteps completeExistingTask() {
        incomingTasksPage.completeTask();
        return this;
    }
}
