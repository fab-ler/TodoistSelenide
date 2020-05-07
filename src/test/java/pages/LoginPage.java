package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    String URL = "https://todoist.com/users/showLogin";
    String EMAIL_INPUT_CSS = "#email";
    String PASSWORD_INPUT_CSS = "#password";
    String LOGIN_BUTTON_CSS = ".submit_btn";

    public LoginPage openPage() {
        open(URL);
        $(LOGIN_BUTTON_CSS).waitUntil(Condition.appear, 30);
        return this;
    }

    public LoginPage login(String user, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(user);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return this;
    }


}
