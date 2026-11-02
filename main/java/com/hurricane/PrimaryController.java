package com.hurricane;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Handles navigation from the primary screen.
 */
public class PrimaryController {

    /**
     * Switches the application to the secondary screen.
     *
     * @throws IOException if the screen cannot be loaded
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
