package fr.formation.inti.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int deptID;
	private String name;
	
	/**
	 * mappedBy => attribut de la classe
	 * targetEntity => optionnel
	 * fetch = FetchType.EAGER (chargement direct) ou LAZY (par défaut, chargement à la demande)
	 */
//	@OneToMany(mappedBy = "dept", targetEntity = Employee.class)
//	private List<Employee> employees = new ArrayList<Employee>();
	
	
	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}
	
	
	
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}

	public int getDeptID() {
		return deptID;
	}
	
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Department [dept_id=" + deptID + ", name=" + name + "]";
	}
	
	
	
	
}
