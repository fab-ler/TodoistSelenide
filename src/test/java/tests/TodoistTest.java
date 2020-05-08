package tests;

import org.testng.annotations.Test;

public class TodoistTest extends BaseTest {

    @Test
    public void createNewTask() {
        // open login page
        // login
        // click add task
        // fill in form
        // save done
        steps
                .wrongCredsErrorCheck()
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3")
                .newTaskAdd("A task for tomorrow", 2)
                .newTaskAdd("A Task without a term", 1)
                .checkForIncomingTasks();
    }

}
