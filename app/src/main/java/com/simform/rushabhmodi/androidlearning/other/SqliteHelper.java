package com.simform.rushabhmodi.androidlearning.other;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.simform.rushabhmodi.androidlearning.model.SqlitePojo;

/**
 * Created by rushabh.modi on 27/02/18.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION  = 1;
    public static final String DATABASE_NAME = "sqlitedatabase.db";
    public static final String TABLE_NAME = "sqlitetable";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_ITEM = "item";
    public static final String COLUMN_DESCRIPTION = "description";

    public SqliteHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NUMBER + " INTEGER, " +
                COLUMN_ITEM + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertItem(SqlitePojo sqlitePojo) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NUMBER, sqlitePojo.getNumber());
        values.put(COLUMN_ITEM, sqlitePojo.getItem());
        values.put(COLUMN_DESCRIPTION, sqlitePojo.getDescription());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void deleteItem(String itemName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " +
                COLUMN_ITEM + "=\"" + itemName + "\";");
    }

    public String dbToString() {
        StringBuilder dbString = new StringBuilder();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;// + " WHERE 1";

        //Cursor point to a location in result
        @SuppressLint("Recycle")
        Cursor c = db.rawQuery(query, null);
        //Move to the first
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_DESCRIPTION)) != null) {
                //dbString.append(c.getString(c.getColumnIndex(COLUMN_ID))).append(" ");
                dbString.append(c.getString(c.getColumnIndex(COLUMN_NUMBER))).append(" - ");
                dbString.append(c.getString(c.getColumnIndex(COLUMN_ITEM))).append(" - ");
                dbString.append(c.getString(c.getColumnIndex(COLUMN_DESCRIPTION)));
                dbString.append("\n");
            }
            c.moveToNext();
        }
        db.close();
        return dbString.toString();
    }
}
