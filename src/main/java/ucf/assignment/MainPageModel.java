package ucf.assignment;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Erica Joseph
 */
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainPageModel {

    private SimpleStringProperty itemName; //making it so tableview can accept while defining
    private SimpleStringProperty itemSerial;//making it so tableview can accept while defining
    private SimpleDoubleProperty itemPrice;//making it so tableview can accept while defining

    public MainPageModel(String itemName, String itemSerial, Double itemPrice) {
        this.itemName = new SimpleStringProperty(itemName); //stating task name as retrievable
        this.itemSerial = new SimpleStringProperty(itemSerial);
        this.itemPrice = new SimpleDoubleProperty(itemPrice);

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof MainPageModel)) {
            return false;
        }
        MainPageModel model = (MainPageModel) o;
        return model.itemName.isEqualTo(itemName).get() &&
                model.itemSerial.isEqualTo(itemSerial).get() &&
                model.itemPrice.isEqualTo(itemPrice).get();
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public String getItemSerial() {
        return itemSerial.get();
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = new SimpleStringProperty(itemSerial);
    }

    public Double getItemPrice() {
        return itemPrice.get();
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = new SimpleDoubleProperty(itemPrice);
    }
}