package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class TodoistTest extends BaseTest {

    @Step("add several new tasks and check incoming tasks")
    @Test(priority = 2)
    public void createNewTask() {
        todoistSteps
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3")
                .newTaskAdd("A Task for today", 0)
                .newTaskAdd("A task for tomorrow", 1)
                .newTaskAdd("A Task for a next week", 2)
                .checkForIncomingTasks();
    }

}
