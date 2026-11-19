package com.hurricane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ScrollPane viewport;

    /**
     * Starts the application with a view sized to the available screen space.
     *
     * @param stage the main application window
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        Parent view = loadFXML("storm-updates");
        viewport = new ScrollPane();
        viewport.setFitToWidth(true);
        viewport.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        viewport.getStyleClass().add("app-page");
        installView(view);

        Rectangle2D available = Screen.getPrimary().getVisualBounds();
        double width = Math.min(view.prefWidth(-1), available.getWidth());
        double height = Math.min(view.prefHeight(width), available.getHeight());
        scene = new Scene(viewport, width, height);
        scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
        stage.setTitle("Hurricane Relief");
        stage.setMinWidth(Math.min(960, width));
        stage.setMinHeight(Math.min(640, height));
        stage.setScene(scene);
        stage.show();
        // Stage dimensions include the title bar; Scene dimensions do not.
        stage.setWidth(Math.min(stage.getWidth(), available.getWidth()));
        stage.setHeight(Math.min(stage.getHeight(), available.getHeight()));
        stage.centerOnScreen();
    }

    /**
     * Changes the current screen using an FXML file.
     *
     * @param fxml the name of the FXML file
     * @throws IOException if the file cannot be loaded
     */
    public static void setRoot(String fxml) throws IOException {
        installView(loadFXML(fxml));
        viewport.setVvalue(0);
    }

    private static void installView(Parent view) {
        if (view instanceof GridPane grid) {
            // Responsive columns can resize without shrinking their text or controls.
            grid.setMinSize(0, 0);
            viewport.setFitToHeight(true);
            viewport.setContent(grid);
        } else {
            viewport.setFitToHeight(false);
            viewport.setContent(new ScaledView(view));
        }
    }

    /**
     * Loads an FXML file for the application.
     *
     * @param fxml the name of the FXML file
     * @return the loaded screen
     * @throws IOException if the file cannot be loaded
     */
    private static Parent loadFXML(String fxml) throws IOException {
        return createLoader(fxml).load();
    }

    private static FXMLLoader createLoader(String fxml) throws IOException {
        URL resource = App.class.getResource("/com/hurricane/FXMLFiles/" + fxml + ".fxml");
        if (resource == null) {
            throw new IOException("FXML resource not found: " + fxml + ".fxml");
        }
        return new FXMLLoader(resource);
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
