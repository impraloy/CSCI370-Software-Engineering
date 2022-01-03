# Reminder Design Information

This is a software design of an application that allow users to add, edit, or remove user created reminders from user created lists.

## Requirements
Below comprises of information regarding the requirements of the application:
1. **The design consist of a class reminderList with attributes listName and reminders.**
listName attribute is a string type and used as the name of the list. 
reminders attribute is a list type and used to store all the reminders from a list. 
Its operations are addReminder, removeReminder, and editReminder.
addReminder let reminders be added to a list.
removeReminder let reminders be deleted from a list.
editReminder let reminders be edited in a list.
One of this class contains multiple reminderTask classes.
2. **The design has a class reminderDB with attributes idReminder and nameReminder.**
idReminder is a int type and used to store the id number of the reminder.
nameReminder is a string type and used to store the name of the reminder.
The reminderTask, reminderCheck, and reminderDayTime classes are all saved into this database.
3. **Not considered because the functionality of the design is not affected by adding types.**
4. **Not considered because a search function does not affect the core of the software.**
5. **The design has a class reminderTask that contains the attributes id and name.**
These two will store the id number of the reminder and the reminder name respectively.
There is an operation named saveTask where it will immediately save any edit to the reminder to the database.
This class uses one of the reminderTask class.
6. **The design has the class reminderCheck with the attribute check.**
This attribute is an int type and is used to determine whether check marks are on or off. 
The operations addCheck and removeCheck allow checks to be added or removed respectively.
7. **The class reminderCheck has an operation named clearAll which will clear all the checks.**
8. **The class reminderCheck has an operation named saveCheck which will save the check into the database.**
9. **Not considered because types are not implemented in the design.**
10. **There is a class reminderApp with the attribute lists.**
This attribute is a list type and stores all the lists that will be created.
The operations of this class are createList, renameList, selectList, and deleteList.
createList allows for the creation of any list.
renameList let users to rename any list.
selectList let users to select a specific list.
deleteList will delete any specific list.
This class contains multiple reminderList classes.
11. **The design has a class reminderDayTime with attributes day, time, and repeat.**
The day attribute is an int type which will store the day of a reminder.
The time attribute is an int type which will store the time of a reminder.
The repeat attribute is an int type that will be either an 1 or 0 that tells whether a reminder is repeatable or not.
Its operations are dayReminder, timeReminder, and repeatReminder.
dayReminder presents the day the reminder was created.
timeReminder presents the exact time the reminder was created.
repeatReminder is a switch that if turned on, selected reminders will repeat continously.
This class uses one of reminderTask class.
12. **Optional**
13. **Not considered because it does not affect the design directly.**