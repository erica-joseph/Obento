package ucf.assignment;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import java.awt.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class IntructionsController implements Initializable {
    public Button home;
    public TableView<MainPageModel> tableView;
    public TableColumn<MainPageModel, String> colName;
    public TableColumn<MainPageModel, String>  colSerial;
    public TableColumn<MainPageModel, Double>  colPrice;
    public Button exitStage;
    public Button Mini;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName")); //initializing taksks
        colSerial.setCellValueFactory(new PropertyValueFactory<>("itemSerial")); //initializing taksks
        colPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice")); //initializing taksks

        tableView.setItems(observableList);
    }

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
    ObservableList<MainPageModel> observableList = FXCollections.observableArrayList(
            new MainPageModel("Example", "EXAMPLE000", 0.00)
    );
    public void exitProgram(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void minimize(ActionEvent event) {
        Stage obj = (Stage) Mini.getScene().getWindow();
        obj.setIconified(true);
    }
}

