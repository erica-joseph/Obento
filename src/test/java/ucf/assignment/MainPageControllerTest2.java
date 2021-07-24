package ucf.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainPageControllerTest2 {
    /*
    Each inventory item shall have a unique serial number in the format of XXXXXXXXXX where X can be either a letter or digit
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
    void addItemsMeetStandard() {
        String inputName = "Uncharted<>";
        String inputSerial = "12345ABCDE12";
        double price = 5.5;

        ObservableList<MainPageModel> observableList3 = FXCollections.observableArrayList();

        if (inputName.length() >= 2 && inputSerial.length() == 10 && inputSerial.matches("[a-zA-Z0-9]*")) {
                observableList3.add(new MainPageModel(inputName, inputSerial, price));
        }
        assertNotEquals(1, observableList3.size());
    }

    @Test
    void errorThrownifConditionNotMet(){
        String inputName = "Uncharted<>";
        String inputSerial = "12345ABCDE12";
        double price = 5.5;

        ObservableList<MainPageModel> observableList3 = FXCollections.observableArrayList();

        String errorthrown = null;
        if (inputName.length() >= 2 && inputSerial.length() == 10 && inputSerial.matches("[a-zA-Z0-9]*")) {
            observableList3.add(new MainPageModel(inputName, inputSerial, price));
            errorthrown= "No error has occured";
        }
        else{
            errorthrown = "An error has occured";
        }
        assertEquals("An error has occured", errorthrown);
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
    void make_sure_one_hundred_items_table() throws FileNotFoundException {

        String serialCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String nameCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Double priceRandom = Math.random()*(50-1)+1;

        ObservableList<MainPageModel> observableList1 = FXCollections.observableArrayList();

        for(int i = 0; i <=99; i++){

            StringBuilder serial = new StringBuilder();
            Random rnd = new Random();
            while (serial.length() < 10) { // length of the random string.
                int index = (int) (rnd.nextFloat() * serialCharacters.length());
                serial.append(serialCharacters.charAt(index));
            }
            String serialStr = serial.toString();

            StringBuilder name = new StringBuilder();
            Random rnd2 = new Random();
            while (name.length() < 10) { // length of the random string.
                int index = (int) (rnd2.nextFloat() * nameCharacters.length());
                name.append(nameCharacters.charAt(index));
            }
            String nameStr = name.toString();

            observableList1.add(new MainPageModel(nameStr, serialStr,priceRandom));

        }

        assertEquals(100, observableList1.size());

    }
}