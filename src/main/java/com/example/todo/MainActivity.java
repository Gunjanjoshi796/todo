package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ToDoAdapter adapter;

    ListView listView;

    SQLiteManager sqLiteManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        sqLiteManager = SQLiteManager.instanceOfDatabase(this);

        sqLiteManager.populateTodoListArray();

        adapter = new ToDoAdapter(getApplicationContext(), Todo.todoArrayList);

        listView.setAdapter(adapter);
    }

    public void newToDo(View view){
        Intent intent = new Intent(MainActivity.this, make_todo.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Todo.todoArrayList.clear();
        sqLiteManager.populateTodoListArray();
    }
}