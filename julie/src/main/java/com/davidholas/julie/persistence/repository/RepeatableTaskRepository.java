package com.davidholas.julie.persistence.repository;

import com.davidholas.julie.persistence.model.RepeatableTask;
import com.davidholas.julie.persistence.model.enumerations.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepeatableTaskRepository extends JpaRepository<RepeatableTask, Long> {

    List<RepeatableTask> findAllByFrequency(TaskType frequency);
}
