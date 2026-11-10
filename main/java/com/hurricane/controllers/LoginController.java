package com.hurricane;

import java.io.IOException;
import javafx.fxml.FXML;
import com.hurricane.model.App;

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
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}