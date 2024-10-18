package com.example.proiectfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_user_crama";
    private static final String TABLE_NAME = "user_table";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "Nume";
    private static final String COL_PASSWORD = "Parola";
    private static final String COL_VARSTA = "Varsta";
    public DbHelper(Context context) {
//constructorul clasei
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//suprascrierea metodei onCreate, pentru ca la
//apelarea acesteia sa fie creat tabelul nostrum
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_PASSWORD + " TEXT, "
                + COL_VARSTA + " INTEGER);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
    public boolean insertData(String name, String password,String age) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_PASSWORD, password);
        values.put(COL_VARSTA, age);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean checkUserCredentials(String name, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COL_NAME + " = ? AND " +
                COL_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{name, password});
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor result = db.rawQuery(query,null);
        return result;
    }
}