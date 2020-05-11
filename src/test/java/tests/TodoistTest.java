package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class TodoistTest extends BaseTest {

    @BeforeMethod
    public void loginUsingValidCredentials() {
        todoistSteps.signIn("tmsaqa3@gmail.com", "pswrdAQA3");
    }

    @AfterMethod
    public void logout() {
        todoistSteps.logOut();
    }

    @Step("add several new tasks and check incoming tasks")
    @Test(priority = 2)
    public void createNewTask() {
        todoistSteps
                .newTaskAdd("A Task for today", 0)
                .newTaskAdd("A task for tomorrow", 1)
                .newTaskAdd("A Task for a next week", 2)
                .checkForIncomingTasks();
    }

}
