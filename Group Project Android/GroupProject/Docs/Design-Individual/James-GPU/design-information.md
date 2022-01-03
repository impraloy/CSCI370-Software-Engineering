# Design Information Document

## By James Ng

1. A list consisting of reminders the users want to be aware of. The application must allow
   users to add reminders to a list, delete reminders from a list, and edit the reminders in
   the list.
   I've added the addReminder function, editReminder function and editReminder function in the Reminder section to allow the user to edit however they like.

2. The application must contain a database (DB) of reminders and corresponding data
   There is a Database section that holds all the data and reminders

3. Users must be able to add reminders to a list by picking them from a hierarchical list,
   where the first level is the reminder type (e.g., Appointment), and the second level is the
   name of the actual reminder (e.g., Dentist Appointment).
   There is a addReminderType function and addReminderName function in the ReminderType section to pick the list from a hierachical list

4. Users must also be able to specify a reminder by typing its name. In this case, the
   application must look in its DB for reminders with similar names and ask the user
   whether that is the item they intended to add. If a match (or nearby match) cannot be
   found, the application must ask the user to select a reminder type for the reminder, or
   add a new one, and then save the new reminder, together with its type, in the DB.
   There is a searchReminder function in the Reminder section for the user to search for the reminder by name.
   If there is not a match, it will use the addReminder function in the Reminder section to add another reminder.

5. The reminders must be saved automatically and immediately after they are modified.
   There is saveReminder function in the Reminder section that will save automatically and after modification.

6. Users must be able to check off reminders in the list (without deleting them).
   There is checkOffReminder function in the Reminder section that will check off after triggering the event

7. Users must also be able to clear all the check-off marks in the reminder list at once.
   There is also checkOffAllReminders function in the Reminder section to check off every mark at once

8. Check-off marks for the reminder list are persistent and must also be saved immediately.
   There is saveReminder function in the Reminder section to also save immediately.

9. The application must present the reminders grouped by type.
   There is groupReminder function in the Reminder section to group according to type.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
    “Kid’s Reminders”). Therefore, the application must provide the users with the ability to
    create, (re)name, select, and delete reminder lists.
    There is the createReminderList function,nameReminderList function,selectReminderList function,deleteReminderList function in the Reminder Section for the user to create, name, select and delete lists.

11. The application should have the option to set up reminders with day and time alert. If this
    option is selected allow option to repeat the behavior.
    There is the addDateTimeAlert function in the Reminder Section to add reminders based on day and time.

12. Extra Credit: Option to set up reminder based on location.
    There is the Location section that will track via Global Positioning System (GPS).

13. The User Interface (UI) must be intuitive and responsive.
    This will be reflected in the code of the design itself.
