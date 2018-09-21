-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;

DROP TABLE `course`;


DROP TABLE `subject`;


DROP TABLE `request`;


DROP TABLE `activity`;


DROP TABLE `meeting`;


DROP TABLE `room`;


DROP TABLE `program`;


DROP TABLE `building`;


DROP TABLE `department`;


DROP TABLE `event`;


DROP TABLE `campus`;


DROP TABLE `period`;


DROP TABLE `student`;


DROP TABLE `professor`;


DROP TABLE `institution`;



-- ************************************** `period`

CREATE TABLE `period`
(
 `id_period`    BIGINT unsigned NOT NULL ,
 `start`        VARCHAR(255) NOT NULL ,
 `end`          VARCHAR(255) NOT NULL ,
 `dayOfTheWeek` VARCHAR(255) NOT NULL ,

PRIMARY KEY (`id_period`)
);






-- ************************************** `student`

CREATE TABLE `student`
(
 `enrollment` BIGINT unsigned NOT NULL ,
 `first_name` VARCHAR(255) NOT NULL ,
 `last_name`  VARCHAR(255) NOT NULL ,
 `email`      VARCHAR(255) NOT NULL ,

PRIMARY KEY (`enrollment`)
);






-- ************************************** `professor`

CREATE TABLE `professor`
(
 `siape`      BIGINT unsigned NOT NULL ,
 `first_name` VARCHAR(255) NOT NULL ,
 `last_name`  VARCHAR(255) NOT NULL ,
 `email`      VARCHAR(255) NOT NULL ,
 `status`     ENUM('') NOT NULL ,
 `honorifics` ENUM('') NOT NULL ,

PRIMARY KEY (`siape`)
);






-- ************************************** `institution`

CREATE TABLE `institution`
(
 `cnpj` BIGINT unsigned NOT NULL ,
 `name` VARCHAR(255) NOT NULL ,
 `logo` VARCHAR(255) NOT NULL ,
 `site` VARCHAR(255) NOT NULL ,

PRIMARY KEY (`cnpj`)
);






-- ************************************** `event`

CREATE TABLE `event`
(
 `id_event` BIGINT unsigned NOT NULL ,
 `name`     VARCHAR(255) NOT NULL ,
 `siape`    BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_event`),
KEY `fkIdx_173` (`siape`),
CONSTRAINT `FK_173` FOREIGN KEY `fkIdx_173` (`siape`) REFERENCES `professor` (id_professor)
);






-- ************************************** `campus`

CREATE TABLE `campus`
(
 `id_campus` BIGINT unsigned NOT NULL ,
 `name`      VARCHAR(255) NOT NULL ,
 `street`    VARCHAR(255) NOT NULL ,
 `number`    BIGINT unsigned NOT NULL ,
 `city`      VARCHAR(255) NOT NULL ,
 `state`     VARCHAR(255) NOT NULL ,
 `telephone` VARCHAR(255) NOT NULL ,
 `zip`       VARCHAR(255) NOT NULL ,
 `cnpj`      BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_campus`, `cnpj`),
KEY `fkIdx_32` (`cnpj`),
CONSTRAINT `FK_32` FOREIGN KEY `fkIdx_32` (`cnpj`) REFERENCES `institution` (id_institution)
);






-- ************************************** `building`

CREATE TABLE `building`
(
 `id_building`           BIGINT unsigned NOT NULL ,
 `name`                  VARCHAR(255) NOT NULL ,
 `quantity_of_bathrooms` INTEGER NOT NULL ,
 `elevator`              BIT NOT NULL ,
 `accessibility`         BIT NOT NULL ,
 `id_campus`             BIGINT unsigned NOT NULL ,
 `cnpj`                  BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_building`),
KEY `fkIdx_106` (`id_campus`, `cnpj`),
CONSTRAINT `FK_106` FOREIGN KEY `fkIdx_106` (`id_campus`, `cnpj`) REFERENCES `campus` (`id_campus`, `cnpj`)
);






-- ************************************** `department`

CREATE TABLE `department`
(
 `id_department` BIGINT unsigned NOT NULL ,
 `field`         VARCHAR(255) NOT NULL ,
 `description`   VARCHAR(255) NOT NULL ,
 `id_campus`     BIGINT unsigned NOT NULL ,
 `cnpj`          BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_102` (`id_campus`, `cnpj`),
CONSTRAINT `FK_102` FOREIGN KEY `fkIdx_102` (`id_campus`, `cnpj`) REFERENCES `campus` (`id_campus`, `cnpj`)
);






-- ************************************** `meeting`

CREATE TABLE `meeting`
(
 `id_meeting`    BIGINT unsigned NOT NULL ,
 `day`           VARCHAR(255) NOT NULL ,
 `time`          VARCHAR(255) NOT NULL ,
 `agenda`        VARCHAR(255) NOT NULL ,
 `minutes`       VARCHAR(255) NOT NULL ,
 `id_department` BIGINT unsigned NOT NULL ,
 `id_campus`     BIGINT unsigned NOT NULL ,
 `cnpj`          BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_meeting`),
KEY `fkIdx_115` (`id_department`, `id_campus`, `cnpj`),
CONSTRAINT `FK_115` FOREIGN KEY `fkIdx_115` (`id_department`, `id_campus`, `cnpj`) REFERENCES `department` (`id_department`, `id_campus`, `cnpj`)
);






-- ************************************** `room`

CREATE TABLE `room`
(
 `id_room`           BIGINT unsigned NOT NULL ,
 `number`            INTEGER NOT NULL ,
 `quantity_of_seats` INTEGER NOT NULL ,
 `room_type`         ENUM('') NOT NULL ,
 `id_building`       BIGINT unsigned NOT NULL ,
 `id_period`         BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_room`),
