package com.example.projecttwocs360shayla.model;

public class Event {

    private long _ID;
    private String eventTitle;
    private String eventDescription;
    private long myDate;

    public Event(long id, String title, String description, long date){
        _ID = id;
        eventTitle = title;
        eventDescription = description;
        myDate = date;
    }

    public void set_ID(long id){
        _ID = id;
    }

    public long get_ID(){
        return _ID;
    }

    public void setEventTitle(String title){
        eventTitle = title;
    }

    public String getEventTitle(){
        return eventTitle;
    }

    public void setEventDescription(String desc){
        eventDescription = desc;
    }

    public String getEventDescription(){
        return eventDescription;
    }

    public void setMyDate(long date){
        myDate = date;
    }

    public long getMyDate() {
        return myDate;
    }



}
