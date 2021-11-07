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

        //Only add to the list if there are < 100 items currently in the list.
        if (itemList.size() < 100){
            itemList.add(item);
        }
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
        filteredItems.setPredicate(todoListItem -> {
            if (val.equals("All")){
                return true;
            } else if (todoListItem.getStatus().contains(val)){
                return true;
            } else return todoListItem.getStatus().contains(val);
        });
    }

    public void editItem(String description, LocalDate date, boolean status, int listIndex){
        //create TodoListItem object and add it to list
        TodoListItem item = new TodoListItem(description, date, status);

        //Only add to the list if there are < 100 items currently in the list.
        if (itemList.size() < 100){
            getItemList().set(listIndex, item);
        }
    }
}
