1\. A list consisting of reminders the users want to be aware of. The application must allow
users to add reminders to a list, delete reminders from a list, and edit the reminders in
the list.
-   For this I created a class called ReminderList that has a list of
     all the reminders and keeps track of their type and name. It has
     all the functions mentioned above.

2\. The application must contain a database (DB) of reminders and corresponding data.
-   In the UML diagram I added a database for the reminders and data.

3\. Users must be able to add reminders to a list by picking them from a hierarchical list,
where the first level is the reminder type (e.g., Appointment), and the second level is the
name of the actual reminder (e.g., Dentist Appointment).
-   For this, I made two classes. One for reminderTypes and one
     for reminder.

4\. Users must also be able to specify a reminder by typing its name. In this case, the
application must look in its DB for reminders with similar names and ask the user
whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, 
or add a new one, and then save the new reminder, together with its type, in the DB.
-   In the reminder class, I keep track of the reminder by its name
     and type. I added a match function which takes in the name of the
     reminder and searches the database for it. To get the name I call
     the askUserForName function. If it doesn’t find it, then it calls
     the askUserForType function which takes in a type and the database
     searches for it. If it is not found again, the addReminder
     function gets called and takes in a name and a type.

5\. The reminders must be saved automatically and immediately after they are modified.
-   In the reminder class, I added a updateDatabase function so when
     someone makes a change to a reminder, it will get updated in
     the database.

6\. Users must be able to check off reminders in the list (without deleting them).
-   In the reminderList class, I added a function that checks off
     a reminder. It adds a boolean value to it.

7\. Users must also be able to clear all the check-off marks in the reminder list at once.
-   For this, I created a clearChecks function that will clear all the
     checks in the list at once.

8\. Check-off marks for the reminder list are persistent and must also be saved immediately.
-   In the checkReminder function, it checks off a reminder and also
     saves it in the database.

9\. The application must present the reminders grouped by type.
-   In the reminderType class, I added a function that displays all the
     reminders with the same type.

10\. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
“Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.
-   For this I created a class called ReminderListManager that holds a
     collection of Lists. It has the functions mentioned above as well.
     With this we can create multiple different types of lists
     of reminders.

11\. The application should have the option to set up reminders with day
and time alert. If this option is selected allow option to repeat the behavior.
-   For this, I created a reminderRepeat class that creates a reminder
     that has a name and data or time. It will call the alert function
     when it reaches that data or time. It also has a function that
     makes it repeat.

12\. Extra Credit: Option to set up reminder based on location.
-   For this, I created a LocationReminder class that creates a reminder
     with a location so that when we reach a location, the reminder
     will go off. We use the getLocation function to get the location
     of the user.

13\. The User Interface (UI) must be intuitive and responsive.
-   This can be done at a later stage. It can be added later as this is just
    for the UML diagram.
