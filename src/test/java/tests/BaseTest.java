package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.TodoistSteps;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    TodoistSteps steps;

    @BeforeClass
    public void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        //TODO remove later
        Configuration.holdBrowserOpen = true;
    }

    @BeforeMethod
    public void openBrowser() {
        steps = new TodoistSteps();
    }

//    @AfterMethod
//    public void closeBrowser() {
//        getWebDriver().close();
//    }

}
