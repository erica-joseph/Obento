package ucf.assignment;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Erica Joseph
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class HTMLModel {
    public String before = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n" +
            "<link href=\"https://fonts.googleapis.com/css2?family=Reem+Kufi&display=swap\" rel=\"stylesheet\">\n" +
            "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n" +
            "<link href=\"https://fonts.googleapis.com/css2?family=Homemade+Apple&display=swap\" rel=\"stylesheet\">\n" +
            "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n" +
            "<link href=\"https://fonts.googleapis.com/css2?family=Amatic+SC&family=Homemade+Apple&display=swap\" rel=\"stylesheet\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "<style>\n" +
            "body{\n" +
            "    font-family: 'Reem Kufi', sans-serif;\n" +
            "    background-repeat: no-repeat;\n" +
            "    text-transform: uppercase;\n" +
            "}\n" +
            "\n" +
            "table {\n" +
            "font-weight: bold;\n" +
            "border-collapse: collapse;\n" +
            "width: 100%;\n" +
            "text-align: center;\n" +
            "border: 2px solid #000;\n" +
            "background-color: transparent;\n" +
            "}\n" +
            "\n" +
            "table td, #inventory th {\n" +
            "  border: 1px solid #000;\n" +
            "  padding: 15px;\n" +
            " \n" +
            "}\n" +
            "\n" +
            "table tr:nth-child(even){background-color: transparent;\n" +
            "      font-weight: normal;\n" +
            "      text-align: center;\n" +
            "      border: 5px;\n" +
            "      padding: 15px;\n" +
            "}\n" +
            "\n" +
            "table tr:hover {background-color: transparent;\n" +
            "      text-align: center;\n" +
            "      border: 5px;\n" +
            "     \n" +
            "}\n" +
            "\n" +
            "table th {\n" +
            "  padding-top: 12px;\n" +
            "  padding-bottom: 12px;\n" +
            "  text-align: center;\n" +
            "  background-color: transparent;\n" +
            "  text-align: center;\n" +
            "  border: 5px;\n" +
            "}\n" +
            ".textbox{\n" +
            "  margin: auto;\n" +
            "  width: 60%;\n" +
            "  border: 0px solid #73AD21;\n" +
            "  padding: 10px;\n" +
            "  text-align: center;\n" +
            "}\n" +
            "\n" +
            ".heading {\n" +
            "    font-weight: bold;\n" +
            "    font-size: 5vw;\n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "</br>\n" +
            "<div class=\"heading\">\n" +
            "<center>\n" +
            "    Inventory\n" +
            "</center>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"textbox\">\n" +
            "<table>\n" +
            "  <tr>\n" +
            "    <th>Items</th>\n" +
            "    <th>Serial </br> Number</th>\n" +
            "    <th>Price</th>\n" +
            "  </tr>\n" +
            "  \n" +
            ""; //making it so tableview can accept while defining

    public String after ="\n" +
            "\n" +
            "</table>\n" +
            "\n" +
            "</div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html> \n";//making it so tableview can accept while defining



    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
