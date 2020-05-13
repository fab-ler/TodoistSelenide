package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class AddTasksTests extends BaseTest {

    @BeforeMethod
    public void loginUsingValidCredentials() {
        todoistSteps.signIn("tmsaqa3@gmail.com", "pswrdAQA3");
    }

    @AfterMethod
    public void logout() {
        todoistSteps.logOut();
    }

    @Test
    public void createNewTask() {
        todoistSteps
                .addNewTask("A Task for today", 0)
                .addNewTask("A task for tomorrow", 1)
                .addNewTask("A Task for a next week", 2)
                .checkForIncomingTasks();
    }
}
