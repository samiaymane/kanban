package fr.tse.fise3.info6.kanban.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChangeLog {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private LocalDate occured;
	
	@ManyToOne
	private Task task;
	
	@ManyToOne
	private TaskStatus sourceStatus;
	
	@ManyToOne
	private TaskStatus targetStatus;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public ChangeLog(Long id, LocalDate occured) {
		this.id = id;
		this.occured = occured;
	}
	
	public ChangeLog() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOccured() {
		return occured;
	}

	public void setOccured(LocalDate occured) {
		this.occured = occured;
	}
	
	public void setSourceStatus(TaskStatus sourceStatus) {
		this.sourceStatus = sourceStatus;
	}
	
	public void setTargetStatus(TaskStatus targetStatus) {
		this.targetStatus = targetStatus;
	}
}
