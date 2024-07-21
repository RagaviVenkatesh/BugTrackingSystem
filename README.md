**Bug Tracking System**

**Features:**
Add, update, delete, and list bugs.
Categorize bugs (e.g., UI, Backend, Database).
Assign bugs to developers.
Track bug status and resolution.

To create a Bug Tracking System using JDBC and MySQL, we'll define the following components:
    Database Schema
    Model Classes
    DAO Classes
    Utility Classes
    Controller Classes

**Database Tables:**
bugs (bug_id, description, category_id, assigned_to, status, created_date, resolved_date)
categories (category_id, category_name)
developers (developer_id, name, email)

**model**
model for objects (attributes, constructors, getters, setters & .toString())
**dao**
methods to communicate with data source and perform the tasks demanded by the business logic
**controller**
the flow of the application
**utility**
methods for frequently needs

**Menu and User Input:**
A menu is displayed, and the user is prompted to enter a choice. Based on the choice, different operations are performed.

**Operations:**
Add Category: Prompts the user for the category name and adds it to the database.
Add Developer: Prompts the user for the developer name and email and adds it to the database.
Add Bug: Prompts the user for the bug description, category ID, and assigned developer ID, and adds the bug to the database.
List Bugs with Category Names: Lists all bugs along with their category names.
List Bugs Assigned to Developer: Prompts the user for the developer name and lists all bugs assigned to that developer.
Bug Counts by Developer: Lists the number of bugs assigned to each developer.
Bugs with Developer Details: Lists all bugs with their assigned developer's details.
Bugs Resolved in Time Frame: Prompts the user for start and end times and lists all bugs resolved within that time frame.
Developer with Most Bugs Assigned: Lists the developer with the highest number of bugs assigned.
List Bugs by Category: Prompts the user for the category name and lists all bugs within that category.
Average Resolution Time by Developer: Lists the average resolution time for each developer.
Max Bugs Assigned to a Developer: Lists the maximum number of bugs assigned to a single developer.
Developers with Resolved Bugs Above Threshold: Prompts the user for the threshold number of resolved bugs and lists developers who have resolved more than that number of bugs.
Exit: Exits the application.

**Running the Application**
Compile and run the Main.java class. Follow the menu options to interact with the Bug Tracking System dynamically. The user inputs will guide the actions, and the application will perform the corresponding operations on the database.
