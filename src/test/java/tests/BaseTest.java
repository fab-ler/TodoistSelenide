package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.TodoistSteps;
import tests.utils.TestListener;

@Listeners(TestListener.class)

public class BaseTest {

    TodoistSteps todoistSteps;

    @BeforeClass
    public void setUpBrowser() {
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        Configuration.screenshots = true;
        //TODO remove later
        Configuration.holdBrowserOpen = true;
        // STEPS
        todoistSteps = new TodoistSteps();
//        Configuration.browser = "chrome";
//        Configuration.headless = false;
    }

    //TODO delete later
//
//    @AfterMethod(alwaysRun = true)
//    public void closeBrowser() {
//        getWebDriver().quit();
//    }

}
