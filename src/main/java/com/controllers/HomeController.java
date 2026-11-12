package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.hurricane.App;

/**
 * Handles navigation from the primary screen.
 */
public class HomeController {

    /**
     * Switches the application to the secondary screen.
     *
     * @throws IOException if the screen cannot be loaded
     */
    

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}
