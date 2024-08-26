package com.example.projecttwocs360shayla.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.projecttwocs360shayla.Database;
import com.example.projecttwocs360shayla.model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class EventDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "EventDatabase.db";

    public static final String eventData = "Event";
    public static final String _ID = "_id";
    public static final String eventTitle = "Title";
    public static final String eventDesc = "Description";
    public static final String date = "Date";

    public static final String SQL_Create = "Create Table " + EventDatabase.eventData +
            " (" + EventDatabase._ID + " INTEGER PRIMARY KEY," + EventDatabase.eventTitle + " TEXT," + EventDatabase.eventDesc + " TEXT," + EventDatabase.date + " INTEGER)";
    public static final String SQL_Delete = "Drop Table if Exists '" + EventDatabase.eventData + "'";

    public EventDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_Create);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_Delete);
        onCreate(sqLiteDatabase);
    }

    //return event from database
    public ArrayList<Event> returnEvents() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                EventDatabase._ID,
                EventDatabase.eventTitle,
                EventDatabase.eventDesc,
                EventDatabase.date
        };

        String sortOrder = EventDatabase.date + " ASC";

        Cursor cursor = db.query(
                EventDatabase.eventData,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        ArrayList<Event> eventArrayList = new ArrayList<>();
        while(cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(EventDatabase._ID));
            String etitle = cursor.getString(cursor.getColumnIndexOrThrow(EventDatabase.eventTitle));
            String edesc = cursor.getString(cursor.getColumnIndexOrThrow(EventDatabase.eventDesc));
            long edate = cursor.getLong(cursor.getColumnIndexOrThrow(EventDatabase.date));

            Event event = new Event(id, etitle,edesc,edate);
            eventArrayList.add(event);
            }
        cursor.close();
        return eventArrayList;
    }


    //insert event into database this will be on an add event activity
    public void insertEvent(String title, String desc, Date mdate) {

        long mydate = mdate.getTime();

        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(eventTitle, title);
        values.put(eventDesc, desc);
        values.put(date, mydate);

        myDatabase.insert(eventData, null, values);
    }

    //update event
    public void updateEvent(long id, String title, String desc, Date mdate) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        long mydate = mdate.getTime();
        values.put(eventTitle, title);
        values.put(eventDesc, desc);
        values.put(date, mydate);
        myDatabase.update(eventData, values, "_ID = " + id, null);
    }

    //delete event
    public void deleteEvent(long id) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        myDatabase.delete(eventData, "_ID = " + id, null);
    }

    public Event returnEvent(long myId){
        SQLiteDatabase myDatabase = this.getReadableDatabase();
        String[] projection = {
                EventDatabase._ID,
                EventDatabase.eventTitle,
                EventDatabase.eventDesc,
                EventDatabase.date
        };

        String sortOrder = EventDatabase.date + " ASC";

        String selection = EventDatabase._ID + " = " + myId;

        Cursor cursor = myDatabase.query(
                EventDatabase.eventData,
                projection,
                selection,
                null,
                null,
                null,
                sortOrder
        );
        cursor.moveToNext();
        long id = cursor.getLong(cursor.getColumnIndexOrThrow(EventDatabase._ID));
        String etitle = cursor.getString(cursor.getColumnIndexOrThrow(EventDatabase.eventTitle));
        String edesc = cursor.getString(cursor.getColumnIndexOrThrow(EventDatabase.eventDesc));
        long edate = cursor.getLong(cursor.getColumnIndexOrThrow(EventDatabase.date));

        Event event = new Event(id, etitle,edesc,edate);

        cursor.close();
        return event;
    }

}
