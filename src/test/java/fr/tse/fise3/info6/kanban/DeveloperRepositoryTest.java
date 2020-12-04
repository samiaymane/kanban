package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.dao.DeveloperRepository;
import fr.tse.fise3.info6.kanban.domain.Developer;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class DeveloperRepositoryTest {

	@Autowired
	private DeveloperRepository developerRepository;
	
	@Test
	public void testFindAllDevelopers() {
		
		Collection<Developer> developersList = developerRepository.findAll();
		
		assertEquals(developersList.size(),2);
		
	}
	
}
