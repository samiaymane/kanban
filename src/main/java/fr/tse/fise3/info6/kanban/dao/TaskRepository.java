package fr.tse.fise3.info6.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.fise3.info6.kanban.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
