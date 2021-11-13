package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteManager extends SQLiteOpenHelper {

    private static SQLiteManager sqLiteManager;

    // Database Name for giving it to constructor;
    private static final String DATABASE_NAME = "TODO_DATABASE";
    // We'll use Table Name often in our upcoming Methods;
    private static final String TABLE_NAME = "TODO";
    // You can give any value you desire
    // it only matters if u are working with multiple Database;
    private static final int DATABASE_VERSION = 1;

    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // By making instance of SQLiteManager we are just reducing our one line code everywhere we had to call the sqliteDatabase object;
    public static SQLiteManager instanceOfDatabase(Context context) {
        if (sqLiteManager == null)
            sqLiteManager = new SQLiteManager(context);
        return sqLiteManager;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME + " (_ID INTEGER PRIMARY KEY AUTOINCREMENT, DESCRIPTION TEXT )";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // only one line code to tell if Table already exist than drop it;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addTodoToDatabase(Todo todo) {
        // Creating instance of SqliteDatabase Class
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // ContentValues help us to insert data in our Database
        ContentValues contentValues = new ContentValues();


        contentValues.put("DESCRIPTION", todo.getDescription());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

    }


    public void populateTodoListArray() {
        // Creating instance of SqliteDatabase Class
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();


        Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        try {
            if (result.getCount() != 0) {
                while (result.moveToNext()) {
                    String DESCRIPTION = result.getString(1);

                    Todo todo = new Todo(DESCRIPTION);
                    Todo.todoArrayList.add(todo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
