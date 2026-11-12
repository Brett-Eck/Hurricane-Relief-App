package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

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
        App.setRoot("Home");
    }

    @FXML 
    void login(ActionEvent event) throws IOException {
        String userName = txt_username.getText();
        String password = txt_password.getText();
        System.out.println("Username: " + userName + ", Password: " + password);
    }

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("Home");
    }
}