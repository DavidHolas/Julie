package com.davidholas.julie.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task_state")
public class TaskState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskState;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
