package com.davidholas.julie.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.*;

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

    @Column(name = "task_state")
    private String taskState;

    @Column(name = "time_due")
    private LocalDateTime timeDue;

    @Column(name = "personId")
    private Long personId;

    @ManyToMany(mappedBy = "taskList")
    List<Person> personList;
}
