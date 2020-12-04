package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.dao.TaskRepository;
import fr.tse.fise3.info6.kanban.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class TaskRepositoryTest {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Test
	public void testFindAllTasks() {
		
		Collection<Task> tasksList = taskRepository.findAll();
		
		assertEquals(tasksList.size(),2);
	}

}
