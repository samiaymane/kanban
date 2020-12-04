package fr.tse.fise3.info6.kanban.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import fr.tse.fise3.info6.kanban.dao.ChangeLogRepository;
import fr.tse.fise3.info6.kanban.dao.DeveloperRepository;
import fr.tse.fise3.info6.kanban.dao.TaskRepository;
import fr.tse.fise3.info6.kanban.dao.TaskStatusRepository;
import fr.tse.fise3.info6.kanban.dao.TaskTypeRepository;
import fr.tse.fise3.info6.kanban.domain.ChangeLog;
import fr.tse.fise3.info6.kanban.domain.Developer;
import fr.tse.fise3.info6.kanban.domain.Task;
import fr.tse.fise3.info6.kanban.domain.TaskStatus;
import fr.tse.fise3.info6.kanban.domain.TaskType;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner initTaskStatus(TaskStatusRepository taskStatusRepository) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				
				TaskStatus todo = new TaskStatus(Constants.TODO, "TODO");
				taskStatusRepository.save(todo);
				
				TaskStatus doing = new TaskStatus(Constants.DOING, "DOING");
				taskStatusRepository.save(doing);
				
				TaskStatus done = new TaskStatus(Constants.DONE, "DONE");
				taskStatusRepository.save(done);
			}
		};
	}
	
	@Bean
	CommandLineRunner initTaskType(TaskTypeRepository taskTypeRepository) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				
				TaskType bug = new TaskType(Constants.BUG, "BUG");
				taskTypeRepository.save(bug);
				
				TaskType update = new TaskType(Constants.UPDATE, "UPDATE");
				taskTypeRepository.save(update);
				
			}
		};
	}
	
	@Bean
	@Profile("test")
	CommandLineRunner initTasks(TaskRepository taskRepository) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				
				Task task1 = new Task("Task_1");
				taskRepository.save(task1);
				
				Task task2 = new Task("Task_2");
				taskRepository.save(task2);
			}
		};
	}
	
	@Bean
	@Profile("test")
	CommandLineRunner initDevelopers(DeveloperRepository developerRepository) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				
				Developer developer1 = new Developer();
				developerRepository.save(developer1);
				
				Developer developer2 = new Developer();
				developerRepository.save(developer2);
			}
		};
	}
	
	@Bean
	@Profile("test")
	CommandLineRunner initChangeLogs(ChangeLogRepository changeLogRepository) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				
				ChangeLog changeLog1 = new ChangeLog();
				changeLogRepository.save(changeLog1);
				
				ChangeLog changeLog2 = new ChangeLog();
				changeLogRepository.save(changeLog2);
				
				ChangeLog changeLog3 = new ChangeLog();
				changeLogRepository.save(changeLog3);
			}
		};
	}
	
}
