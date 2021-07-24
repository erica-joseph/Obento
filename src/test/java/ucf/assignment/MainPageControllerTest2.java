package ucf.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainPageControllerTest2 {
    /*
    The user shall interact with the application through a Graphical User Interface
    The user shall be able to store at least 100 inventory items
    Each inventory item shall have a value representing its monetary value in US dollars
    Each inventory item shall have a unique serial number in the format of XXXXXXXXXX where X can be either a letter or digit
    Each inventory item shall have a name between 2 and 256 characters in length (inclusive)
    The user shall be able to add a new inventory item
    The application shall display an error message if the user enters an existing serial number for the new item
    The user shall be able to remove an existing inventory item
    The user shall be able to edit the value of an existing inventory item
    The user shall be able to edit the serial number of an existing inventory item
    The application shall prevent the user from duplicating the serial number
    The user shall be able to edit the name of an existing inventory item
    The user shall be able to sort the inventory items by value
    The user shall be able to sort inventory items by serial number
    The user shall be able to sort inventory items by name
    The user shall be able to search for an inventory item by serial number
    The user shall be able to search for an inventory item by name
    The user shall be able to save their inventory items to a file
    The user shall be able to select the file format from among the following set of options: TSV (tab-separated value), HTML, JSON
    TSV files shall shall list one inventory item per line, separate each field within an inventory item using a tab character, and end with the extension .txt
    HTML files shall contain valid HTML and end with the extension .html
    The list of inventory items must appear as a table when the HTML file is rendered.
    JSON files shall contain valid JSON and end with the extension .json
    The user shall provide the file name and file location of the file to save
    The user shall be able to load inventory items from a file that was previously created by the application.
    The user shall provide the file name and file location of the file to load
     */

    ObservableList<MainPageModel> observableList = FXCollections.observableArrayList();;


    @Test
    void addItems_to_obv_list_check_if_true() {
        String name = "Splatoon";
        String serial = "012345ABCDE";
        Double price = 25.99;
        MainPageModel model = new MainPageModel(name,serial,price);
        assertTrue(observableList.add(model));
    }

    @Test
    void onEditChange_change_if_need() {

    }

    @Test
    void Remove_item_test_true(){
        String name = "Splatoon";
        String serial = "012345ABCDE";
        Double price = 25.99;
        MainPageModel model = new MainPageModel(name,serial,price);
        observableList.add(model);
        observableList.remove(model);
        assertFalse(observableList.contains(model));
    }


    @Test
    void saveListDisplay() {
    }


    @Test
    void handleOpenDisplay() {/*
        Window stage = openIn.getScene().getWindow(); //displaying and opening
        fileChooser.setTitle("Open"); //title
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("text file", "*.txt"),
        new FileChooser.ExtensionFilter( "html file", "*.html")); //filtering to only have relevant files
        File file = fileChooser.showOpenDialog((stage)); //launcing dialogue for saving
        fileChooser.setInitialDirectory((file.getParentFile()));
        Scanner buff = new Scanner(new File(String.valueOf(file))); //writing path
        ArrayList<String> listOfLines = new ArrayList<String>();
        */
    }
}