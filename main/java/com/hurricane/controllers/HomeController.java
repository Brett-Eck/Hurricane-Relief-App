package com.hurricane;

import java.io.IOException;
import javafx.fxml.FXML;
import com.hurricane.model.App;

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
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
}