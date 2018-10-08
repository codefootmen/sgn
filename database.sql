-- ****************** SGN DATABASE *******************;
-- ***************************************************;

DROP TABLE IF EXISTS `course`;

DROP TABLE IF EXISTS `subject`;

DROP TABLE IF EXISTS `request`;

DROP TABLE IF EXISTS `activity`;

DROP TABLE IF EXISTS `meeting`;

DROP TABLE IF EXISTS `program`;

DROP TABLE IF EXISTS `department`;

DROP TABLE IF EXISTS `event`;

DROP TABLE IF EXISTS `room`;

DROP TABLE IF EXISTS `building`;

DROP TABLE IF EXISTS `period`;

DROP TABLE IF EXISTS `student`;

DROP TABLE IF EXISTS `professor`;

DROP TABLE IF EXISTS `campus`;

DROP TABLE IF EXISTS `institution`;

DROP TABLE IF EXISTS `room_type`;

-- ************************************** `room_type`

CREATE TABLE `room_type`
(
  `id_room_type` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(255)    NOT NULL,
  `description`  VARCHAR(255)    NOT NULL,

  PRIMARY KEY (`id_room_type`)
);

-- ************************************** `student`

CREATE TABLE `student`
(
  `id_student` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255)    NOT NULL,
  `last_name`  VARCHAR(255)    NOT NULL,
  `email`      VARCHAR(255)    NOT NULL,

  PRIMARY KEY (`id_student`)
);

-- ************************************** `professor`

CREATE TABLE `professor`
(
  `id_professor` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `first_name`   VARCHAR(255)    NOT NULL,
  `last_name`    VARCHAR(255)    NOT NULL,
  `email`        VARCHAR(255)    NOT NULL,
  `status`       ENUM ('normal') NOT NULL,
  `honorifics`   ENUM ('dr')     NOT NULL,

  PRIMARY KEY (`id_professor`)
);

-- ************************************** `institution`

CREATE TABLE `institution`
(
  `id_institution` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(255)    NOT NULL,
  `logo`           VARCHAR(255)    NOT NULL,
  `site`           VARCHAR(255)    NOT NULL,

  PRIMARY KEY (`id_institution`)
);

-- ************************************** `campus`

CREATE TABLE `campus`
(
  `id_campus`      BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(255)    NOT NULL,
  `street`         VARCHAR(255)    NOT NULL,
  `number`         BIGINT unsigned NOT NULL,
  `city`           VARCHAR(255)    NOT NULL,
  `state`          VARCHAR(255)    NOT NULL,
  `telephone`      VARCHAR(255)    NOT NULL,
  `zip`            VARCHAR(255)    NOT NULL,
  `id_institution` BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_campus`, `id_institution`),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution)
);

-- ************************************** `building`

CREATE TABLE `building`
(
  `id_building`           BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`                  VARCHAR(255)    NOT NULL,
  `quantity_of_bathrooms` INTEGER         NOT NULL,
  `elevator`              BIT             NOT NULL,
  `accessibility`         BIT             NOT NULL,
  `id_campus`             BIGINT unsigned NOT NULL,
  `id_institution`        BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_building`),
  FOREIGN KEY (`id_campus`) REFERENCES campus (id_campus),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution)
);

-- ************************************** `department`

CREATE TABLE `department`
(
  `id_department`  BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `field`          VARCHAR(255)    NOT NULL,
  `description`    VARCHAR(255)    NOT NULL,
  `id_campus`      BIGINT unsigned NOT NULL,
  `id_institution` BIGINT unsigned NOT NULL,
  `id_professor`   BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_department`, `id_campus`, `id_institution`),
  FOREIGN KEY (`id_campus`) REFERENCES campus (id_campus),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution),
  FOREIGN KEY (`id_professor`) REFERENCES professor (id_professor)
);

-- ************************************** `meeting`

CREATE TABLE `meeting`
(
  `id_meeting`     BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `day`            VARCHAR(255)    NOT NULL,
  `time`           VARCHAR(255)    NOT NULL,
  `agenda`         VARCHAR(255)    NOT NULL,
  `minutes`        VARCHAR(255)    NOT NULL,
  `id_department`  BIGINT unsigned NOT NULL,
  `id_campus`      BIGINT unsigned NOT NULL,
  `id_institution` BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_meeting`),
  FOREIGN KEY (`id_department`) REFERENCES department (id_department),
  FOREIGN KEY (`id_campus`) REFERENCES campus (id_campus),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution)
);

-- ************************************** `room`

CREATE TABLE `room`
(
  `id_room`           BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `number`            INTEGER         NOT NULL,
  `quantity_of_seats` INTEGER         NOT NULL,
  `id_room_type`      BIGINT unsigned NOT NULL,
  `id_building`       BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_room`),
  FOREIGN KEY (`id_room_type`) REFERENCES room_type (id_room_type),
  FOREIGN KEY (`id_building`) REFERENCES building (id_building)
);

-- ************************************** `period`

