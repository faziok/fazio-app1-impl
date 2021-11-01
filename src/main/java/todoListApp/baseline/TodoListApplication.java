package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

//-------------------

/*
 * The application shall manage a single list of items
 * The list shall have the capacity to store at least 100 unique items
 *
 * An item shall have a description.
 * A description shall be between 1 and 256 characters in length
 * An item shall have a due date
 * A due date shall be optional
 * If present, a due date shall be a valid date within the Gregorian Calendar
 * If present, a due date shall be displayed to users in the format: YYYY-MM-DD
 *
 * A user shall be able to add a new item to the list
 * A user shall be able to remove an item from the list
 * A user shall be able to clear the list of all items
 * A user shall be able to edit the description of an item within the list
 * A user shall be able to edit the due date of an item within the list
 * A user shall be able to mark an item in the list as either complete or incomplete
 * A user shall be able to display all the existing items in the list
 * A user shall be able to display only the incomplete items in the list
 * A user shall be able to display only the completed items in the list
 *
 * A user shall be able to save the list (and all its items) to local storage while the application is being used
 * A user shall specify the file location and name for the saved data
 * The data shall be saved to a single text file
 * A user shall be able to load a previously saved list while the application is being used
 * The loaded list shall replace the current list in the GUI
 *
 * The developer shall provide a user guide with directions on how to use the application.
 * The user guide shall describe how to execute each behavioral requirement provided by the application
 *      (e.g. add an item, remove an item, edit an item, etc.)
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class TodoListApplication extends javafx.application.Application {
    @Override
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TodoListApplication.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
