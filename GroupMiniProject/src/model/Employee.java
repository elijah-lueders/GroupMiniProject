package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Date startDate;
	@Column(name = "DAYS_EMPLOYED")
	private int daysEmployed;
	//TODO join column 
	private Team team;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String title, Date startDate, int daysEmployed,
			Team team) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.startDate = startDate;
		this.daysEmployed = daysEmployed;
		this.team = team;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDaysEmployed() {
		return daysEmployed;
	}

	public void setDaysEmployed(int daysEmployed) {
		this.daysEmployed = daysEmployed;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", startDate=" + startDate + ", daysEmployed=" + daysEmployed + ", team=" + team + "]";
	}

}
