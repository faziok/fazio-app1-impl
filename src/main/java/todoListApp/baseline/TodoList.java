package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class TodoList {
    //initialize observable list
    private final ObservableList<TodoListItem> itemList = FXCollections.observableArrayList();

    public void addItems(TodoListItem item){
        //Only add to the list if there are < 100 items currently in the list.
        if (itemList.size() < 100){
            itemList.add(item);
        }
    }

    public ObservableList<TodoListItem> getTodoList(){
        //get list
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

    public void filterList(){
        //filter list based off choiceBox selection
    }
}
