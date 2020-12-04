package fr.tse.fise3.info6.kanban.service;

import java.util.List;

import fr.tse.fise3.info6.kanban.domain.Developer;

public interface DeveloperService {

	public List<Developer> findAllDevelopers();
	public Developer findDeveloper(Long id);
}
