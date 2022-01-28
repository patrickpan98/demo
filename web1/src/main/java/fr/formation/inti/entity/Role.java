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
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private int roleID;
	
	@Column(name = "role_name")
	private String roleName;
	
	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "id_role"),
				inverseJoinColumns = @JoinColumn(name = "idUser"))
	private List<User> users = new ArrayList<User>();
	
	
	public Role() {
		
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + "]";
	}
	
	
	
}
