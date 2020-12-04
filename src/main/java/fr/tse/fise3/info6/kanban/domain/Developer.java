package fr.tse.fise3.info6.kanban.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Developer {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String email;
	
	private LocalDate startContrat;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Task> tasks;
	
	public Developer() {
		this.tasks = new HashSet<Task>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getStartContrat() {
		return startContrat;
	}

	public void setStartContrat(LocalDate startContrat) {
		this.startContrat = startContrat;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
}
