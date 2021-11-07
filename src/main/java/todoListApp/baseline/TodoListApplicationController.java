package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TodoListApplicationController implements Initializable {
    @FXML
    private DatePicker dueDate;

    @FXML
    private TextArea itemDescription;

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
    private Button editItem;

    @FXML
    private Button clearButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button load;

    @FXML
    private ComboBox<String> filter;
    static final String SHOW_ALL = "All";
    static final String SHOW_COMPLETED = "Completed";
    static final String SHOW_INCOMPLETE = "Incomplete";
    private final String[] filterItems = {SHOW_ALL, SHOW_COMPLETED, SHOW_INCOMPLETE};
    private final ObservableList<String> filterListChoices = FXCollections.observableArrayList(filterItems);

    @FXML
    private CheckBox statusBox;


    //--------------------------------------

    //Observable list object
    TodoList list = new TodoList();
    Save save = new Save();

    //create file chooser
    FileChooser fc = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");

    //create variable for selected index of the list
    int listIndex;


    //Initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Max chars for textArea
        final int MAX_CHARS = 256;

        //set text formatter for textArea at max chars
        itemDescription.setTextFormatter(new TextFormatter<>(change ->
                change.getControlNewText().length() <= MAX_CHARS ? change : null));

        //set up tableView columns
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        //set up filter choiceBox
        filter.setItems(filterListChoices);
        filter.setValue("Show All");

        //ensure input fields are at default
        clearFields();
    }

    @FXML
    private void clear(ActionEvent e) {
        clearFields();
    }

    @FXML
    private void addItem(ActionEvent e) {
        //get input from fields
        String description = itemDescription.getText();
        LocalDate date = dueDate.getValue();
        boolean status = statusBox.isSelected();

        if (itemDescription.getText().length() == 0) {
            //Do nothing or Throw error message

            //clear item input fields
            clearFields();
        } else {
            list.addItems(description, date, status);
        }

        //send list data to tableview
        itemsTableView.setItems(list.getFilteredTodoList());

        //clear item input fields
        clearFields();
    }

    @FXML
    private void clearList(ActionEvent e) {
        list.clearList();
    }

    @FXML
    private void deleteItem(ActionEvent e) {
        TodoListItem tableIndex = itemsTableView.getSelectionModel().getSelectedItem();

        list.deleteItem(tableIndex);
    }

    @FXML
    private void update(ActionEvent e) {
        //get input from fields
        String description = itemDescription.getText();
        LocalDate date = dueDate.getValue();
        boolean status = statusBox.isSelected();

        if (itemDescription.getText().length() == 0) {
            //Do nothing
            //clear item input fields
            clearFields();
        } else {
            list.editItem(description, date, status, listIndex);
        }

        //send list data to tableview
        itemsTableView.setItems(list.getFilteredTodoList());

        //release table index
        //updateTableIndex = null;

        //clear item input fields
        clearFields();
    }

    @FXML
    private void editItem(ActionEvent e) {
        //get selectedrow from tablview and get listindex from that
        TodoListItem updateTableIndex = itemsTableView.getSelectionModel().getSelectedItem();
        listIndex = list.getItemList().indexOf(updateTableIndex);

        //pull selected item info to fields
        if (updateTableIndex != null){
            //Populate description textArea
            itemDescription.setText(updateTableIndex.getDescription());

            //Populate dueDate
            LocalDate date;
            if (updateTableIndex.getDueDate().equals("")) {
                date = null;
            } else {
                date = LocalDate.parse(updateTableIndex.getDueDate());
            }
            dueDate.setValue(date);

            //Populate status checkBox
            statusBox.setSelected(updateTableIndex.getStatus().equals(SHOW_COMPLETED));
        }
    }

    @FXML
    private void filterItems(ActionEvent e) {
        String val = filter.getValue();

        list.filterList(val);
        itemsTableView.setItems(list.getFilteredTodoList());
    }

    @FXML
    private void saveList(ActionEvent e) {
        fc.getExtensionFilters().add(extFilter);
        File file = fc.showSaveDialog(null);

        if (file != null) {
            save.saveTxtFile(file, list.getItemList());
        }
    }

    @FXML
    private void loadList(ActionEvent e) throws IOException {
        fc.getExtensionFilters().add(extFilter);
        File file = fc.showOpenDialog(null);

        String line;

        if (file != null) {
            //clear current list
            list.clearList();

            //create scanner
            BufferedReader br = new BufferedReader(new FileReader(file));

            try (br) {
                while ((line = br.readLine()) != null) {
                    //read in line of file and split
                    String[] newDataArr = line.split(",");

                    //instance variables
                    String description = newDataArr[0];

                    LocalDate date;
                    if (newDataArr[1].equals("")) {
                        date = null;
                    } else {
                        date = LocalDate.parse(newDataArr[1]);
                    }

                    boolean status;
                    status = newDataArr[2].equals(SHOW_COMPLETED);

                    //add item to list
                    list.addItems(description, date, status);
                }
            }

            //update tableview
            itemsTableView.setItems(list.getFilteredTodoList());
            filter.setValue(SHOW_ALL);
        }
    }

        //method to clear input fields when needed
        private void clearFields () {
            //clear item input fields
            itemDescription.clear();
            dueDate.setValue(null);
            statusBox.setSelected(false);
        }
}
