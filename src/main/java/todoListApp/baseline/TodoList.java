package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    TodoListItem todoListItem = new TodoListItem();

    //list with 100 item max
    private List<TodoListItem> item = new ArrayList<>(100);

    /*
    public TodoList(){
        item = new ArrayList<>(100);
        item.add(new TodoListItem());
    }

    public List<TodoListItem> setList(){
        return item;
    }

    public List<TodoListItem> getList(){
        return item;
    }

    public void deleteItem (List<String> selectedItem){
        //delete selected item.
        //remove item from item listView.
    }

    public void clearList (List<Map<Integer, String>> list){
        //delete list
    }
     */
}
