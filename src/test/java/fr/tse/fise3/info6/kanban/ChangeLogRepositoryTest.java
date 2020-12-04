package fr.tse.fise3.info6.kanban;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tse.fise3.info6.kanban.dao.ChangeLogRepository;
import fr.tse.fise3.info6.kanban.domain.ChangeLog;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles="test")
public class ChangeLogRepositoryTest {

	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	@Test
	public void testFindAllDevelopers() {
		
		Collection<ChangeLog> changeLogsList = changeLogRepository.findAll();
		
		assertEquals(changeLogsList.size(),3);
		
	}
	
	
}
