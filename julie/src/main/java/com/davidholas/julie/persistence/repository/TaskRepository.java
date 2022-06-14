package com.davidholas.julie.persistence.repository;

import com.davidholas.julie.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("update Task t set completed = true where t.id = ?1")
    void completeTask(Long taskId);
}
