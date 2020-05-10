package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    String URL = "https://todoist.com/users/showLogin";
    String EMAIL_INPUT_CSS = "#email";
    String PASSWORD_INPUT_CSS = "#password";
    String LOGIN_BUTTON_CSS = ".submit_btn";
    String WARNING_CIRCLE_ICON = ".cmp_warning_circle"; // check for error msg: "Неверный Email-адрес." | Не указан пароль. | Неверный Email или пароль.

    @Step("open login page")
    public LoginPage openPage() {
        log.info("Opening Login page of the application by url: " + URL);
        open(URL);
        $(LOGIN_BUTTON_CSS).waitUntil(Condition.appear, 30);
        return this;
    }

    @Step("sign in with valid credentials")
    public LoginPage signIn(String user, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(user);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return this;
    }

    @Step("check for signin with wrong credentials")
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
