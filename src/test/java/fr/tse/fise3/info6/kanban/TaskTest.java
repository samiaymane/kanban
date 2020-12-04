package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.domain.Developer;
import fr.tse.fise3.info6.kanban.domain.Task;
import fr.tse.fise3.info6.kanban.service.DeveloperService;
import fr.tse.fise3.info6.kanban.service.TaskService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class TaskTest {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private DeveloperService developerService;
	
	@Test
	public void testAddDeveloper() {
		Task task1 = this.taskService.findTask(1L);
		Developer developer1 = this.developerService.findDeveloper(1L);
		Developer developer2 = this.developerService.findDeveloper(2L);
		task1.addDeveloper(developer1);
		task1.addDeveloper(developer2);
		assertEquals(task1.getDevelopers().size(),2);
	}
}
