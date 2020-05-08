package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    String URL = "https://todoist.com/users/showLogin";
    String EMAIL_INPUT_CSS = "#email";
    String PASSWORD_INPUT_CSS = "#password";
    String LOGIN_BUTTON_CSS = ".submit_btn";
    String WARNING_CIRCLE_ICON = ".cmp_warning_circle"; // "Неверный Email-адрес." //Не указан пароль. //Неверный Email или пароль.

    public LoginPage openPage() {
        open(URL);
        $(LOGIN_BUTTON_CSS).waitUntil(Condition.appear, 30);
        return this;
    }

    public LoginPage signIn(String user, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(user);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return this;
    }


    public LoginPage checkForErrorMessage() {
        $(EMAIL_INPUT_CSS).sendKeys("");
        $(PASSWORD_INPUT_CSS).sendKeys("");
        $(LOGIN_BUTTON_CSS).click();
        $(WARNING_CIRCLE_ICON).should(Condition.exist);
        $(EMAIL_INPUT_CSS).sendKeys("123@gmail.com");
        $(PASSWORD_INPUT_CSS).sendKeys("");
        $(LOGIN_BUTTON_CSS).click();
        $(WARNING_CIRCLE_ICON).shouldBe(Condition.exist);
        $(EMAIL_INPUT_CSS).clear();
        $(EMAIL_INPUT_CSS).sendKeys("123@gmail.com");
        $(PASSWORD_INPUT_CSS).sendKeys("123456");
        $(LOGIN_BUTTON_CSS).click();
        $(WARNING_CIRCLE_ICON).shouldBe(Condition.exist);
        return this;
    }
}
