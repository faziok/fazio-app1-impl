package todoListApp.baseline;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoListItemTest {
    @Test
    void testToString() {
        String testString = "words to test1 2022-12-25 Completed";

        String itemArr = new TodoListItem("words to test1", LocalDate.of(2022, 12, 25), true).toString();

        assertEquals(testString, itemArr);
    }
}