package fr.tse.fise3.info6.kanban.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskType {
	
	private @Id Long id;
	private String label;
	
	public TaskType(Long id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public TaskType() {}
	
	public Long getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskType other = (TaskType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	

}
