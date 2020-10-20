package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEAM_ID")
	private int teamId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LOCATION")
	private String location;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name = "team_employees",
			joinColumns = { @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID")},
			inverseJoinColumns = { @JoinColumn(name = "EMP_ID", referencedColumnName = "ID", unique = true )}
			)
	private List<Employee> listOfEmployees;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int teamId, String name, String location, List<Employee> listOfEmployees) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.location = location;
		this.listOfEmployees = listOfEmployees;
	}

	public Team(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", location=" + location + ", listOfEmployees="
				+ listOfEmployees + "]";
	}

}
