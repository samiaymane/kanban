package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.dao.TaskStatusRepository;
import fr.tse.fise3.info6.kanban.domain.TaskStatus;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class TaskStatusRepositoryTest {
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Test
	public void testFindAllTaskStatus() {
		
		Collection<TaskStatus> taskStatusList = taskStatusRepository.findAll();
		
		assertEquals(taskStatusList.size(),3);
	}

}
