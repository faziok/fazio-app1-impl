package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import java.time.LocalDate;

public class TodoListItem {
    private String description;
    private LocalDate dueDate;
    private boolean status;

    //default constructor
    public TodoListItem (){
        description = null;
        dueDate = LocalDate.now();
        status = false;
    }

    //Parameterized constructor
    public TodoListItem (String description, LocalDate dueDate, boolean status){
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
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
        String dueDateString;

        if (dueDate == null){
            dueDateString = "";
        }else {
            dueDateString = dueDate.toString();
        }

        //get description
        return dueDateString;
    }

    public void setDueDate(LocalDate date){
        //set description
        this.dueDate = date;
    }

    public String getStatus(){
        //get status as incomplete of complete
        String completedStatus;
        if(status){
            completedStatus = "Completed";
        }
        else{
            completedStatus = "Incomplete";
        }

        return completedStatus;
    }

    public void setStatus(boolean status) {
        //set status
        this.status = status;
    }

    //override data to a string
    @Override
    public String toString(){
        return getDescription() + " " + getDueDate() + " " + getStatus();
    }
}
