package com.davidholas.julie.persistence.model;

import com.davidholas.julie.persistence.model.enumerations.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@Data
@Entity
public class RepeatableTask {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_repeatable_task")
    private Long id;

    private String title;

    private String description;

    private LocalDateTime timeDue;

    private Long taskStateId;

    private Long personId;

    @Enumerated(STRING)
    private TaskType frequency;
}
