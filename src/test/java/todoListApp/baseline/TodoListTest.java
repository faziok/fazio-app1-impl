package todoListApp.baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
    TodoList app = new TodoList();

    //initialize observable and filtered list
    private final ObservableList<TodoListItem> itemListTest = FXCollections.observableArrayList(
            new TodoListItem("words to test1", LocalDate.of(2022, 12, 25), true),
            new TodoListItem("words to test2", null, true),
            new TodoListItem("words to test3", LocalDate.now(), false)
    );
    private final FilteredList<TodoListItem> filteredItemsTest = new FilteredList<>(itemListTest, p -> true);


    //set test item input
    String descriptionTest1 = "words to test1";
    LocalDate dateTest1 = LocalDate.of(2022, 12, 25);
    boolean statusTest1 = true;

    String descriptionTest2 = "words to test2";
    LocalDate dateTest2 = null;
    boolean statusTest2 = true;

    String descriptionTest3 = "words to test3";
    LocalDate dateTest3 = LocalDate.now();
    boolean statusTest3 = false;


    @Test
    void addItems() {
        //add items to observable list through add items
        app.addItems(descriptionTest1, dateTest1, statusTest1);
        app.addItems(descriptionTest2, dateTest2, statusTest2);
        app.addItems(descriptionTest3, dateTest3, statusTest3);

        //assert actual and expected lists as string equal
        assertEquals(Arrays.toString(itemListTest.toArray()), Arrays.toString(app.getItemList().toArray()));
    }

    @Test
    void getFilteredTodoList() {
        //add items to observable list through add items
        app.addItems(descriptionTest1, dateTest1, statusTest1);
        app.addItems(descriptionTest2, dateTest2, statusTest2);
        app.addItems(descriptionTest3, dateTest3, statusTest3);

        //assert actual and expected lists as string equal
        assertEquals(Arrays.toString(filteredItemsTest.toArray()), Arrays.toString(app.getFilteredTodoList().toArray()));
    }
}