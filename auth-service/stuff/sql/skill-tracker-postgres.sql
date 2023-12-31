-- Database: skill_tracker_db

-- DROP DATABASE IF EXISTS skill_tracker_db;

CREATE DATABASE skill_tracker_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_India.1252'
    LC_CTYPE = 'English_India.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE skill_tracker_db
    IS 'Skill Tracker Database';

-- SCHEMA: skilltracker

-- DROP SCHEMA IF EXISTS skilltracker ;

CREATE SCHEMA IF NOT EXISTS skilltracker
    AUTHORIZATION postgres;

COMMENT ON SCHEMA skilltracker
    IS 'skilltracker schema';

GRANT ALL ON SCHEMA public TO postgres;


CREATE TABLE skilltracker.user_info (
                                        user_info_id INT8 NOT NULL,
                                        user_name VARCHAR(30) NOT NULL,
                                        password VARCHAR(500) NOT NULL,
                                        user_first_name VARCHAR(100) NOT NULL,
                                        user_last_name VARCHAR(100) NOT NULL,
                                        user_email VARCHAR(150) NOT NULL,
                                        user_role VARCHAR(25) NOT NULL DEFAULT 'FSE',
                                        token VARCHAR(500) NULL,
                                        created_date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
                                        updated_date TIMESTAMP NULL,
                                        CONSTRAINT "primary" PRIMARY KEY (user_info_id)
);

CREATE SEQUENCE skilltracker.user_info_id_seq START 10000 INCREMENT 1;

CREATE TABLE skilltracker.skills
(
    skill_id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    skill_name      VARCHAR(100)          NOT NULL,
    skill_type      VARCHAR(45)          NOT NULL,
    expertise_level INT                   NULL,
    profile_ref_id  BIGINT                NULL,
    CONSTRAINT pk_skills PRIMARY KEY (skill_id)
);

CREATE TABLE skilltracker.profiles
(
    profile_id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    profile_name      VARCHAR(100)         NOT NULL,
    associate_id      VARCHAR(30)          NOT NULL,
    mobile            VARCHAR(10)          NOT NULL,
    email             VARCHAR(100)         NOT NULL,
    last_updated_time TIMESTAMP              NULL,
    CONSTRAINT pk_profiles PRIMARY KEY (profile_id)
);

ALTER TABLE skilltracker.profiles
    ADD CONSTRAINT uc_profiles_associate UNIQUE (associate_id);
