package com.valantic.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private Hyperlink valanticLink;

    @FXML
    private Button showMessageButton;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        // for test purposes
    }

    @FXML
    protected void onWelcomeButtonClick() {
        welcomeText.setText("Welcome to JavaFX!");
    }

    @FXML
    protected void onValanticHyperLinkClick(final ActionEvent event) {
        Main //
                .getInstance() //
                .browse(valanticLink.getText());
    }
}
