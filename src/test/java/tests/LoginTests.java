package tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void signIn() {
        todoistSteps
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3")
                .logOut();
    }
}
