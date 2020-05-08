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
                .login("tmsaqa3@gmail.com", "pswrdAQA3")
                .newTaskAdd("Fast Add Task creation", 2);
    }

}
