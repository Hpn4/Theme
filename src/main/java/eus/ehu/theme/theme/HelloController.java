package eus.ehu.theme.theme;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HelloController {

    @FXML
    private ToggleGroup themes;
    private HelloApplication application;

    @FXML
    void onApplyTheme(ActionEvent event) {
        RadioButton button = (RadioButton) event.getSource();
        if(button != null)
            application.setTheme(button.getText());
    }

    @FXML
    void initialize() {

    }

    public void setApplication(HelloApplication application)
    {
        this.application = application;
    }

}
