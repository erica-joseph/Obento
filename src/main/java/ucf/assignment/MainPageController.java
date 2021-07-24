package ucf.assignment;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Erica Joseph
 */

import java.net.URL;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.util.converter.DoubleStringConverter;
import ucf.assignment.HTMLModel;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import ucf.assignment.Main;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import javafx.beans.binding.StringExpression;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.scene.control.cell.CheckBoxTableCell;

import java.io.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.StringConverter;
import ucf.assignment.Main;

import static javafx.scene.control.cell.CheckBoxTableCell.*;

public class MainPageController implements Initializable {

    //storage


    //display

    //action
    public TextField inputName; //textfied input to store the item added to the to-do list
    public TextField inputSerial; //textfied input to store the item added to the to-do list
    public TextField inputPrice; //textfied input to store the item added to the to-do list

    public TableView<MainPageModel> tableview; //table to display tasks
    public TableColumn<MainPageModel, String> colName;
    public TableColumn<MainPageModel, String> colSerial;
    public TableColumn<MainPageModel, Double> colPrice;
    public Button addToIn;
    public Button removeIn;
    public Button saveIn;
    public Button openIn;
    public TextField searchBar;
    public Text errorThrown;
    public Button help;
    public Menu Exit;
    public MenuBar menu;
    public Button exitStage;
    public Button undo;
    public Button generateSerial;
    public Button Mini;


    FileChooser fileChooser = new FileChooser(); //instance of the file chooser

