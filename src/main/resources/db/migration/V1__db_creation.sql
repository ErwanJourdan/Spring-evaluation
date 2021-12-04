
CREATE TABLE collaborator (
	id serial PRIMARY KEY,
	lastname varchar(256) not null,
	firstname varchar(256) not null,
	job varchar(256) not null
);

CREATE TABLE task_list (
	id serial PRIMARY KEY,
	task_list_name varchar(256) not null
);

CREATE TABLE task (
	id serial PRIMARY KEY,
	id_task_list integer not null,
	id_collaborator integer,
	task_name varchar(256) not null,
	description text not null,
	priority varchar (256) not null,
	completed boolean DEFAULT false
);

ALTER TABLE task ADD CONSTRAINT fk_id_task_list FOREIGN KEY (id_task_list) REFERENCES task_list(id);
ALTER TABLE task ADD CONSTRAINT fk_id_collaborator FOREIGN KEY (id_collaborator) REFERENCES collaborator(id);