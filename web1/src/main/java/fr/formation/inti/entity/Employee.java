package fr.formation.inti.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private int empID;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "dept_id", nullable = false)
//	private Department dept;
	
	
	@ManyToOne()
	@JoinColumn(name = "superior_emp_id")
	private Employee manager;
	
	@OneToMany(mappedBy = "manager", targetEntity = Employee.class)
	private List<Employee> sub = new ArrayList<Employee>();
	
	
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, Date startDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
	}
	
	
	
	public List<Employee> getSub() {
		return sub;
	}

	public void setSub(List<Employee> sub) {
		this.sub = sub;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

//	public Department getDept() {
//		return dept;
//	}
//
//	public void setDept(Department dept) {
//		this.dept = dept;
//	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + ", startDate="
				+ startDate + "]";
	}
	
	
}
