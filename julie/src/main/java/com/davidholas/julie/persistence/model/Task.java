package com.davidholas.julie.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_task")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "task_state_id", insertable=false, updatable=false)
    private Long taskStateId;

    @Column(name = "time_due")
    private LocalDateTime timeDue;

    @Column(name = "person_id", insertable=false, updatable=false)
    private Long personId;

    @OneToOne()
    @JoinColumn(name = "task_state_id", referencedColumnName = "id_task_state")
    private TaskState taskState;

    @OneToOne()
    @JoinColumn(name = "person_id", referencedColumnName = "id_person")
    private Person person;
}
