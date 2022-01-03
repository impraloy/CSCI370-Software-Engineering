# Test Plan

**Author**: Team 4

## 1 Testing Strategy

### 1.1 Overall strategy

Overall, we will test if we can make a reminder that will be added if the user requests it or searches and does not get a result. We start off making a list that will hold a number of reminders and send the data to a database. We will make a test run by adding a reminder to a list to see if the data transfers over. If the data comes through,we will see if the database sends the data back to the application and to the user.

### 1.2 Test Selection

We will use both black-box testing and white-box testing to cover all sides of the program. We will get a user to test our program and one of the programmers to also test the application on an internal level.

### 1.3 Adequacy Criterion

We are going to make a variety of reminders, reminder lists and perform actions, including deleting, creating, editing and searching the reminder. We will make sure to test all the exceptions and test the limits of our application.

### 1.4 Bug Tracking

There may be a report function that will report bugs and if the program crashes, it should collect information depending on the issue. All the bugs that are collected will be put into a text file, and will be checked off when the bug is fixed.

### 1.5 Technology

We plan to use JUnit for our testing technology.

## 2 Test Cases

| Test Case ID | Test Case Objective                                       | Prerequisite                                           | Steps                                                                                                                                                                                                                                                                                                                 | Input Data                                  | Expected Output                             | Actual Output                                                              | Status           |
| ------------ | --------------------------------------------------------- | ------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------- | ------------------------------------------- | -------------------------------------------------------------------------- | ---------------- |
| 1            | Test if a reminder list can be made                       | Application is active and working.                     | <ol><li>User presses add reminder list button</li> <li>User inputs “Chores”</li> <li>User presses confirm button</li> <li>Data is sent from the application to the database</li></ol>                                                                                                                                 | Chores                                      | Chores                                      | Chores                                                                     | Success &#10003; |
| 2            | Test if a reminder can be made                            | Application is active and working.                     | <ol><li>User presses add reminder button</li> <li>User inputs “Vacuum living room”</li> <li>User puts in time, date and location if necessary</li> <li>User presses confirm button </li><li>Data is sent from the application to the database </li></ol>                                                              | Vacuum living room                          | Vacuum living room                          | Vaccuum living room                                                        | Success &#10003; |
| 3            | Test if a reminder list can be deleted                    | Application is active and working.                     | <ol><li>User presses delete reminder button</li> <li>User presses confirm button</li> <li>Data is sent from the application to the database</li> </ol>                                                                                                                                                                | Delete Button                               | Deleted Reminder List                       | Application has deleted Reminder List                                      | Success &#10003; |
| 4            | Test if a reminder can be deleted                         | There is already a reminder list and remainder created | <ol><li>User presses delete reminder button</li> <li>User presses confirm button</li> <li>Data is sent from the application to the database</li> </ol>                                                                                                                                                                | Delete Button                               | Deleted Reminder                            | Application has deleted Reminder                                           | Success &#10003; |
| 5            | Test if a reminder list name can be edited                | There is a reminder list that is exists                | <ol><li>User presses edit reminder list button</li> <li>Application shows the menu with the name of the list</li><li>User changes the name to their desired name</li> <li>Data is sent from the application to the database</li></ol>                                                                                 | Monday’s Schedule                           | Monday’s Schedule                           | Application changed the list's name to "Monday’s Schedule"                 | Success &#10003; |
| 6            | Test if a reminder name can be edited                     | There is a reminder list and reminder already made     | <ol><li>User presses edit reminder</li> <li>Application shows the name of the reminder</li> <li>User provides a new name for the reminder</li><li>Data is sent from the application to the database</li></ol>                                                                                                         | Pick up milk and chocolate                  | Pick up milk and chocolate                  | Application changed the reminder's name to be "Pick up milk and chocolate" | Success &#10003; |
| 7            | Test if a reminder can be searched                        | Reminder(s) already exist in any list(s)               | <ol><li>User type a specific reminder in the search bar</li> <li>Application searches the database for the specific or similar named reminder</li> <li>Application show the exact or similar named reminders</li> <li>User selects the desired reminder and gets directed to the location from the database</li></ol> | Buy eggs                                    | Buy eggs                                    |                                                                            | 				    |
| 8            | Test if a reminder’s time, date or location can be edited | There is a reminder list and reminder made.            | <ol><li>User presses the edit reminder button</li> <li>Application provides the data from the database</li> <li>User adds the desired information</li> <li>Data is sent from the application to the database</li></ol>                                                                                                | Time: 4:00 pm Location: Home Date: 1/1/2020 | Time: 4:00 pm Location: Home Date: 1/1/2020 |                                                                            |                  |
| 9            | Test if a reminder list’s name can be left blank          | The application is running and active                  | <ol><li>User presses the add reminder list button</li> <li>User provides no input </li> <li>User presses confirm </li> <li>Data is sent to the application </li></ol>                                                                                                                                                 | Blank                                       | Blank                                       | Reminder list name is required by the application                          | Failure &#10007; |
| 10           | Test if a reminder’s name can be left blank               | There is a reminder list made                          | <ol><li>User presses add reminder button</li> <li>User provides no name, but fills out everything else</li> <li>User presses confirm</li> <li>Application receives data</li></ol>                                                                                                                                     | Blank                                       | Blank                                       | Reminder name is required by the application                               | Failure &#10007; |

# Extra Requirements

Some supplementary requirements for our application include

  <ul>
  <li>Responsive</li>
  <li>Scalability</li>
  <li>Compatibility</li>
  <li>Reliable</li>
  <li>Easy to use</li>
	</ul>