CREATE TABLE `period`
(
  `id_period`       BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `start`           VARCHAR(255)    NOT NULL,
  `end`             VARCHAR(255)    NOT NULL,
  `day_of_the_week` VARCHAR(255)    NOT NULL,
  `id_room`         BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_period`),
  FOREIGN KEY (`id_room`) REFERENCES room (`id_room`)
);

-- ************************************** `event`

CREATE TABLE `event`
(
  `id_event`     BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(255)    NOT NULL,
  `date`         DATE            NOT NULL,
  `id_period`    BIGINT unsigned NOT NULL,
  `id_professor` BIGINT unsigned NOT NULL,
  `id_room`      BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_event`),
  FOREIGN KEY (`id_period`) REFERENCES period (id_period),
  FOREIGN KEY (`id_professor`) REFERENCES professor (id_professor),
  FOREIGN KEY (`id_room`) REFERENCES room (id_room)
);

-- ************************************** `program`

CREATE TABLE `program`
(
  `id_program`     BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(255)    NOT NULL,
  `id_department`  BIGINT unsigned NOT NULL,
  `id_campus`      BIGINT unsigned NOT NULL,
  `id_institution` BIGINT unsigned NOT NULL,
  `academic_level` ENUM ('')       NOT NULL,

  PRIMARY KEY (`id_program`, `id_department`, `id_campus`, `id_institution`),
  KEY `fkIdx_120` (`id_department`, `id_campus`, `id_institution`),
  CONSTRAINT `FK_120` FOREIGN KEY `fkIdx_120` (`id_department`, `id_campus`, `id_institution`) REFERENCES `department` (`id_department`, `id_campus`, `id_institution`)
);

-- ************************************** `subject`

CREATE TABLE `subject`
(
  `id_subject`          BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `name`                VARCHAR(255)    NOT NULL,
  `quantity_of_credits` INTEGER         NOT NULL,
  `id_room_type`        BIGINT unsigned NOT NULL,
  `id_program`          BIGINT unsigned NOT NULL,
  `id_department`       BIGINT unsigned NOT NULL,
  `id_campus`           BIGINT unsigned NOT NULL,
  `id_institution`      BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_subject`, `id_program`, `id_department`, `id_campus`, `id_institution`),
  FOREIGN KEY (`id_room_type`) REFERENCES room_type (id_room_type),
  FOREIGN KEY (`id_program`) REFERENCES program (id_program),
  FOREIGN KEY (`id_department`) REFERENCES department (id_department),
  FOREIGN KEY (`id_campus`) REFERENCES campus (id_campus),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution)
);

-- ************************************** `request`

CREATE TABLE `request`
(
  `id_request`  BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `motive`      VARCHAR(255)    NOT NULL,
  `description` VARCHAR(255)    NOT NULL,
  `id_room`     BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_request`),
  KEY `fkIdx_154` (`id_room`),
  CONSTRAINT `FK_154` FOREIGN KEY `fkIdx_154` (`id_room`) REFERENCES `room` (`id_room`)
);

-- ************************************** `activity`

CREATE TABLE `activity`
(
  `id_activity`    BIGINT unsigned            NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(255)               NOT NULL,
  `activity_type`  ENUM ('research',
                         'education',
                         'extension_service') NOT NULL,
  `area`           VARCHAR(255)               NOT NULL,
  `id_professor`   BIGINT unsigned            NOT NULL,
  `id_campus`      BIGINT unsigned            NOT NULL,
  `id_department`  BIGINT unsigned            NOT NULL,
  `id_institution` BIGINT unsigned            NOT NULL,
  `id_program`     BIGINT unsigned            NOT NULL,

  PRIMARY KEY (`id_activity`),
  FOREIGN KEY (`id_professor`) REFERENCES professor (id_professor),
  FOREIGN KEY (`id_department`) REFERENCES department (id_department),
  FOREIGN KEY (`id_campus`) REFERENCES campus (id_campus),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution),
  FOREIGN KEY (`id_program`) REFERENCES program (id_program)
);

-- ************************************** `course`

CREATE TABLE `course`
(
  `id_course`      BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `semester`       BIT             NOT NULL,
  `year`           INTEGER         NOT NULL,
  `id_subject`     BIGINT unsigned NOT NULL,
  `id_program`     BIGINT unsigned NOT NULL,
  `id_department`  BIGINT unsigned NOT NULL,
  `id_campus`      BIGINT unsigned NOT NULL,
  `id_institution` BIGINT unsigned NOT NULL,
  `id_period`      BIGINT unsigned NOT NULL,
  `id_professor`   BIGINT unsigned NOT NULL,

  PRIMARY KEY (`id_course`, `id_subject`, `id_program`, `id_department`, `id_campus`, `id_institution`),
  FOREIGN KEY (`id_subject`) REFERENCES subject (id_subject),
  FOREIGN KEY (`id_program`) REFERENCES program (id_program),
  FOREIGN KEY (`id_department`) REFERENCES department (id_department),
  FOREIGN KEY (`id_campus`) REFERENCES campus (id_campus),
  FOREIGN KEY (`id_institution`) REFERENCES institution (id_institution),
  FOREIGN KEY (`id_period`) REFERENCES period (id_period),
  FOREIGN KEY (`id_professor`) REFERENCES professor (id_professor)
);





