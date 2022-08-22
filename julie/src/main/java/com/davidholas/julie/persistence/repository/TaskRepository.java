package com.davidholas.julie.persistence.repository;

import com.davidholas.julie.persistence.model.Task;
import com.davidholas.julie.persistence.model.enumerations.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPersonId(Long personId);

    List<Task> findAllByOrderByTimeDueAsc();

    List<Task> findAllByTaskTypeAndCompletedAt(TaskType taskType, LocalDateTime completedAt);
}
