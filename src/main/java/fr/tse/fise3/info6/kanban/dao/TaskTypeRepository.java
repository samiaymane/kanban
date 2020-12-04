package fr.tse.fise3.info6.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.tse.fise3.info6.kanban.domain.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long>{

}
