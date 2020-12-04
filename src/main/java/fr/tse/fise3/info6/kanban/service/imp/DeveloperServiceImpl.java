package fr.tse.fise3.info6.kanban.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tse.fise3.info6.kanban.dao.DeveloperRepository;
import fr.tse.fise3.info6.kanban.domain.Developer;
import fr.tse.fise3.info6.kanban.service.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	private DeveloperRepository developerRepository;
	
	@Override
	public List<Developer> findAllDevelopers() {
		return this.developerRepository.findAll();
	}

	@Override
	public Developer findDeveloper(Long id) {
		return this.developerRepository.findById(id).orElse(null);
	}

}
