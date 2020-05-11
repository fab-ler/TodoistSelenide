package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class NewProjectAddTests extends BaseTest {

    @BeforeMethod
    public void loginUsingValidCredentials() {
        todoistSteps.signIn("tmsaqa3@gmail.com", "pswrdAQA3");
    }

//    @AfterMethod()
//    public void logout() {
//        todoistSteps.logOut();
//    }

    @Step("add a new project")
    @Test(priority = 4)
    public void addNewProject() {
        todoistSteps
                .addNewProject();
    }
}
