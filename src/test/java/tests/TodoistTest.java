package tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class TodoistTest extends BaseTest {


    @Step("check for signin error messages, when using wrong credentials")
    @Test(priority = 0)
    // open login page
    // try to sign in with invalid credentials
    public void wrongCredsErrorCheck() {
        steps
                .wrongCredsErrorCheck();
    }

    @Step("successful sign in")
    @Test(priority = 1)
    public void signIn() {
        // open login page
        // sign in with correct credentials
        steps
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3");
    }

    @Step("add several new tasks and check incoming tasks")
    @Test(priority = 2)
    public void createNewTask() {
        // click add task
        // add three tasks with three different terms
        // edit an existing task (priority, project)
        // fulfill task
        // delete task
        steps
                .newTaskAdd("A Task for today", 0)
                .newTaskAdd("A task for tomorrow", 1)
                .newTaskAdd("A Task for a next week", 2)
                .checkForIncomingTasks();
    }

}
