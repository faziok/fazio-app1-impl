package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Load {
    List<Map<Integer, String>> loadedTodoList = new ArrayList<>();

    public void loadFile () {
        //prompt user for file path name
        //create Path object for file to load

        //while next line does not equal null
            //create a new map for next two lines of text (1st line for description, 2nd line for dueDate)
            //add map to to-do list
    }

    public List<Map<Integer, String>> getLoadedFile(){
        //get loadedTodoList
        return loadedTodoList;
    }
}
