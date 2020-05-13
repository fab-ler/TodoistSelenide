package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class WrongCredsTests extends BaseTest {

    @Test
    public void wrongCredsErrorCheck() {
        todoistSteps
                .wrongCredsErrorCheck();
    }
}
