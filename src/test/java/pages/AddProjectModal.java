package pages;

import static com.codeborne.selenide.Selenide.*;

public class AddProjectModal {

    String PROJECTS_MENU = ".expansion_panel";
    String ADD_PROJECT_LINK = "//a[@class='action sel_add_project']";

    public AddProjectModal openProjectModal() {
        $$(PROJECTS_MENU).get(0).click();
        sleep(30);
        $(ADD_PROJECT_LINK).click();
        $("edit_project_modal_field_name").click();
        sleep(30);
        $("edit_project_modal_field_name").sendKeys("111");
        sleep(30);
        $(".ist_button.ist_button_red").click();
        return this;
    }
}