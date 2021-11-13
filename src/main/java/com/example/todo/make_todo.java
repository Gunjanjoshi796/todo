package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class make_todo extends AppCompatActivity {

    private EditText descForTodo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_todo);

        inItWidgets();
        
    }

    private void inItWidgets() {
        descForTodo = findViewById(R.id.desc_for_makeTodo);
    }

    public void saveTodo(View view) {

        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);

        String desc = String.valueOf(descForTodo.getText());


        Todo todo = new Todo(desc);

        Todo.todoArrayList.add(todo);

        sqLiteManager.addTodoToDatabase(todo);

        finish();


    }
}