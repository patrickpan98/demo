package fr.formation.inti.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUser")
	private int userID;
	
	private String login;
	private String password;
	private int connectionNumber;
	
	@OneToOne
	@JoinColumn(name="emp_id", nullable=false)
	private Employee emp;
	
	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "idUser"),
				inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Role> roles = new ArrayList<Role>();
	
	
	public User() {
		
	}
	
	public User(String login, String password, int connectionNumber) {
		super();
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}
	
	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getConnectionNumber() {
		return connectionNumber;
	}

	public void setConnectionNumber(int connectionNumber) {
		this.connectionNumber = connectionNumber;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", login=" + login + "]";
	}


	
	
}
