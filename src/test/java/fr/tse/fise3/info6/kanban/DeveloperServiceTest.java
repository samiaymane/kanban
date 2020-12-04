package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.service.DeveloperService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class DeveloperServiceTest {

	@Autowired
	private DeveloperService developerService;
	
	@Test
	public void testfindDeveloper() {
		assertNotNull(this.developerService.findDeveloper(1L));
	}
	
	@Test
	public void testfindAllDevelopers() {
		assertEquals(this.developerService.findAllDevelopers().size(),2);
	}
}
