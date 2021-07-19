package ucf.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import java.awt.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class IntructionsController implements Initializable {
    public Button home;

    @Override
    public void initialize(URL location, ResourceBundle resources){}

    public void taketoHome(ActionEvent event) throws Exception {
        Stage stage;//set stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/NewStyle.fxml")));//load the main view of fxml
        Scene scene = new Scene(root); // attach scene graph to scene
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Help"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        scene.getStylesheets().add("ucf/assignment/Style/Inventory.css");//load the custom cascading sheed
        stage.show(); // display the stage
    }
}

