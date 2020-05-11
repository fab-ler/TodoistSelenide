package pages;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AddProjectModal {

    String PROJECTS_MENU = ".expansion_panel";
    String ADD_PROJECT_LINK = ".action.sel_add_project";
    String PROJECT_NAME_INPUT = "#edit_project_modal_field_name";
    String SUBMIT_BUTTON = ".ist_button.ist_button_red";
    String COLOR_SELECT = ".color_dropdown_toggle";


    public AddProjectModal openProjectModal() {
        $$(PROJECTS_MENU).get(0).click();
        $(ADD_PROJECT_LINK).click();
        sleep(30);
        $(PROJECT_NAME_INPUT).sendKeys("Project" + UUID.randomUUID().toString());

//        $(PROJECT_NAME_INPUT).setValue("Project" + UUID.randomUUID().toString()).pressEnter();
//        sleep(30);
//        $(SUBMIT_BUTTON).click();
//        refresh();
        return this;
    }
}