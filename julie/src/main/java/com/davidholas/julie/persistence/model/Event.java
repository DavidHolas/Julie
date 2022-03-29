package com.davidholas.julie.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "time")
    private String time;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
