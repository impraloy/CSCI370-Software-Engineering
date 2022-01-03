
1. **A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.**

To realize this requirement, I implemented a class called ReminderList which has methods for the user to add (add_reminder), delete (delete_reminder), and edit (edit_reminder) reminders.
These methods require the name of the reminder to appropriately change the chosen reminder.

**2. The application must contain a database (DB) of reminders and corresponding data.**

To realize this requirement, I implemented a database containing reminders and their corresponding data. This DB is a cloud-based database with CRUD principles to allow persistent storage and save features for users. I did not model the DB due to said guidelines in the Assignment.

**3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).**

To realize this requirement, I created a Reminder_Type class. This class inherits from the type_of_reminder class that has the data of the different types of reminders the user can choose. Thereafter, this relates to the Reminder_Type class that has two levels(as per requirements), 1) reminder_type being the actual type of reminder and
2) being reminder_name, the name of the reminder. The Reminder_Type class is called by the user by using the add_reminder method that encapsulates the aforementioned info all in one function call.

**4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.**

To realize this requirement, I created a reminder_lookup method in the Reminder_View class that allows the user/application to search for a specific reminder based on the name. If the name is a match or nearby match it will point the user towards the reminder. If
it is not a match/nearby match it will then allow the user to lookup the type of reminder, add a new one, and allow the user to save the new reminder with its type in the DB. This aforementioned feature has not been modelled in the UML diagram as it is a UI/UX feature, but the underlying functionality of querying data from the Reminder_View to the DB is displayed in the UML diagram shown.

**5. The reminders must be saved automatically and immediately after they are modified.**

To realize this requirement, I made the Reminder_List class automatically connect and update any reminders via the cloud-connected CRUD database. Due to this feature, any reminders will be saved automatically in the cloud and immediately save if they are modified even the slightest.

**6. Users must be able to check off reminders in the list (without deleting them).**

I realized this requirement by creating the checkoff_reminder in the Reminder_List class. This function takes in the name of the reminder and the user will be able to check off a reminder in the list of reminders without deleting them.

**7. Users must also be able to clear all the check-off marks in the reminder list at once.**

I relaized this requirement by creating the clear_checkoff function in the Reminder_List class. This function allows users to clear the check-off marks in the reminder list all at once without deleting any of them.

**8. Check-off marks for the reminder list are persistent and must also be saved immediately.**

To realize this requirement, I created a checkedOff boolean attribute that is true when a check-off marker appears on the list. When the reminder is created and is checked-off, it will be saved automatically through the persistent cloud storage/CRUD connection we have in the database.

**9. The application must present the reminders grouped by type.**

I realized this requirement by making each Reminder have a Reminder_Type. The Reminder_Type class ensures that each reminder, when created, has a specific predefined type (ex. Task, Event, General, etc). Therefore on the backend the reminders are grouped by type, but since this is more of a UI/UX element I did not reflect its implementation in the UML diagram.

**10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). 
Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.**

I realized the multiple reminder lists by creating the Reminder_View class. This allows users to create different list types such as weekly, monthly, and other list types as well as the ability to create, rename, select and delete lists using the mentioned functions: create_list, rename_list, delete_list.

**11. The application should have the option to set up reminders with day and time alert. If this
option is selected allow option to repeat the behavior.**

To realize this requirement, I mentioned in the previous question that I created a subclass in the Reminder class called "reminder_time". This subclass has a number of functions including reminder_range which allows a user to choose a time range to get reminders, reminder_endtime which allows user to choose when to end reminders, and repeat_daily, weekly, monthly, yearly to choose a specific repeat time for that reminder. The Reminder class references these different methods by using the reminder_repeat function. This allows users to choose whichever timeframe they want their reminder to repeat at.

**12. Extra Credit: Option to set up reminder based on location.**

I realized this requirement by adding a function to the Reminder class that creates the reminder. When a user creates a reminder, they will be prompted to add a location to their reminder - this is made by an API call to Mapbox/similar location-based service that allows a user to lookup and select a location based on their preference. The result will be a location being added to the reminder for the user.

**13. The User Interface (UI) must be intuitive and responsive**

Since the UML diagram does not model for UI/UX elements this has not been specified in the diagram. However the end goal of the Reminders app would be to include a simple, intuitive, and responsive UI/UX that would fulfill requirements and exceed expectations of a beautiful, intuitive and responsive UI.