package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Emission_Final_Project extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //Instantiate a Vbox();
        VBox root = new VBox();
        //Instantiate a svidata object
        EmissionPane emissionPane = new EmissionPane();

        //Instantiate a sviPane pane
        //root.getChildren().add(new sviPane(svi));
        scene = new Scene(root, 1000, 480);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}