package steps;

import pages.LoginPage;
import pages.TodayPage;

public class TodoistSteps {
    LoginPage loginPage;
    TodayPage todayPage;

    public TodoistSteps() {
        loginPage = new LoginPage();
        todayPage = new TodayPage();
    }

    public TodoistSteps login(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
        todayPage.isPageOpened();
        return this;
    }
}
