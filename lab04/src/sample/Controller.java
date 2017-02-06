package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField usernameField, fullNameField, emailField, phoneField;

    public void btnRegister_OnAction(ActionEvent event) {
        String username = usernameField.getText();
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        System.out.println("Username:\t" + username + "\nFull Name:\t" + fullName + "\nE-Mail:\t\t" + email + "\nPhone #:\t" + phone);
    }
}
