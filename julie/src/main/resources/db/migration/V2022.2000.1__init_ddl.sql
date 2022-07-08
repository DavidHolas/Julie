CREATE TABLE person (
    id_person bigserial NOT NULL
        CONSTRAINT person_pkey PRIMARY KEY,
    first_name varchar(30),
    last_name varchar(30),
    gender char,
    birthdate date
);

CREATE TABLE task (
    id_task bigserial NOT NULL
        CONSTRAINT task_pkey PRIMARY KEY,
    title varchar(60),
    description varchar(255),
    task_state_id bigint,
    person_id bigint,
    time_due timestamp
);

CREATE TABLE task_state (
    id_task_state bigserial NOT NULL
        CONSTRAINT task_state_pkey PRIMARY KEY,
    code varchar(3),
    name varchar(20)
);

CREATE TABLE event (
	id_event bigserial NOT NULL
        CONSTRAINT event_pkey PRIMARY KEY,
	category varchar(60),
	time timestamp,
	title varchar(60),
	description varchar(255)
);