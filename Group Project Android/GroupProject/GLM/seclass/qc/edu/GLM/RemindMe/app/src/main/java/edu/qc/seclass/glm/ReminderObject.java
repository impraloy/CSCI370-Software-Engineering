package edu.qc.seclass.glm;

import androidx.annotation.NonNull;

public class ReminderObject implements Comparable<ReminderObject>{
    private String reminderName;
    private String reminderDesc;
    private String reminderDate;
    private String reminderKey;
    private String reminderType;
    private String listKey;
    Boolean isChecked;

    public ReminderObject() {
    }

    public ReminderObject(String reminderName, String reminderDesc, String reminderDate, String reminderKey, String listKey, String reminderType, Boolean isChecked) {
        this.reminderName = reminderName;
        this.reminderDesc = reminderDesc;
        this.reminderDate = reminderDate;
        this.reminderKey = reminderKey;
        this.listKey = listKey;
        this.reminderType = reminderType;
        this.isChecked = isChecked;
    }

    public String getReminderName() {
        return reminderName;
    }

    public void setReminderName(String reminderName) {
        this.reminderName = reminderName;
    }

    public String getReminderDesc() {
        return reminderDesc;
    }

    public void setReminderDesc(String reminderDesc) {
        this.reminderDesc = reminderDesc;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getReminderKey() {
        return reminderKey;
    }

    public void setReminderKey(String reminderKey) {
        this.reminderKey = reminderKey;
    }

    public String getListKey() {
        return listKey;
    }

    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    public String getReminderType() {
        return reminderType;
    }

    public void setReminderType(String reminderType) {
        this.reminderType = reminderType;
    }

    public Boolean getIsChecked(){return isChecked;}

    public void setIsChecked(Boolean isChecked){this.isChecked = isChecked;}

    @Override
    public int compareTo(ReminderObject r) {
        if (r.getReminderType() == null || this.reminderType == null) return 0;
        else return this.reminderType.compareTo(r.getReminderType());
    }
}