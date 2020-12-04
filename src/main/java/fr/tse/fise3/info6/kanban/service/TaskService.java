package fr.tse.fise3.info6.kanban.service;

import java.util.Collection;

import fr.tse.fise3.info6.kanban.domain.Task;
import fr.tse.fise3.info6.kanban.domain.TaskStatus;
import fr.tse.fise3.info6.kanban.domain.TaskType;

public interface TaskService {
	
	public Collection<Task> findAllTasks();
	public Collection<TaskStatus> findAllTaskStatus();
	public Collection<TaskType> findAllTaskTypes();
	
	public Task findTask(Long id);
	public TaskStatus findTaskStatus(Long id);
	public TaskType findTaskType(Long id);
	
	public Task moveRightTask(Task task);
	public Task moveLeftTask(Task task);

}
