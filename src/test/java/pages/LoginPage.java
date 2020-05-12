package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {

    String URL = "https://todoist.com/users/showLogin";
    String EMAIL_INPUT_CSS = "#email";
    String PASSWORD_INPUT_CSS = "#password";
    String LOGIN_BUTTON_CSS = ".submit_btn";
    String WARNING_CIRCLE_ICON = ".cmp_warning_circle"; // check for error msg: "Неверный Email-адрес." | Не указан пароль. | Неверный Email или пароль.
    String PREFERENCES_ICON = ".gear_normal";
    String PREFENRENCES_MENU_ITEMS = ".usermenu__row-label";
    String PREFERENCES_MENU_CONTAINER = "#setting_menu";
//    String LOADER_ICON = ".loading_screen--logo";


    public LoginPage openPage() {
        log.info("Opening Login page of the application by url: " + URL);
        open(URL);
        try {
            isPageOpened();
        } catch (NoSuchElementException e) {
            log.error("Page is not opened: element 'Login button' is not found.");
            screenshot("login_page_not_opened");
            Assert.fail("Login page cannot be opened.");
        }
        return this;
    }

    void isPageOpened() {
        log.debug("Checking the Login page is opened.");
        $(LOGIN_BUTTON_CSS).waitUntil(Condition.appear, 30);
    }

    public LoginPage signIn(String user, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(user);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
//        $(LOADER_ICON).should(Condition.disappear);
        return this;
    }

    @Test
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

    public LoginPage logOut() {
        $(PREFERENCES_ICON).click();
        $(PREFERENCES_MENU_CONTAINER).shouldBe(Condition.visible);
        $$(PREFENRENCES_MENU_ITEMS).get(11).click();
        return this;
    }
}
