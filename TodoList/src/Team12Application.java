import java.util.Scanner;
import java.util.Map.Entry;

public class Team12Application {
	
	static ToDoList tdl = new ToDoList();
	static ToDoList cl = new ToDoList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUpMenu();
		
	}
	
	private static void setUpMenu() {
		System.out.println("Welcome to Team 12 Application! What would you like to do?\n"
				+ "1: View To-Do List\n"
				+ "2: Add Task\n"
				+ "3: Remove Task\n"
				+ "4: Complete Task\n"
				+ "5: View Completed List\n"
				+ "6: Exit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		goTo(option);
	}
	
	private static void goTo(int option) {
		if (option == 1) {
			setUpToDoList();
			System.out.println();
			setUpMenu();
		}
		if (option == 2) {
			setUpAddMenu();
			System.out.println();
			setUpMenu();
		}
		if (option == 3) {
			setUpRemoveMenu();
			System.out.println();
			setUpMenu();
		}
		if (option == 4) {
			setUpCompleteMenu();
			System.out.println();
			setUpMenu();
		}
		if (option == 5) {
			setUpCompletedList();
			System.out.println();
			setUpMenu();
		}
		if (option == 6) {
			System.exit(0);
		}
	}

	private static void setUpToDoList() {
		// TODO Auto-generated method stub
		System.out.println("To-Do List:");
			if (tdl.getAllTasks().isEmpty()) {
				System.out.println("List is empty! Please add a task first.");				
			}
			for (Task task: tdl.getAllTasks()) {
				System.out.println(task.getDescription());
			}
	}
	
	private static void setUpAddMenu() {
		System.out.print("Please enter your task description: ");
		Scanner sc = new Scanner(System.in);
		String desc = sc.nextLine();
		tdl.addTask(new Task(desc));
		System.out.println("Your task has been added to the list!");
	}
	
	private static void setUpRemoveMenu() {
		if (tdl.getAllTasks().isEmpty()) {	
			System.out.println("List is empty! Please add a task first.");
		}
		System.out.print("Which task do you want to remove? ");
		Scanner sc = new Scanner(System.in);
		String desc = sc.nextLine();
		for (Task task: tdl.getAllTasks()) {
			if (desc == task.getDescription()) {
				tdl.removeTask(desc);
			}
		}
		System.out.println("Your task has been removed from the list!");
	}
	
	private static void setUpCompleteMenu() {
		if (tdl.getAllTasks().isEmpty()) {
			System.out.println("List is empty! Please add a task first.");			
		}
		System.out.print("Which task has been completed? ");
		Scanner sc = new Scanner(System.in);
		String desc = sc.nextLine();
		for (Task task: tdl.getAllTasks()) {
			if (desc == task.getDescription()) {
				tdl.removeTask(desc);
				cl.addTask(task);
			}
		}
		System.out.println("Your task has been added to the completed list!");
	}
	
	private static void setUpCompletedList() {
		// TODO Auto-generated method stub
		System.out.println("Completed Tasks List:");
			if (cl.getAllTasks().isEmpty()) {
				System.out.println("There are no completed tasks!");				
			}
			for (Task task: cl.getAllTasks()) {
				System.out.println(task.getDescription());
			}
	}
	
}
