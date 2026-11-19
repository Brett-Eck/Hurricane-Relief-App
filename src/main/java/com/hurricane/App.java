package com.hurricane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import com.controllers.MapController;
import com.location.Address;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Starts the map screen and requests the demo driving route.
     *
     * @param stage the main application window
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = createLoader("map_view");
        Parent root = loader.load();
        MapController controller = loader.getController();
        scene = new Scene(root, 900, 650);
        stage.setTitle("Hurricane Relief");
        stage.setScene(scene);
        stage.show();

        Address userAddress = new Address(
                "1 Vendue Range",
                "Charleston",
                "SC",
                "29401"
        );

        Address[] addresses = {
                new Address(
                        "1 Vendue Range",
                        "Charleston",
                        "SC",
                        "29401"
                ),

                new Address(
                        "2950 Carner Avenue",
                        "North Charleston",
                        "SC",
                        "29405"
                ),

                new Address(
                        "3841 Leeds Avenue",
                        "North Charleston",
                        "SC",
                        "29405"
                ),

                new Address(
                        "3625 Ashley Phosphate Road",
                        "North Charleston",
                        "SC",
                        "29418"
                )
        };

        //controller.showAddressOnMap(userAddress);
        //controller.showAddressesOnMap(addresses);

        controller.showRouteOnMap(userAddress, addresses[1]);
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
        return createLoader(fxml).load();
    }

    private static FXMLLoader createLoader(String fxml) throws IOException {
        URL resource = App.class.getResource("/com/hurricane/" + fxml + ".fxml");
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
