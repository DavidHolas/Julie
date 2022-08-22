package com.davidholas.julie.persistence.repository;

import com.davidholas.julie.persistence.model.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStateRepository extends JpaRepository<TaskState, Long> {
}
