package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterItems {
    boolean showAll = true;
    boolean showCompleted = false;
    boolean showIncomplete = false;

    FilterItems (boolean showAll, boolean showCompleted, boolean showIncomplete){
        this.showAll = showAll;
        this.showCompleted = showCompleted;
        this.showIncomplete = showIncomplete;
    }

    public List<Map<Integer, String>> filterItems (List<Map<Integer, String>> selectedList){
        //create a new list of maps to hold the new filtered list
        List<Map<Integer, String>> filteredList = new ArrayList<>();

        //if showAll is true
            //show all items for the selected to-do list in the list view
            //filteredList add all of selected list
        //if else showCompleted is true
            //show only completed items for selected list in the list view
            //filteredList add only items with the completed checkbox checked from selected list
        //else
            //show only incomplete items for selected list in the list view
            //filteredList add only items with the completed checkbox NOT checked from selected list

        return filteredList;
    }
}
