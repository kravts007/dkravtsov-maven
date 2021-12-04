DROP DATABASE IF EXISTS university;
CREATE DATABASE university;
USE university;

DROP TABLE IF EXISTS points;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS groups_of_students;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS teachers;

CREATE TABLE IF NOT EXISTS students(
    ID int PRIMARY KEY AUTO_INCREMENT,
    fio varchar(50) NOT NULL  ,
    group_id int ,
    year_of_entry year NOT NULL
);

CREATE TABLE IF NOT EXISTS groups_of_students(
    ID int PRIMARY KEY AUTO_INCREMENT,
    group_code varchar(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS points(
    ID int PRIMARY KEY,
    class_id int NOT NULL ,
    student_id int NOT NULL ,
    grade int NOT NULL
);

CREATE TABLE IF NOT EXISTS classes(
    ID int PRIMARY KEY ,
    class_name varchar(50) NOT NULL ,
    teacher_id int ,
    half_year tinyint NOT NULL ,
    current_year year NOT NULL
);

CREATE TABLE IF NOT EXISTS teachers(
    ID int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL ,
    cathedra_id int
);

CREATE TABLE IF NOT EXISTS cathedras(
    ID int PRIMARY KEY AUTO_INCREMENT,
    cathedra_name varchar(50) NOT NULL ,
    cathedra_head varchar(50) NOT NULL
);

ALTER TABLE students ADD
    CONSTRAINT FK_group_of_students FOREIGN KEY (
         group_id
        ) REFERENCES groups_of_students(
         ID
        );

ALTER TABLE points ADD
    CONSTRAINT FK_points_of_students FOREIGN KEY (
          student_id
        ) REFERENCES students(
          ID
        ) ON DELETE CASCADE ;

ALTER TABLE points ADD
    CONSTRAINT FK_classes_grade FOREIGN KEY (
          class_id
        ) REFERENCES classes(
          ID
        );

ALTER TABLE classes ADD
    CONSTRAINT FK_classes_teacher FOREIGN KEY (
           teacher_id
        ) REFERENCES teachers(
            ID
        );

ALTER TABLE teachers ADD
    CONSTRAINT FK_teacher_cathedra FOREIGN KEY (
        cathedra_id
        ) REFERENCES cathedras (
        ID
        );

/*----Cathedras---------------------------------------------------------------------------------------------------------*/
INSERT INTO  cathedras VALUES (1, 'Automation', 'Beglov Konstantin Viktorovich' );
INSERT INTO  cathedras VALUES (2, 'Nuclear Energy', 'Maximov Maxim Vitalievich' );
INSERT INTO  cathedras VALUES (3, 'Ecological', 'Marchenko Nadejda Viktorovna' );
INSERT INTO  cathedras VALUES (4, 'Heat engineering', 'Pustovesov Igor Valerievich' );
INSERT INTO  cathedras VALUES (5, 'Computer engineering', 'Bolotnyi Vadim Fedorovich' );

/*----Teachers----------------------------------------------------------------------------------------------------------*/
INSERT INTO teachers VALUES (1,' Bruce Willis JR', 2);
INSERT INTO teachers VALUES (2,'George Clooney  JR', 1);
INSERT INTO teachers VALUES (3,' Kevin Costner JR', 5);
INSERT INTO teachers VALUES (4,' Donald Sutherland JR', 1);
INSERT INTO teachers VALUES (5,' Jennifer Lopez JR', 4);
INSERT INTO teachers VALUES (6,' Samuel L. Jackson JR', 4);
INSERT INTO teachers VALUES (7,' Nikole Kidman JR', 2);
INSERT INTO teachers VALUES (8,' Alan Rickman JR', 5);
INSERT INTO teachers VALUES (9,' Kurt Russell JR', 3);
INSERT INTO teachers VALUES (10,' Harrison Ford JR', 3);

/*----Classes-----------------------------------------------------------------------------------------------------------*/
INSERT INTO classes VALUES (1,'Computer technology', 3, 1, 2021);
INSERT INTO classes VALUES (2,'Data technology', 2, 1, 2021);
INSERT INTO classes VALUES (3,'Thermodynamics', 5, 1, 2021);
INSERT INTO classes VALUES (4,'Fluid dynamics', 10, 1, 2021);
INSERT INTO classes VALUES (5,'Process automation', 6, 1, 2021);
INSERT INTO classes VALUES (6,'Probability theory', 9, 1, 2021);
INSERT INTO classes VALUES (7,'Theoretical mechanics', 4, 1, 2021);
INSERT INTO classes VALUES (8,'System analysis', 1, 1, 2021);
INSERT INTO classes VALUES (9,'Discrete Math', 8, 1, 2021);
INSERT INTO classes VALUES (10,'Automatic control theory', 7, 1, 2021);

/*----Groups-------------------------------------------------------------------------------------------------------------*/
INSERT INTO groups_of_students VALUES (1, 'TA-0612');
INSERT INTO groups_of_students VALUES (2, 'TA-0713');
INSERT INTO groups_of_students VALUES (3, 'TE-0814');
INSERT INTO groups_of_students VALUES (4, 'TE-0915');

/*----Students----------------------------------------------------------------------------------------------------------*/
INSERT INTO students VALUES (1, 'Ivanov Ivan Ivanovich', 3, 2008);
INSERT INTO students VALUES (2, 'Gonchiy Petr Vladimirovich', 2, 2007);
INSERT INTO students VALUES (3, 'Petrov Dmitry Ivanovich', 4, 2009);
INSERT INTO students VALUES (4, 'Shurik Nikita Nikolaich', 4, 2009);
INSERT INTO students VALUES (5, 'Koza Inna Ivanovna', 1, 2006);
INSERT INTO students VALUES (6, 'Gontareva Iryna MAximovna', 3, 2008);
INSERT INTO students VALUES (7, 'Jukov Alexey Kirilych', 1, 2006);
INSERT INTO students VALUES (8, 'Petrov Vadim Ahmetovich', 4, 2009);
INSERT INTO students VALUES (9, 'Laptop Nikolay Andreich', 1, 2006);
INSERT INTO students VALUES (10, 'Karamazin Alexandr Ivanovich', 2, 2007);
INSERT INTO students VALUES (11, 'Kurolesov Sergei Nikolaich', 2, 2007);
INSERT INTO students VALUES (12, 'Malyutka Maxim Viktorovich', 4, 2009);
INSERT INTO students VALUES (13, 'Noob Anna Dmitrievna', 1, 2006);
INSERT INTO students VALUES (14, 'Gontareva Ivanna Alexeevna', 3, 2008);
INSERT INTO students VALUES (15, 'Rexona Yuriy Nikolaich', 2, 2007);
INSERT INTO students VALUES (16, 'Papir Alexey Petrovich', 3, 2008);
INSERT INTO students VALUES (17, 'Udavka Ivan Nikolaich', 1, 2006);


/*----Points------------------------------------------------------------------------------------------------------------*/
INSERT INTO points VALUES (1,10, 1, 98);
INSERT INTO points VALUES (2, 9, 2, 45);
INSERT INTO points VALUES (3, 8, 3, 69);
INSERT INTO points VALUES (4, 7, 4, 87);
INSERT INTO points VALUES (5, 6, 5, 35);
INSERT INTO points VALUES (6, 5, 6, 14);
INSERT INTO points VALUES (7, 4, 7, 96);
INSERT INTO points VALUES (8, 3, 8, 95);
INSERT INTO points VALUES (9, 2, 9, 94);
INSERT INTO points VALUES (10, 1, 10, 87);
INSERT INTO points VALUES (11, 2, 17, 78);
INSERT INTO points VALUES (12, 2, 16, 91);
INSERT INTO points VALUES (13, 3, 15, 66);
INSERT INTO points VALUES (14, 4, 14, 36);
INSERT INTO points VALUES (15, 6, 13, 84);
INSERT INTO points VALUES (16, 6, 12, 81);
INSERT INTO points VALUES (17, 7, 11, 75);