package tests;

import org.testng.annotations.Test;

public class TodoistTest extends BaseTest {

    @Test
    public void createNewTask() {
        // open login page
        // login
        // click add task
        // add three tasks with three different terms
        // edit an existing task (priority, project)
        // fulfill task
        // delete task
        steps
                .wrongCredsErrorCheck()
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3")
                .newTaskAdd("A Task for today", 0)
                .newTaskAdd("A task for tomorrow", 1)
                .newTaskAdd("A Task for a next week", 2)
                .checkForIncomingTasks();
    }

}
