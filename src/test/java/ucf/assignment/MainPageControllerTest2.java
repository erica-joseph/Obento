package ucf.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

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

    ObservableList<MainPageModel> observableList = FXCollections.observableArrayList();//initializing observable list


    @Test
    void addItems_to_obv_list_check_if_true() {
        String name = "Splatoon"; //passing through a name
        String serial = "012345ABCDE"; //passing through a serial number
        Double price = 25.99;//passing through a double
        MainPageModel model = new MainPageModel(name,serial,price); //passing through model
        assertTrue(observableList.add(model)); //model is added without incident
    }

    @Test
    void addItemsDoesNotMeetStandard() {
        String inputName = "Uncharted<>";//uncharted has a special character, therefore this shall be rejected
        String inputSerial = "12345ABCDE12"; //too long
        double price = 5.5;//correct

        ObservableList<MainPageModel> observableList3 = FXCollections.observableArrayList();

        if (inputName.length() >= 2 && inputSerial.length() == 10 && inputSerial.matches("[a-zA-Z0-9]*")) { //if statement
                observableList3.add(new MainPageModel(inputName, inputSerial, price)); //observable list updated with items but should reject
        }
        assertNotEquals(1, observableList3.size());//since the item is not added to the observable list, then the test passes
    }

    @Test
    void errorThrownifConditionNotMet(){
        String inputName = "Uncharted<>";
        String inputSerial = "12345ABCDE12";
        double price = 5.5;

        ObservableList<MainPageModel> observableList3 = FXCollections.observableArrayList();

        String errorthrown = null;
        if (inputName.length() >= 2 && inputSerial.length() == 10 && inputSerial.matches("[a-zA-Z0-9]*")) { //given circumstances
            observableList3.add(new MainPageModel(inputName, inputSerial, price)); //input text
            errorthrown= "No error has occured";//No error thrown message
        }
        else{
            errorthrown = "An error has occured"; //error thrown message
        }
        assertEquals("An error has occured", errorthrown);
    }
    @Test
    void onEditChange_change_if_need() {

    }

    @Test
    void Remove_item_test_true(){
        String name = "Splatoon"; //given title
        String serial = "012345ABCDE"; //given
        Double price = 25.99; //given
        MainPageModel model = new MainPageModel(name,serial,price); //item meets all criteria, therefore added
        observableList.add(model); //added to model
        observableList.remove(model); //removed from model
        assertFalse(observableList.contains(model)); //therefore the list does not contain the model
    }


    @Test
    void saveListDisplay() {
    }


    @Test
    void make_sure_one_hundred_items_table() throws FileNotFoundException {

        String serialCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; //pool of serial characters
        String nameCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //pool of name characters
        Double priceRandom = Math.random()*(50-1)+1;//pool of prices

        ObservableList<MainPageModel> observableList1 = FXCollections.observableArrayList(); //observable list

        for(int i = 0; i <=99; i++){

            //Random serials generated
            StringBuilder serial = new StringBuilder();
            Random rnd = new Random();
            while (serial.length() < 10) { // length of the random string.
                int index = (int) (rnd.nextFloat() * serialCharacters.length());
                serial.append(serialCharacters.charAt(index));
            }
            String serialStr = serial.toString();

            //Random names generated
            StringBuilder name = new StringBuilder();
            Random rnd2 = new Random();
            while (name.length() < 10) { // length of the random string.
                int index = (int) (rnd2.nextFloat() * nameCharacters.length());
                name.append(nameCharacters.charAt(index));
            }
            String nameStr = name.toString();

            observableList1.add(new MainPageModel(nameStr, serialStr,priceRandom));

        }

        assertEquals(100, observableList1.size()); //if 100 are added to the list, then a pass

    }

    @Test
    void search_by_name_testing(){
        ObservableList<MainPageModel> observableList5 = FXCollections.observableArrayList();

        observableList5.add(new MainPageModel("Candy", "012345ABCDE", 5.50));//given an input

        ArrayList<MainPageModel> testingOut = new ArrayList<>(observableList5); //testing an array list made from the observable list
        MainPageModel[] experiment; //string array
        experiment = testingOut.toArray(new MainPageModel[0]);
        assertEquals(-1, checkforDuplicates(experiment,"012345ABCDE")); //search for given serial number, and reaction is found

    }

    @Test
    void sort_check_if_list_will_sort(){
        //tableview does this
    }

    public int checkforDuplicates(MainPageModel[] arr, String x){
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = x.compareTo(String.valueOf(arr[m]));
            if (res == 0)
                return m;
            if (res > 0)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}