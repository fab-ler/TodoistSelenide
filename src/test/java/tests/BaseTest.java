package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import steps.TodoistSteps;

public class BaseTest {
    TodoistSteps steps;

    @BeforeClass
    public void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        //TODO удалить конфиг "не закрывать браузер" после проверки
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
