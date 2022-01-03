# Project Plan

Team 4

## 1 Introduction

This product is a reminder application to prompt the user that there is an activity to be done. The user is reminded of their reminders when they are scheduled and their reminders are listed in the app whenever they choose to access it. Users will be able to receive notifications, check reminders and lists of reminders, and be able to view the calendar/add location/ take photos if needed.

## 2 Process Description

**AddListActivity**

<br>Description: This activity will give users the ability to add lists to the main page of the application<br>
Entrance Criteria: Press on a ‘plus’ icon on the main page<br>
Exit Criteria: A new page that allow users to input a name for their list<br>

**EditListActivity**

<br>Description: This activity lets users edit a selected list.<br>
Entrance Criteria: Hold press the selected list and a edit list menu will pop up. The user may edit the name of the title.<br>
Exit Criteria: Selected list will be renamed.<br>

**SearchActivity**

<br>Description: This activity allow users to search for specific reminders across all lists<br>
Entrance Criteria: User types in a reminder name in the search bar on the main page and presses ‘Search’ button<br>
Exit Criteria: Displays the reminder the users wants to see and gives them the ability to be directed to the reminder<br>

**AlertActivity**

<br>Description: This activity give users the ability to add alerts for any reminder. It can be any day or time, and has the option for it to be repeatable<br>
Entrance Criteria: User selects what time and day they want their alert to be. There will be an option to turn on or off repeatable alert<br>
Exit Criteria: There will be an alert icon next to the reminder to show that an alert has been set on it. It can be clicked to show when the alert is<br>

**AddReminderActivity**

<br>Description: This activity allow users to add reminders to whatever list they want to<br>
Entrance Criteria: User must be in their desired list in order to execute this activity. There will be an option that must be pressed and then the user must add a name to the reminder. There will be an optional part where they can add more information to the reminder<br>
Exit Criteria: The output will be a card that display the reminder name in the selected list<br>

**EditReminderActivity**

<br>Description: This activity allow users to edit reminders on any list the users are in<br>
Entrance Criteria: Users must be in their desired list in order to execute this activity. Hold press the selected list and a edit menu will pop up<br>
Exit Criteria: The output will be a edited or deleted reminder<br>

**ListActivity**

<br>Description: This activity allow users to view lists the users are in from the database.<br>
Entrance Criteria: Users begin in this activity.<br>
Exit Criteria: The activity automatically starts here.<br>

**ListAdapter**

<br>Description: This activity allow the database to view keys and names on their list and transfers the data to and from the database.<br>
Entrance Criteria: This activity works along side the ListActivity when it is activated<br>
Exit Criteria: The activity automatically start when ListActivity starts.<br>

**ListObject**

<br>Description: This activity provides the means to retrieve their specific list from their name<br>
Entrance Criteria: This activity works along side the ListActivity when it is activated<br>
Exit Criteria: The user is shown their lists that they have created.<br>

**ReminderActivity**

<br>Description: This activity provides interface to view their reminders from a specific list.<br>
Entrance Criteria: This activity begins as soon as the user taps the specific list from ListActivity.<br>
Exit Criteria: The activity shows the user their reminders.<br>

**ReminderAdapter**

<br>Description: This activity provides data from the application and database.<br>
Entrance Criteria: This activity begins as soon as the user taps the specific list from ListActivity.<br>
Exit Criteria: The activity shows the user their reminders.<br>

**ReminderObject**

<br>Description: This activity provides the data from the application to view their reminders from a specific list.<br>
Entrance Criteria: This activity begins as soon as the user taps the specific list from ListActivity.<br>
Exit Criteria: The activity shows the user their reminders.<br>

## 3 Team

Andrew Li - Programming (main) and Documentation<br>
I will mainly work on coding the application while assisting the documenters on understanding the code<br>
Umar - Programming (main) and Documentation side<br>
I will mainly work on the programming side and also assist in the documentation side.<br>
James - Documentation (main) and Programming<br>
I will work on creating documentation and help others understand what functions do while also helping with programming.<br>
Praloy Saha - Programming (main) and Documentation<br>
I will work on both the documentation, and programming of the application and also helping others on the programming.<br>
Abdul - Programming (main) and Documentation<br>
I will work on the documentation and programming of the application.<br>

- Table showing which team member(s) has which role(s)

| James                                     | Umar                                     | Andrew                                   | Praloy                                   | Abdul                                    |
| ----------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| Documentation (Main) and Programming(Sub) | Programming (Main) & Documentation (Sub) | Programming (Main) & Documentation (Sub) | Programming (Main) & Documentation (Sub) | Programming (Main) & Documentation (Sub) |
