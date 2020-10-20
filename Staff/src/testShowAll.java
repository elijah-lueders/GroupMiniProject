import java.util.List;

import controller.EmployeeHelper;
import controller.TeamHelper;
import model.Employee;
import model.Team;

public class testShowAll {
public static void main(String[] args) {
	EmployeeHelper eh = new EmployeeHelper();
	List<Employee> eList = eh.getEmployeeList();
	for (Employee employee : eList) {
		System.out.println(employee.toString());
	}
	System.out.println();
	System.out.println("+++++++++++++++++++++++++++++++++");
	System.out.println();
	TeamHelper th = new TeamHelper();
	List<Team> tList = th.getTeamList();
	for (Team team : tList) {
		System.out.println(team.toString());
	}
}
}
