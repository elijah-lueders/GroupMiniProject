import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.EmployeeHelper;
import model.Employee;

public class testEmployees {
	static Scanner in = new Scanner(System.in);
	static EmployeeHelper eh = new EmployeeHelper();

	public static void addAnEmployee() {
		System.out.println("First:");
		String firstName = in.nextLine();
		System.out.println("Last:");
		String lastName = in.nextLine();
		System.out.println("Title");
		String title = in.nextLine();

		Employee empToAdd = new Employee(firstName, lastName, title, LocalDate.now());
		System.out.println(empToAdd.toString());
		eh.addEmployee(empToAdd);

	}

	public static void editAnEmployee() {
		List<Employee> foundEmployees = eh.getEmployeeList();
		printList(foundEmployees);
		System.out.print("ID TO EDIT: ");
		int tempId = in.nextInt();
		in.nextLine();
		Employee toEdit = eh.findEmployeeById(tempId);

		System.out.println();
		System.out.println(toEdit.getDetail());
		System.out.println();
		System.out.println("First:");
		String firstNameEdit = in.nextLine();
		if (!firstNameEdit.isEmpty()) {
			toEdit.setFirstName(firstNameEdit);
		}
		System.out.println("Last:");
		String lastNameEdit = in.nextLine();
		if (!lastNameEdit.isEmpty()) {
			toEdit.setLastName(lastNameEdit);
		}
		System.out.println("Title");
		String titleEdit = in.nextLine();
		if (!titleEdit.isEmpty()) {
			toEdit.setTitle(titleEdit);
		}
		eh.editEmployee(toEdit);

	}

	public static void deleteAnEmployee() {
		List<Employee> foundEmployees = eh.getEmployeeList();
		printList(foundEmployees);
		System.out.print("ID TO DEL: ");
		int tempId = in.nextInt();
		Employee toDel = eh.findEmployeeById(tempId);
		eh.deleteEmployee(toDel);
	}

	public static void printList(List<Employee> foundEmployees) {
		if (foundEmployees.isEmpty()) {
			System.err.println(">>>>>>EMPTY SET<<<<<<");
		} else {
			for (Employee employee : foundEmployees) {
				System.out.println(employee.getDetail());
			}
		}

	}

	public static void main(String[] args) {
		boolean goAgain = true;
		System.out.println("< < S T A F F > >\n");
		while (goAgain) {
			System.out.print("OPTIONS |");
			System.out.print(" | 1 - ADD");
			System.out.print(" | 2 - EDIT");
			System.out.print(" | 3 - DEL");
			System.out.print(" | 4 - VIEW");
			System.out.print(" | 5 - EXIT");
			System.out.print(" | >>> ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnEmployee();
			} else if (selection == 2) {
				editAnEmployee();
			} else if (selection == 3) {
				deleteAnEmployee();
			} else if (selection == 4) {
				printList(eh.getEmployeeList());
			} else {
				eh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}

}
