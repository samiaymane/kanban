package fr.tse.fise3.info6.kanban.service.imp;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.tse.fise3.info6.kanban.dao.TaskRepository;
import fr.tse.fise3.info6.kanban.dao.TaskStatusRepository;
import fr.tse.fise3.info6.kanban.dao.TaskTypeRepository;
import fr.tse.fise3.info6.kanban.dao.ChangeLogRepository;
import fr.tse.fise3.info6.kanban.domain.ChangeLog;
import fr.tse.fise3.info6.kanban.domain.Task;
import fr.tse.fise3.info6.kanban.domain.TaskStatus;
import fr.tse.fise3.info6.kanban.domain.TaskType;
import fr.tse.fise3.info6.kanban.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private ChangeLogRepository ChangeLogRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Task> findAllTasks() {
		return this.taskRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<TaskStatus> findAllTaskStatus() {
		return this.taskStatusRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<TaskType> findAllTaskTypes() {
		return this.taskTypeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Task findTask(Long id) {
		return this.taskRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public TaskStatus findTaskStatus(Long id) {
		 return this.taskStatusRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public TaskType findTaskType(Long id) {
		return this.taskTypeRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = false)
	public Task moveRightTask(Task task) {
		TaskStatus sourceStatus = task.getStatus();
		if(sourceStatus != null) {
			TaskStatus targetStatus = taskStatusRepository.findById(sourceStatus.getId()+1).orElse(null);
			if(targetStatus != null) {
				ChangeLog changeLog = new ChangeLog();
				changeLog.setTask(task);
				changeLog.setSourceStatus(sourceStatus);
				changeLog.setTargetStatus(targetStatus);
				changeLog.setOccured(LocalDate.now());
				ChangeLogRepository.save(changeLog);
				task.setStatus(targetStatus);
			}
		}
		return task;
	}

	@Override
	@Transactional(readOnly = true)
	public Task moveLeftTask(Task task) {
		TaskStatus sourceStatus = task.getStatus();
		if(sourceStatus != null) {
			TaskStatus targetStatus = taskStatusRepository.findById(sourceStatus.getId()-1).orElse(null);
			if(targetStatus != null) {
				ChangeLog changeLog = new ChangeLog();
				changeLog.setTask(task);
				changeLog.setSourceStatus(sourceStatus);
				changeLog.setTargetStatus(targetStatus);
				changeLog.setOccured(LocalDate.now());
				ChangeLogRepository.save(changeLog);
				task.setStatus(targetStatus);
			}
		}
		return task;
	}


}
