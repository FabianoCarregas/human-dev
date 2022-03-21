CREATE DATABASE humandev;

USE humandev;

CREATE TABLE Category
(id bigint auto_increment unique PRIMARY KEY,
`name` VARCHAR(80) NOT NULL,
`code` VARCHAR(80) NOT NULL,
`category_description` TEXT,
`study_guide` VARCHAR(50),
`active` BOOLEAN,
`order` INT UNSIGNED,
`icon` VARCHAR(120),
`hexacolor` VARCHAR(10)
);

CREATE TABLE Subcategory
(id bigint auto_increment unique PRIMARY KEY,
`name` VARCHAR(80) NOT NULL,
`code` VARCHAR(80) NOT NULL,
`subcategory_description` TEXT,
`study_guide` VARCHAR(80),
`active` BOOLEAN,
`ordination` INT UNSIGNED,
`category_id` bigint,
FOREIGN KEY (`category_id`) REFERENCES Category (`id`)
);

CREATE TABLE Course
(id bigint auto_increment unique PRIMARY KEY,
`name` VARCHAR(80) NOT NULL,
`code` VARCHAR(80) NOT NULL,
`course_time_hours` SMALLINT UNSIGNED,
`status` BOOLEAN,
`target_audience` TEXT,
`instructor` VARCHAR(80),
`course_description` TEXT,
`developed_skills` TEXT,
`subcategory_id` bigint,
FOREIGN KEY (`subcategory_id`) REFERENCES Subcategory (`id`)
);

CREATE TABLE Section
(id bigint auto_increment unique PRIMARY KEY,
`name` VARCHAR(80) NOT NULL,
`code` VARCHAR(80) NOT NULL,
`ordination` INT UNSIGNED,
`active` BOOLEAN,
`test_status` BOOLEAN,
`course_id` bigint,
FOREIGN KEY (`course_id`) REFERENCES Course (`id`)
);

CREATE TABLE Explanation
(id bigint auto_increment unique PRIMARY KEY,
`activity_Explanation` VARCHAR(80),
`title` VARCHAR(80) NOT NULL,
`code` VARCHAR(60) NOT NULL,
`status` VARCHAR(80),
`ordination` INT UNSIGNED,
`section_id` bigint,
FOREIGN KEY (`section_id`) REFERENCES Section (`id`)
);

CREATE TABLE Question
(id bigint auto_increment unique PRIMARY KEY,
`title` VARCHAR(80) NOT NULL,
`code` VARCHAR(60) NOT NULL,
`status` VARCHAR(80),
`ordination` INT UNSIGNED,
`section_id` bigint,
FOREIGN KEY (`section_id`) REFERENCES Section (`id`)
);

CREATE TABLE Video
(id bigint auto_increment unique PRIMARY KEY,
`video_url` VARCHAR(220),
`video_time` SMALLINT UNSIGNED,
`video_description` VARCHAR(150),
`title` VARCHAR(80) NOT NULL,
`code` VARCHAR(60) NOT NULL,
`status` VARCHAR(80),
`ordination` INT UNSIGNED,
`section_id` bigint,
FOREIGN KEY (`section_id`) REFERENCES Section (`id`)
);

CREATE TABLE Alternative
(id bigint auto_increment unique PRIMARY KEY,
`question_explanation` VARCHAR(150),
`ordination` INT UNSIGNED,
`answer` VARCHAR(120),
`answer_check` BOOLEAN,
`answer_justification` VARCHAR(140),
`right_answer` VARCHAR(120),
`question_id` bigint,
FOREIGN KEY (`question_id`) REFERENCES Question (`id`)
);
