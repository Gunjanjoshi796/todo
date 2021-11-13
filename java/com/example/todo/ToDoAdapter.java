package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ToDoAdapter extends ArrayAdapter<Todo> {
    public ToDoAdapter(Context context, ArrayList<Todo> todos) {
        super(context, 0, todos);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view_layout, parent, false);

        }

        Todo currentTodo = getItem(position);

        TextView desctoShowinListView = convertView.findViewById(R.id.description_text_ListView);

        desctoShowinListView.setText(currentTodo.getDescription());


        return convertView;
    }

}
