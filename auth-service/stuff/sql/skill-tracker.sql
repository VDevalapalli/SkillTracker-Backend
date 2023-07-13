--create database skill_tracker;
--CREATE ROLE skill_tracker_app WITH login password 'skilltrackerapp';
--GRANT ALL ON DATABASE skill_tracker TO skill_tracker_app;
--GRANT ALL ON TABLE public.* TO skill_tracker_app;
--CREATE SEQUENCE hibernate_sequence START 1;

CREATE SCHEMA skilltracker AUTHORIZATION postgres;

--drop table public.skill
CREATE TABLE public.skill (
  skill_id int8 NOT NULL,
  skill_name varchar(100) NOT NULL,
  skill_type varchar(45) DEFAULT NULL,
  created_date timestamp,
  PRIMARY KEY (skill_id)
) ;

INSERT INTO skill_tracker.skill
(skill_id, skill_name, skill_type, created_date)
values
(1, 'HTML-CSS-JAVASCRIPT','Technical', current_timestamp()),
(2, 'ANGULAR','Technical', current_timestamp()),
(3, 'REACT','Technical', current_timestamp()),
(4, 'SPRING','Technical', current_timestamp()),
(5, 'RESTFUL','Technical', current_timestamp()),
(6, 'HIBERNATE','Technical', current_timestamp()),
(7, 'GIT', 'Technical', current_timestamp()),
(8, 'DOCKER', 'Technical', current_timestamp()),
(10, 'JENKINS', 'Technical', current_timestamp()),
(11, 'AWS', 'Technical', current_timestamp()),
(12, 'SPOKEN', 'Non-Technical', current_timestamp()),
(13, 'COMMUNICATION', 'Non-Technical', current_timestamp()),
(14, 'APTITUDE', 'Non-Technical', current_timestamp());


-- Drop table

-- DROP TABLE public.profile;

/*
CREATE TABLE public.profile (
	profile_id INT8 NOT NULL,
	associate_id VARCHAR(30) NOT NULL,
	name VARCHAR(50) NOT NULL,
	mobile INT8 NULL DEFAULT 0:::INT8,
	email VARCHAR(50) NOT NULL,
	skill_payload JSONB NULL,
	created_date TIMESTAMP NOT NULL,
	updated_date TIMESTAMP NULL,
	CONSTRAINT "primary" PRIMARY KEY (profile_id ASC),
	UNIQUE INDEX profile_associate_id_key (associate_id ASC),
	INVERTED INDEX jsonb_inv_idx (skill_payload),
	FAMILY "primary" (profile_id, associate_id, name, mobile, email, created_date, updated_date, skill_payload)
);
*/

CREATE TABLE public.profile (
	profile_id INT8 NOT NULL,
	associate_id VARCHAR(30) NOT NULL,
	name VARCHAR(50) NOT NULL,
	mobile INT8 NULL DEFAULT 0:::INT8,
	email VARCHAR(50) NOT NULL,
	created_date TIMESTAMP NOT NULL,
	updated_date TIMESTAMP NULL,
	CONSTRAINT "primary" PRIMARY KEY (profile_id ASC),
	UNIQUE INDEX profile_associate_id_key (associate_id ASC),
	FAMILY "primary" (profile_id, associate_id, name, mobile, email, created_date, updated_date)
);

-- DROP TABLE public.profile_skill;
CREATE TABLE profile_skill (
  profile_skill_id int NOT NULL,
  profile_id int NOT NULL,
  skill_id int NOT NULL,
  expertise_level int not null,
  status varchar(5) not null,
  created_date TIMESTAMP NOT NULL,
  updated_date TIMESTAMP NULL,
  PRIMARY KEY (profile_skill_id),
  CONSTRAINT FOREIGN_KEY_PROFILE FOREIGN KEY (profile_id) REFERENCES skill_tracker.profile (profile_id),
  CONSTRAINT FOREIGN_KEY_SKILL FOREIGN KEY (skill_id) REFERENCES skill_tracker.skill (skill_id)
) ;


CREATE ROLE skill_tracker_app WITH login password skilltrackerapp;
ALTER ROLE skill_tracker_app WITH login;

alter table profile INVERTED INDEX jsonb_inv_idx (skill_payload);

--drop table public.user_info
CREATE TABLE public.user_info (
	user_info_id INT8 NOT NULL,
	user_name VARCHAR(30) NOT NULL,
	password VARCHAR(500) NOT NULL,
	user_email varchar(150) not null,
	user_role varchar(25) NOT NULL DEFAULT 'FSE',
	token varchar(500) null,
	created_date TIMESTAMP not null default current_timestamp(),
	updated_date TIMESTAMP NULL,
	CONSTRAINT "primary" PRIMARY KEY (user_info_id ASC)
);


CREATE TABLE public.profile_events (
	profile_event_id INT8 NOT NULL,
	profile_event_type VARCHAR(30) NOT NULL,
	profile_payload JSONB NULL,
	created_date TIMESTAMP not null default current_timestamp(),
	created_by VARCHAR(30) NOT NULL,
	CONSTRAINT "primary" PRIMARY KEY (profile_event_id ASC),
	INVERTED INDEX jsonb_inv_idx (profile_payload)
);

select * from user_info ui
delete from user_info ui2
CREATE SEQUENCE public.user_info_id_seq START 10000 INCREMENT 1;

show create user_info_id_seq;
