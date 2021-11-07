package todoListApp.baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Keven Fazio
 */

import javafx.collections.ObservableList;

import java.io.*;

public class Save {
    public void saveTxtFile (File file, ObservableList<TodoListItem> list){
            try {
                PrintWriter pWriter = new PrintWriter(file);
                for (TodoListItem s : list) {
                    pWriter.write(s.getDescription() + "," + s.getDueDate() + "," + s.getStatus() + "\n");
                }

                System.out.println("File written Successfully");
                pWriter.close();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
    }
}

