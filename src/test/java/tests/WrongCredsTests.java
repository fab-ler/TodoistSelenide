package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class WrongCredsTests extends BaseTest {

    @Step("check for signin error messages, when using wrong credentials")
    @Test(priority = 0)
    public void wrongCredsErrorCheck() {
        todoistSteps
                .wrongCredsErrorCheck();
    }
}
