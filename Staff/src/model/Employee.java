package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "F_NAME")
	private String firstName;
	@Column(name = "L_NAME")
	private String lastName;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "DAYS_EMPLOYED")
	private String daysEmployed;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String title, LocalDate startDate, 
			Team team) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.startDate = startDate;
		this.team = team;
	}

	public Employee(String firstName, String lastName, String title) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.startDate = LocalDate.now();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getDaysEmployed() {
		return daysEmployed;
	}

	public void setDaysEmployed(String daysEmployed) {
		this.daysEmployed = daysEmployed ;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public String getDetail() {
		
		return "Employee ID:" + id + "| Name: " + firstName + " " + lastName + " | Title: " + title
				+ "| Since: " + startDate + " | " + daysEmployed + "| Team: " + team;
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", startDate=" + startDate + ", daysEmployed=" + daysEmployed + ", team=" + team + "]";
	}

}
