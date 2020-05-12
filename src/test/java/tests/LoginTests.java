package tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Step("successful SignIn and LogOut")
    @Test
    public void signIn() {
        todoistSteps
                .signIn("tmsaqa3@gmail.com", "pswrdAQA3")
                .logOut();
    }
}
