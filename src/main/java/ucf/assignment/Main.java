package ucf.assignment;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Erica Joseph
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/NewStyle.fxml"))); //access the file needed to load FXML; this will be the source of the code
            Scene scene = new Scene(root); // attach scene graph to scene
            stage.setTitle("Main"); // displayed in window's title bar
            //stage.getIcons().add(new Image("/resources/ucf/assignment/Style/ObentoLogoo4.png"));
            stage.setScene(scene); // attach scene to stage
            scene.getStylesheets().add("ucf/assignment/Style/Inventory.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        catch (Exception ignored){

        }
    }


    public static void main(String[] args) {
        launch(args);
    } //man call to launch
}
