package ucf.assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPageControllerTest2 {

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
    void handleOpenDisplay() {
    }
}