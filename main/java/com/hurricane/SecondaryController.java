package com.hurricane;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Handles navigation from the secondary screen.
 */
public class SecondaryController {

    /**
     * Switches the application to the primary screen.
     *
     * @throws IOException if the screen cannot be loaded
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}