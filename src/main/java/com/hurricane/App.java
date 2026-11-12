package com.hurricane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Starts the application and displays the primary screen.
     *
     * @param stage the main application window
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("home"), 640, 480);
        stage.setTitle("Hurricane Relief");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current screen using an FXML file.
     *
     * @param fxml the name of the FXML file
     * @throws IOException if the file cannot be loaded
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads an FXML file for the application.
     *
     * @param fxml the name of the FXML file
     * @return the loaded screen
     * @throws IOException if the file cannot be loaded
     */
    private static Parent loadFXML(String fxml) throws IOException {
        URL resource = App.class.getResource("/com/hurricane/" + fxml + ".fxml");
        if (resource == null) {
            throw new IOException("FXML resource not found: " + fxml + ".fxml");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        return fxmlLoader.load();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
