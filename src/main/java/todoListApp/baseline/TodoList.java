package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;

public class TodoList {
    //initialize observable list
    private final ObservableList<TodoListItem> itemList = FXCollections.observableArrayList();
    private final FilteredList<TodoListItem> filteredItems = new FilteredList<>(itemList, p -> true);

    public void addItems(String description, LocalDate date, boolean status){
        //create TodoListItem object and add it to list
        TodoListItem item = new TodoListItem(description, date, status);

        //Add item to list
        itemList.add(item);
    }

    public ObservableList<TodoListItem> getFilteredTodoList(){
        //get filtered list
        return filteredItems;
    }

    public ObservableList<TodoListItem> getItemList(){
        //get filtered list
        return itemList;
    }

    public void clearList(){
        //clear list
        itemList.clear();
    }

    public void deleteItem(TodoListItem item){
        //remove item from list
        itemList.remove(item);
    }

    public void filterList(String val){
        //set predicate for filter
            //if val = 'All' return the full list
            //else if val = 'Completed' return only completed items
            //else return 'Incomplete' items
        filteredItems.setPredicate(todoListItem -> {
            if (val.equals("All")){
                return true;
            } else if (todoListItem.getStatus().contains(val)){
                return true;
            } else return todoListItem.getStatus().contains(val);
        });
    }

    public void updateItem(String description, LocalDate date, boolean status, int listIndex){
        //create TodoListItem object and add it to list
        TodoListItem item = new TodoListItem(description, date, status);

        //set updated information to selected index in list.
        getItemList().set(listIndex, item);
    }
}
