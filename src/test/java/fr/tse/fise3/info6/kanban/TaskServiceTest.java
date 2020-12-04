package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.domain.Task;
import fr.tse.fise3.info6.kanban.service.TaskService;
import fr.tse.fise3.info6.kanban.utils.Constants;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TaskServiceTest 
{
    @Autowired
    private TaskService taskService;
    
    @Test
	public void testFindTaskStatus() {
    	assertNotNull(this.taskService.findTaskStatus(Constants.TODO));
    	assertNotNull(this.taskService.findTaskStatus(Constants.DOING));
    	assertNotNull(this.taskService.findTaskStatus(Constants.DONE));
    }
    
    @Test
	public void testFindTaskType() {		
    	assertNotNull(this.taskService.findTaskType(Constants.BUG));
    	assertNotNull(this.taskService.findTaskType(Constants.UPDATE));
    }
    
    @Test
	public void testFindTask() {		
    	assertNotNull(this.taskService.findTask(1L));
    	assertNotNull(this.taskService.findTask(2L));
    }
    
    @Test
	public void testFindAllTasks() {		
    	assertEquals(this.taskService.findAllTasks().size(),2);
    }
    
    @Test
   	public void testFindAllTaskStatus() {		
       	assertEquals(this.taskService.findAllTaskStatus().size(),3);
    }
    
    @Test
   	public void testFindAllTaskTypes() {		
       	assertEquals(this.taskService.findAllTaskTypes().size(),2);
    }
    
    @Test
    public void testMoveRightTask() {
    	Task task1 = this.taskService.findTask(1L);
    	task1.setStatus( this.taskService.findTaskStatus(Constants.TODO));
    	
    	this.taskService.moveRightTask(task1);
    	assertEquals(task1.getStatus(),this.taskService.findTaskStatus(Constants.DOING));
    	
    	this.taskService.moveRightTask(task1);
    	assertEquals(task1.getStatus(),this.taskService.findTaskStatus(Constants.DONE));
    	
    	this.taskService.moveRightTask(task1);
    	assertEquals(task1.getStatus(),this.taskService.findTaskStatus(Constants.DONE));
    }
    
    @Test
    public void testMoveLeftTask() {
    	Task task2 = this.taskService.findTask(2L);
    	task2.setStatus( this.taskService.findTaskStatus(Constants.DONE));
    	
    	this.taskService.moveLeftTask(task2);
    	assertEquals(task2.getStatus(),this.taskService.findTaskStatus(Constants.DOING));
    	
    	this.taskService.moveLeftTask(task2);
    	assertEquals(task2.getStatus(),this.taskService.findTaskStatus(Constants.TODO));
    	
    	this.taskService.moveLeftTask(task2);
    	assertEquals(task2.getStatus(),this.taskService.findTaskStatus(Constants.TODO));
    }
}
