package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;



import com.model.*;
import com.hurricane.App;

/**
 * Handles navigation from the secondary screen.
 */
public class LoginController {

    /**
     * Switches the application to the primary screen.
     *
     * @throws IOException if the screen cannot be loaded
     */
    @FXML 
    private TextField txt_password;

    @FXML 
    private TextField txt_username;

    @FXML 
    void back(ActionEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML 
    void login(ActionEvent event) throws IOException {
        String userName = txt_username.getText();
        String password = txt_password.getText();
        System.out.println("Username: " + userName + ", Password: " + password);
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void btnLoginClicked(MouseEvent event) throws IOException {
        String userName = txt_username.getText();
        String password = txt_password.getText();
        UserSystem userSystem = UserSystem.getInstance();

        if (userSystem.getUser(userName, password) != null) {
            App.setRoot("home");
        } else {
            // Show an error message or handle invalid credentials
            System.out.println("Invalid username or password");
        }
    }

    @FXML private void back(MouseEvent event) throws IOException {
        App.setRoot("home");
    }
}
