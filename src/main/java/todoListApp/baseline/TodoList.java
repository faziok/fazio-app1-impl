package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TodoList {
    //list with 100 item max
    List<Map<Integer, String>> todoList = new ArrayList<>();

    public Map<Integer, String> addItem (){
        //add map for new item.

        //when item add button is pressed
            //if getDescription is null or greater than 256 characters
                //send error message that a description must be entered
                //exit method

            //if getDate is NOT selected or date has already passed
                //set dueDate to "No due date selected"
            //else
                //set dueDate to selected date in YYYY-MM-DD format

            //add item to selected to-do list using maps
            //key 1 will contain the value of the description
            //key 2 will contain the value of the dueDate

            //sort by due date

        //return
        return null;
    }

    public void deleteItem (Map<Integer, String> selectedItem){
        //delete selected item.
        //remove item from item listView.
    }

    public void clearList (List<Map<Integer, String>> list){
        //delete list
    }
}
