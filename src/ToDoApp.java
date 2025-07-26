import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {

    private static final String FILE_NAME = "tasks.txt";
    private static List<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadTasks(); // Load tasks when the application starts

        int choice;
        do {
            System.out.println("\n--- To-Do List Application ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1; // Set to invalid choice to re-loop
            }

            switch (choice) {
                case 1:
                    viewTasks();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    markTaskComplete();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 0:
                    saveTasks(); // Save tasks before exiting
                    System.out.println("Exiting To-Do List. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing tasks file found. Creating a new one.");
            // File will be created when first task is saved
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
        }
    }

    private static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in your list yet!");
            return;
        }
        System.out.println("\n--- Your Tasks ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void addTask() {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add("[ ] " + task); // Add task with a checkbox indicator
        System.out.println("Task added: " + task);
    }

    private static void markTaskComplete() {
        viewTasks();
        if (tasks.isEmpty()) {
            return;
        }
        System.out.print("Enter the number of the task to mark as complete: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String task = tasks.get(taskNumber - 1);
                if (task.startsWith("[ ] ")) {
                    tasks.set(taskNumber - 1, "[X] " + task.substring(4));
                    System.out.println("Task marked complete: " + task);
                } else if (task.startsWith("[X] ")) {
                    System.out.println("Task is already marked complete.");
                }
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) {
            return;
        }
        System.out.print("Enter the number of the task to delete: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Task deleted: " + removedTask);
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}