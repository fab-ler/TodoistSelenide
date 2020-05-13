package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class DeleteTaskTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenIncomigTasks() {
        todoistSteps
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3")
                .checkForIncomingTasks();
    }

    @AfterMethod
    public void logout() {
        todoistSteps.logOut();
    }

    @Test
    public void deleteTask() {
        todoistSteps.deleteTask();
    }
}
