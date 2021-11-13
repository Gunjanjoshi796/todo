package com.example.todo;

import java.util.ArrayList;

public class Todo {
    public static ArrayList<Todo> todoArrayList = new ArrayList<>();

    public String Description;

    public Todo(String description) {
        Description = description;
    }

    public static ArrayList<Todo> getTodoArrayList() {
        return todoArrayList;
    }

    public static void setTodoArrayList(ArrayList<Todo> todoArrayList) {
        Todo.todoArrayList = todoArrayList;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
