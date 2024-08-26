package com.example.projecttwocs360shayla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public  static final String DATABASE_NAME = "login.db";

    public static final String loginInfo = "Login";
    public static final String _ID = "_id";
    public static final String Username = "UserName";
    public static final String Password = "Password";

    public static final String SQL_Create = "Create Table " + Database.loginInfo + " (" + Database._ID + " INTEGER PRIMARY KEY," + Database.Username + " USERNAME," + Database.Password + " PASSWORD)";
    public static final String SQL_Delete = "Drop Table if Exists " + Database.loginInfo;

    public Database(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_Delete);
        onCreate(sqLiteDatabase);
    }
    public boolean checkData(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + loginInfo + " where username = ? and password = ?";
        Cursor cursor = db.rawQuery(sql, new String[] { username, password });
        if (cursor.getCount() >0){
            return true;
        }
        else{
            return false;
        }
    }

    public void insertData(String username, String password) {
        if(!checkData(username, password)) {
            SQLiteDatabase myDatabase = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Username, username);
            values.put(Password, password);

            myDatabase.insert(loginInfo, null, values);
        }
        else{
            //send message that data is already in database
        }
    }
}