    @Override
    public void initialize(URL location, ResourceBundle resources) { //loading the initialized statements
        String serialCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        colName.setCellValueFactory(new PropertyValueFactory<>("itemName")); //initializing taksks
        colName.setCellFactory(TextFieldTableCell.forTableColumn()); //setting tasks to accept the text
        colSerial.setCellValueFactory(new PropertyValueFactory<>("itemSerial")); //initializing taksks
        StringConverter<String> converter = null;

        colSerial.setCellFactory(TextFieldTableCell.forTableColumn());
        colPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice")); //initializing taksks
        colPrice.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter())); //setting tasks to accept the text

        //tableview.setItems(observableList); //printle items of the table
        tableview.setEditable(true); //determining them editable
        tableview.setPlaceholder(new Label(" "));//displays no contents in table before items are added to the list
        addToIn.setTooltip(new Tooltip("Add to list"));
        removeIn.setTooltip(new Tooltip("Remove from list"));
        saveIn.setTooltip(new Tooltip("Save list"));
        openIn.setTooltip(new Tooltip("Open list"));
        inputName.setTooltip(new Tooltip("Type in name"));
        inputPrice.setTooltip(new Tooltip("Type in price"));
        inputSerial.setTooltip(new Tooltip("Type in serial number \n Ten digits \n Numbers and letters"));
        tableview.setTooltip(new Tooltip("Double-click to edit"));
        searchBar.setTooltip(new Tooltip("Search list"));
        undo.setVisible(false);

        //tableview.setItems(observableList);

        FilteredList<MainPageModel> filteredData = new FilteredList<>(observableList, b -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(mainPageModel -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (mainPageModel.getItemName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (mainPageModel.getItemSerial().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else return String.valueOf(mainPageModel.getItemPrice()).contains(lowerCaseFilter);
            });
        });

        SortedList<MainPageModel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        tableview.setItems(sortedData);


    }


    ObservableList<MainPageModel> observableList = FXCollections.observableArrayList(
            new MainPageModel("Example", "EXAMPLE123", 1.23)
    );

    ObservableList<MainPageModel> observableListDeleted = FXCollections.observableArrayList();


    //Actions performed on the list
    @FXML
    public void addItems(ActionEvent event) { //function to add items to list
        try {
            addItemsDisplay();
        } catch (Exception ignored) {
        }
    }

    public void addItemsDisplay() {

        try {
            if (inputName.getText().length() >= 2 && inputSerial.getText().length() == 10 && inputSerial.getText().matches("[a-zA-Z0-9]*")) {
                MainPageModel model = new MainPageModel(inputName.getText().toUpperCase(), inputSerial.getText().toUpperCase(), Double.parseDouble(inputPrice.getText()));//run the inputted text through the model to designate which values land where
                String checkFor = inputSerial.getText().toUpperCase();

                if (!observableList.contains(model)) {
                    observableList.add(model);
                }else{
                    errorThrown.setText("All serial numbers must be unique");
                }
                refresh();
            } else {
                if (inputName.getText().length() < 2 && inputSerial.getText().length() == 10 && inputSerial.getText().matches("[a-zA-Z0-9]*")) {
                    errorThrown.setText("Name length must be ateleast 2 characters.");
                } else if (inputName.getText().length() >= 2 && inputSerial.getText().length() != 10) {
                    errorThrown.setText("Serial number must be 10 characters.");
                } else if (inputName.getText().length() < 2 && inputSerial.getText().length() != 10) {
                    errorThrown.setText("Name length must be ateleast 2 characters.\nSerial number must be 10 characters.");
                } else {
                    errorThrown.setText("Make sure your serial number does not contain special characters.");
                }

            }

        } catch (Exception e) {
        e.printStackTrace();

        }

    }

    @FXML
    private void removeItem(ActionEvent event) {//remove item from the to-do list
        try {
            removeItemDisplay();
        } catch (Exception ignored) {}
    }

    public void removeItemDisplay() {
        int selectedItem = tableview.getSelectionModel().getSelectedIndex(); //select an item
        observableListDeleted.add(observableList.get(selectedItem));
        observableList.remove(selectedItem); //remove the selected item from the list
        undo.setVisible(true);
    }

    public void onEditChange(TableColumn.CellEditEvent<MainPageModel, String> modelStringCellEditEvent) {//make list columns editable
        MainPageModel model = tableview.getSelectionModel().getSelectedItem();//grabbing an item
        model.setItemName(modelStringCellEditEvent.getNewValue().substring(0, 9)); //replacing said item
    }

    //refresh to reset the items in the list
    private void refresh() {
        inputName.setText(null); //reeset textfield to be empty before the item is introduced
        inputSerial.setText(null); //reeset textfield to be empty before the item is introduced
        inputPrice.setText(null); //reeset textfield to be empty before the item is introduced
    }

    //Storage of contents
    @FXML
    public void saveList(ActionEvent event) { //saving list
        saveListDisplay();
    }

    public void saveListDisplay() {
        Window stage = saveIn.getScene().getWindow(); //displaying and opening
        fileChooser.setTitle("Save"); //title
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"),
                new FileChooser.ExtensionFilter( "html file", "*.html")); //filtering to only have relevant files
        BufferedWriter bw = null; //buffered writer to make easier
        try {

                File file = fileChooser.showSaveDialog((stage)); //launcing dialogue for saving
                fileChooser.setInitialDirectory((file.getParentFile()));
                FileWriter fw = new FileWriter(file);//writing file
            if (file.getName().contains(".txt")) {
                bw = new BufferedWriter(fw);

                for (MainPageModel string : observableList) {
                    fw.write(string.getItemName() + "   " + string.getItemSerial() + "   " + string.getItemPrice() + "\n"); //splitting the columns to store separately
                }
                bw.close(); //closing bufered writer
                fw.close();
            }
            if (file.getName().contains(".html")) {
                bw = new BufferedWriter(fw);
                HTMLModel html = new HTMLModel();
                bw.write(html.before);
                for (MainPageModel string : observableList) {
                    bw.write("<tr>\n<td>"+string.getItemName() + "</td><!----><td>" + string.getItemSerial() + "</td><!----><td>" + string.getItemPrice()+"</td>\n</tr>"); //splitting the columns to store separately
                }
                bw.write(html.after);
                bw.close(); //closing bufered writer
                fw.close();
            }
        } catch (Exception ignored) {

        }
    }


    @FXML
    public void handleOpen() { //using the file chooser to determine the path to open a file if needed
        handleOpenDisplay();
    }

    public void handleOpenDisplay() {
        Window stage = openIn.getScene().getWindow(); //displaying and opening
        fileChooser.setTitle("Open"); //title
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("text file", "*.txt"),
        new FileChooser.ExtensionFilter( "html file", "*.html")); //filtering to only have relevant files

            try {

                File file = fileChooser.showOpenDialog((stage)); //launcing dialogue for saving
                fileChooser.setInitialDirectory((file.getParentFile()));
                Scanner buff = new Scanner(new File(String.valueOf(file))); //writing path
                ArrayList<String> listOfLines = new ArrayList<String>(); //storing the opened file into an arraylist
                // in the case of a txt
                observableList.clear();
                if (file.getName().contains(".txt")) {
                    while (buff.hasNextLine()) //looping to asses each line
                        listOfLines.add(buff.nextLine()); //adding said lines to new list

                    for (String lines : listOfLines) { //for each with lines and lineOfLines
                        ArrayList<String> finishTest = new ArrayList<>(); //new list
                        String[] words = lines.split("  "); //creating a partition for the file to separate at the commas
                        //pulling each
                        finishTest.addAll(Arrays.asList(words));
                        String retrieveName = "";
                        String retrieveSerial = "";
                        String retrievePrice = "";


                        for (int i = 0; i <= finishTest.size() - 1; i++) {
                            if (i == 0) {
                                retrieveName = finishTest.get(i) + "\n"; //splitting at commas and prinign as lines
                            } else if (i == 1) {
                                retrieveSerial = finishTest.get(i) + "\n"; //splitting at commas and prinign as lines
                            } else if (i == 2) {
                                retrievePrice = finishTest.get(i) + "\n"; //splitting at commas and prinign as lines
                            }

                        }
                        MainPageModel modelTest = new MainPageModel(retrieveName, retrieveSerial, Double.parseDouble(retrievePrice));
                        observableList.add(modelTest);
                    }
                }
                if (file.getName().contains(".html")) {
                    BufferedReader bufReader = new BufferedReader(new FileReader(String.valueOf(file)));
                    String line = bufReader.readLine();

                    while (line != null) {
                    if (line.startsWith("<td>") && line.endsWith("</td>")) {
                        listOfLines.add(line);
                    }
                        line = bufReader.readLine();
                }
                bufReader.close();
                    for (String lines : listOfLines) { //for each with lines and lineOfLines
                        String[] words = lines.split("<!---->"); //creating a partition for the file to separate at the commas

                        ArrayList<String> finishTest = new ArrayList<>(Arrays.asList(words)); //convert the split up list into an array

                        String retrieveName = ""; //initiate each variable
                        String retrieveSerial = "";
                        String retrievePrice = "";

                        for (int i = 0; i <= finishTest.size()-1; i++) { //for each
                            if (i == 0) {
                                retrieveName = finishTest.get(i) + "\n"; //splitting at commas and prinign as lines
                            }
                            else if (i == 1) {
                                retrieveSerial = finishTest.get(i) + "\n"; //splitting at commas and prinign as lines
                            }
                            else if (i == 2) {
                               retrievePrice = finishTest.get(i).replaceAll("<td>", "").replaceAll("</td>", "").toUpperCase() + "\n"; //splitting at commas and prinign as lines
                            }

                        }
                        MainPageModel modelTest2 = new MainPageModel(retrieveName.replaceAll("<td>", "").replaceAll("</td>", "").toUpperCase(), retrieveSerial.replaceAll("<td>", "").replaceAll("</td>", "").toUpperCase(), Double.parseDouble(retrievePrice));
                        observableList.add(modelTest2);

                    }
                }
            }
            catch (Exception ignored) {
            }
        }


    //Changing Scenes
    public void taketoHelp(ActionEvent event) throws Exception {
        Stage stage;//set stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/HelpPage.fxml")));//load the main view of fxml
        Scene scene = new Scene(root); // attach scene graph to scene
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("OBENTO: Guide"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        scene.getStylesheets().add("ucf/assignment/Style/Inventory.css");//load the custom cascading sheed
        stage.show(); // display the stage

    }

    public void exitProgram(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void undoButton(ActionEvent actionEvent) {
        if(observableListDeleted.size()!=0) {
            observableList.add(observableListDeleted.get(observableListDeleted.size() - 1));
            observableListDeleted.remove(observableListDeleted.get(observableListDeleted.size() - 1));
        }

    }

    public void generateNumber(ActionEvent actionEvent) {
        String serialCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder serial = new StringBuilder();
        Random rnd = new Random();
        while (serial.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * serialCharacters.length());
            serial.append(serialCharacters.charAt(index));
        }
        String serialStr = serial.toString();
        inputSerial.setText(serialStr);
    }

    public void minimize(ActionEvent event){
        Stage obj = (Stage) Mini.getScene().getWindow();
        obj.setIconified(true);
    }
}