package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

public class TodoListItem {
    String description;
    String dueDate;

    TodoListItem (String description, String dueDate){
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription(){
        //get description
        return description;
    }

    public void setDescription(String description){
        //set description
        this.description = description;
    }

    public String getDueDate(){
        //get description
        return dueDate;
    }

    public void setDueDate(String date){
        //set description
        this.dueDate = date;
    }

    public void editDescription (String description){
        //set description with updated description for selected item when update button is pressed
    }

    public void checkCompleted () {
        //if check box is checked
            //current item completed = true
    }
}
