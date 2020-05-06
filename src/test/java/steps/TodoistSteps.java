package steps;

import pages.LoginPage;

public class TodoistSteps {
    LoginPage loginPage;

    public TodoistSteps() {
        loginPage = new LoginPage();
    }

    public TodoistSteps login(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
        // todayPage.isPageOpened();
        return this;
    }
}
