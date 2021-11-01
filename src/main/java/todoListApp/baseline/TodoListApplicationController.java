package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TodoListApplicationController implements Initializable {
    @FXML
    private DatePicker dueDate;

    @FXML
    private TextArea itemDescription;

    @FXML
    private ScrollPane itemsListView;

    @FXML
    private Button addItem;

    @FXML
    private Button deleteItem;

    @FXML
    private Button clearList;

    @FXML
    private Button updateItem;

    @FXML
    private Button save;

    @FXML
    private Button load;

    @FXML
    private ChoiceBox<String> filter;

    @FXML
    private CheckBox completed;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //empty
    }
}