KEY `fkIdx_151` (`id_building`),
CONSTRAINT `FK_151` FOREIGN KEY `fkIdx_151` (`id_building`) REFERENCES `building` (`id_building`),
KEY `fkIdx_161` (`id_period`),
CONSTRAINT `FK_161` FOREIGN KEY `fkIdx_161` (`id_period`) REFERENCES `period` (`id_period`)
);






-- ************************************** `program`

CREATE TABLE `program`
(
 `id_program`     BIGINT unsigned NOT NULL ,
 `name`           VARCHAR(255) NOT NULL ,
 `id_department`  BIGINT unsigned NOT NULL ,
 `id_campus`      BIGINT unsigned NOT NULL ,
 `cnpj`           BIGINT unsigned NOT NULL ,
 `academic_level` ENUM('') NOT NULL ,

PRIMARY KEY (`id_program`, `id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_120` (`id_department`, `id_campus`, `cnpj`),
CONSTRAINT `FK_120` FOREIGN KEY `fkIdx_120` (`id_department`, `id_campus`, `cnpj`) REFERENCES `department` (`id_department`, `id_campus`, `cnpj`)
);






-- ************************************** `subject`

CREATE TABLE `subject`
(
 `id_subject`          BIGINT unsigned NOT NULL ,
 `name`                VARCHAR(255) NOT NULL ,
 `quantity_of_credits` INTEGER NOT NULL ,
 `room_type`           ENUM('') NOT NULL ,
 `id_program`          BIGINT unsigned NOT NULL ,
 `id_department`       BIGINT unsigned NOT NULL ,
 `id_campus`           BIGINT unsigned NOT NULL ,
 `cnpj`                BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_subject`, `id_program`, `id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_126` (`id_program`, `id_department`, `id_campus`, `cnpj`),
CONSTRAINT `FK_126` FOREIGN KEY `fkIdx_126` (`id_program`, `id_department`, `id_campus`, `cnpj`) REFERENCES `program` (`id_program`, `id_department`, `id_campus`, `cnpj`)
);






-- ************************************** `request`

CREATE TABLE `request`
(
 `id_request`  BIGINT unsigned NOT NULL ,
 `motive`      VARCHAR(255) NOT NULL ,
 `description` VARCHAR(255) NOT NULL ,
 `id_room`     BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_request`),
KEY `fkIdx_154` (`id_room`),
CONSTRAINT `FK_154` FOREIGN KEY `fkIdx_154` (`id_room`) REFERENCES `room` (`id_room`)
);






-- ************************************** `activity`

CREATE TABLE `activity`
(
 `id_activity`   BIGINT unsigned NOT NULL ,
 `name`          VARCHAR(255) NOT NULL ,
 `activity_type` ENUM('') NOT NULL ,
 `id_department` BIGINT unsigned NOT NULL ,
 `id_campus`     BIGINT unsigned NOT NULL ,
 `cnpj`          BIGINT unsigned NOT NULL ,
 `id_program`    BIGINT unsigned NOT NULL ,
 `enrollment`    BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_activity`),
KEY `fkIdx_110` (`id_department`, `id_campus`, `cnpj`),
CONSTRAINT `FK_110` FOREIGN KEY `fkIdx_110` (`id_department`, `id_campus`, `cnpj`) REFERENCES `department` (`id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_132` (`id_program`, `id_department`, `id_campus`, `cnpj`),
CONSTRAINT `FK_132` FOREIGN KEY `fkIdx_132` (`id_program`, `id_department`, `id_campus`, `cnpj`) REFERENCES `program` (`id_program`, `id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_164` (`enrollment`),
CONSTRAINT `FK_164` FOREIGN KEY `fkIdx_164` (`enrollment`) REFERENCES `student` (id_student)
);






-- ************************************** `course`

CREATE TABLE `course`
(
 `id_course`     BIGINT unsigned NOT NULL ,
 `semester`      BIT NOT NULL ,
 `year`          INTEGER NOT NULL ,
 `subject`        NOT NULL ,
 `id_subject`    BIGINT unsigned NOT NULL ,
 `id_program`    BIGINT unsigned NOT NULL ,
 `id_department` BIGINT unsigned NOT NULL ,
 `id_campus`     BIGINT unsigned NOT NULL ,
 `cnpj`          BIGINT unsigned NOT NULL ,
 `id_period`     BIGINT unsigned NOT NULL ,
 `siape`         BIGINT unsigned NOT NULL ,

PRIMARY KEY (`id_course`, `id_subject`, `id_program`, `id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_135` (`id_subject`, `id_program`, `id_department`, `id_campus`, `cnpj`),
CONSTRAINT `FK_135` FOREIGN KEY `fkIdx_135` (`id_subject`, `id_program`, `id_department`, `id_campus`, `cnpj`) REFERENCES `subject` (`id_subject`, `id_program`, `id_department`, `id_campus`, `cnpj`),
KEY `fkIdx_145` (`id_period`),
CONSTRAINT `FK_145` FOREIGN KEY `fkIdx_145` (`id_period`) REFERENCES `period` (`id_period`),
KEY `fkIdx_148` (`siape`),
CONSTRAINT `FK_148` FOREIGN KEY `fkIdx_148` (`siape`) REFERENCES `professor` (id_professor)
);






