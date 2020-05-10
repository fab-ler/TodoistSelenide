package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.TodoistSteps;
import tests.utils.TestListener;
import utils.PropertyManager;

@Listeners(TestListener.class)
public class BaseTest {

    TodoistSteps todoistSteps;
    PropertyManager propertyManager;

    @BeforeClass
    public void setUpBrowser() {
        propertyManager = PropertyManager.getInstance();
        Configuration.timeout = 20000;
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        //TODO remove later
        Configuration.holdBrowserOpen = true;
        todoistSteps = new TodoistSteps();
//        Configuration.browser = "chrome";
//        Configuration.headless = false;
    }


    //TODO delete later
//    @BeforeMethod
//    public void openBrowser() {
//        todoistSteps = new TodoistSteps();
//    }
//
//    @AfterMethod
//    public void closeBrowser() {
//        getWebDriver().close();
//    }

}
