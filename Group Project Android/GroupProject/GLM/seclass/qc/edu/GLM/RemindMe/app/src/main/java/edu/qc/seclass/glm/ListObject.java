package edu.qc.seclass.glm;

import java.util.ArrayList;

public class ListObject {
    private String listName;
    private String listKey;
    private ArrayList<ReminderObject> reminders;

    public ListObject() {
    }

    public ListObject(String listName, String listKey, ArrayList<ReminderObject> reminders) {
        this.listName = listName;
        this.listKey = listKey;
        this.reminders = reminders;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListKey() {
        return listKey;
    }

    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    public ArrayList<ReminderObject> getReminders() {
        return reminders;
    }

    public void setReminders(ArrayList<ReminderObject> reminders) {
        this.reminders = reminders;
    }
}