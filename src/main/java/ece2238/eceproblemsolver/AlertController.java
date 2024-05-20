package ece2238.eceproblemsolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlertController {

    @FXML
    Label errorTxt;

    public void setAlertText(String text) {
        // set text from another class
        errorTxt.setText(text);
    }
}
