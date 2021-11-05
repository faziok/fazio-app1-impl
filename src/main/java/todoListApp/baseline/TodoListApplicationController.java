package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TodoListApplicationController implements Initializable {
    @FXML
    private DatePicker dueDate;

    @FXML
    private TextField itemDescription;

    @FXML
    private TableView<TodoListItem> itemsTableView;

    @FXML
    public TableColumn<TodoListItem, String> descriptionCol;

    @FXML
    public TableColumn<TodoListItem, String> dueDateCol;

    @FXML
    public TableColumn<TodoListItem, String> statusCol;

    @FXML
    private Button addItem;

    @FXML
    private Button deleteItem;

    @FXML
    private Button clearList;

    @FXML
    private Button updateItem;

    @FXML
    private Button clearButton;

    @FXML
    private Button save;

    @FXML
    private Button load;

    @FXML
    private ChoiceBox<String> filter;
    private final String[] filterItems = {"All", "Completed", "Incomplete"};
    private final ObservableList<String> filterList = FXCollections.observableArrayList(filterItems);

    @FXML
    private CheckBox statusBox;


    //--------------------------------------


    //List for file extension
    List<String> fileExt;

    //Observable list object
    TodoList list = new TodoList();

    //Initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up tableView columns
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        //set up filter choiceBox
        filter.setItems(filterList);
        filter.setValue("All");

        //Setup min and max return string size for textField
        //itemDescription.setText(itemDescription.getText().substring(0, 256));

        //ensure input fields are at default
        clearFields();

        //setup file extensions
        fileExt = new ArrayList<>();
        fileExt.add("*.txt");
    }

    @FXML
    private void clear(ActionEvent e){
        clearFields();
    }

    @FXML
    private void addItem(ActionEvent e){
        //get input from fields
        String description = itemDescription.getText();
        LocalDate date = dueDate.getValue();
        boolean status = statusBox.isSelected();

        //create TodoListItem object and add it to list
        TodoListItem item = new TodoListItem(description, date, status);
        list.addItems(item);

        //send list data to tableview
        itemsTableView.setItems(list.getTodoList());

        System.out.println(list.getTodoList()); //delete test print

        //clear item input fields
        clearFields();
    }

    @FXML
    private void clearList(ActionEvent e){
        list.clearList();

        System.out.println(list.getTodoList()); //delete test print
    }

    @FXML
    private void deleteItem(ActionEvent e){
        TodoListItem tableIndex = itemsTableView.getSelectionModel().getSelectedItem();

        list.deleteItem(tableIndex);

        System.out.println(list.getTodoList()); //delete test print
    }

    @FXML
    private void editItem(ActionEvent e){

    }

    @FXML
    private void filterItems(ActionEvent e){

        list.filterList();

        System.out.println(list.getTodoList());
    }

    @FXML
    private void saveList(ActionEvent e){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files", fileExt));
        File file = fc.showSaveDialog(null);
    }

    @FXML
    private void loadList(ActionEvent e){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files", fileExt));
        File file = fc.showOpenDialog(null);
    }

    //method to clear input fields when needed
    private void clearFields(){
        //clear item input fields
        itemDescription.clear();
        dueDate.setValue(LocalDate.now());
        statusBox.setSelected(false);
    }
}
