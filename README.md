# Java Command-Line To-Do Application
This is a simple console - based  To-Do List Application built with Java. It allows users to manage their tasks by adding, viewing, marking as complete, and deleting them. Tasks are saved to a local file, ensuring persistence even after the application is closed.

Features

-   **Add Task:** Quickly add new tasks to your list.
-   **View Tasks:** See all your current tasks, numbered for easy reference.
-   **Mark Complete:** Mark tasks as completed (changes `[ ]` to `[X]`).
-   **Delete Task:** Remove tasks from your list.
-   **Data Persistence:** All tasks are automatically saved to `tasks.txt` and loaded on startup.

Technologies Used

-   **Java:** Core programming language.
-   **`java.util.ArrayList`:** Used for managing tasks in memory dynamically.
-   **`java.io.*` (FileReader, FileWriter, BufferedReader, BufferedWriter):** Essential for handling file input/output to save and load tasks, allowing data to persist between sessions.
-   **`java.util.Scanner`:** Utilized for reading various types of user input from the console.

How To Run
1.  **Prerequisites:** Ensure you have a Java Development Kit (JDK) installed on your system (Java 8 or newer is recommended).
2.  **Clone/Download the Repository:**
    ```bash
    git clone [https://github.com/Kanishka0308-05/JavaToDoApp.git](https://github.com/Kanishka0308-05/JavaToDoApp.git)
    cd JavaToDoApp
    ```
    (Ensure `Kanishka0308-05` matches your actual GitHub username for this specific repository.)
3.  **Compile the Code:**
    ```bash
    javac ToDoApp.java
    ```
4.  **Run the Application:**
    ```bash
    java ToDoApp
    ```
    Follow the on-screen prompts in the console.


 Lessons Learned & Skills Demonstrated

-   **Core Java Concepts:** Gained hands-on experience with fundamental Java syntax, data types, and control flow structures (like `do-while` loops for the menu, `switch` statements for choices).
-   **Object-Oriented Programming (OOP) Basics:** Used `ArrayList` effectively as a dynamic data structure to store and manipulate a collection of tasks.
-   **File I/O and Persistence:** Successfully implemented robust file reading and writing operations (`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`) to achieve data persistence, ensuring tasks are saved and loaded. This also involved learning to handle `IOException` and `FileNotFoundException`.
-   **User Input Handling:** Practiced taking diverse user input from the console using the `Scanner` class and implemented basic input validation to handle `NumberFormatException` for a more robust user experience.
-   **Modular Design (Methods):** Organized the code into distinct, reusable methods (e.g., `addTask`, `viewTasks`, `saveTasks`, `loadTasks`, `markTaskComplete`, `deleteTask`) which significantly improved code readability and maintainability.
-   **Basic Problem-Solving:** Addressed common programming challenges such as managing a list of items, implementing search/modification logic, and ensuring data integrity across application restarts.
