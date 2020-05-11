package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.TodoistSteps;
import tests.utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)

public class BaseTest {

    TodoistSteps todoistSteps;

    @BeforeClass
    public void setUpBrowser() {
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        Configuration.screenshots = true;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        //TODO remove later
        Configuration.holdBrowserOpen = true;
        Configuration.fastSetValue = true;
        // STEPS
        todoistSteps = new TodoistSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }

}
