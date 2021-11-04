package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
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
    public TableColumn<TodoListItem, LocalDate> dueDateCol;

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
    private Button save;

    @FXML
    private Button load;

    @FXML
    private ChoiceBox<String> filter;
    private final String[] filterItems = {"All", "Completed", "Incomplete"};
    private final ObservableList<String> filterList = FXCollections.observableArrayList(filterItems);

    @FXML
    private CheckBox statusBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filter.setItems(filterList);
        filter.setValue("All");
        dueDate.setValue(LocalDate.now());
        fileExt = new ArrayList<>();
        fileExt.add("*.txt");
    }

    List<String> fileExt;
    List<TodoListItem> todoList = new ArrayList<>(100);
    ObservableList<TodoListItem> list = FXCollections.observableArrayList();

    @FXML
    private void addItem(Event e){
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        list.add(new TodoListItem(itemDescription.getText(), dueDate.getValue(), statusBox.isSelected()));
        todoList.add(new TodoListItem(itemDescription.getText(), dueDate.getValue(), statusBox.isSelected()));
        itemsTableView.setItems(list);

        System.out.println(todoList.toString());

        //clear item input fields
        itemDescription.clear();
        dueDate.setValue(LocalDate.now());
        statusBox.setSelected(false);
    }

    @FXML
    private void clearList(Event e){
        list.clear();
    }

    @FXML
    private void deleteItem(Event e){
        itemsTableView.getItems().removeAll(itemsTableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void saveList(Event e){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files", fileExt));
        File file = fc.showSaveDialog(null);
    }

    @FXML
    private void loadList(Event e){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files", fileExt));
        File file = fc.showOpenDialog(null);
    }

    @FXML
    private void editItem(Event e){

    }



    private void refresh(){
        dueDate.setValue(LocalDate.now());
        itemDescription.setText(null);
        statusBox.setSelected(false);
    }
}
