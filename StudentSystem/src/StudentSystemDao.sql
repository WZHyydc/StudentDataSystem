CREATE SCHEMA `studentsystemdao` DEFAULT CHARACTER SET utf8 ;

use studentsystemdao;
CREATE TABLE `studentsystemdao`.`undergraduate`
(
       `UStudentID` INT NOT NULL,
        `UStudentName` VARCHAR(12) NOT NULL,
        `UStudentAge` INT NOT NULL DEFAULT 18,
        `UStudentClass` INT NOT NULL,
        `UStudentMajor` VARCHAR(10) NOT NULL,
        `UStudentAdP` VARCHAR(8) NOT NULL DEFAULT 'null',
        `UStudentAdC` VARCHAR(8) NOT NULL DEFAULT 'null',
        `UStudentAdS` VARCHAR(8) NOT NULL DEFAULT 'null',
        `UStudentAdD` VARCHAR(8) NOT NULL DEFAULT 'null',
        `UStudentSMath` INT NOT NULL DEFAULT 0,
        `UStudentSJava` INT NOT NULL DEFAULT 0,
        `UStudentSEng` INT NOT NULL DEFAULT 0,
        PRIMARY KEY (`UStudentID`));
CREATE TABLE `studentsystemdao`.`graduate`
(
       `StudentID` INT NOT NULL,
       `StudentName` VARCHAR(10) NOT NULL,
       `StudentAge` INT NOT NULL DEFAULT 18,
       `StudentClass` INT NOT NULL,
       `StudentMajor` VARCHAR(10) NOT NULL,
       `StudentTutor` VARCHAR(10) NOT NULL,
       `StudentAdP` VARCHAR(10) NOT NULL DEFAULT 'null',
       `StudentAdC` VARCHAR(8) NOT NULL DEFAULT 'null',
       `StudentAdS` VARCHAR(8) NOT NULL DEFAULT 'null',
       `StudentAdD` VARCHAR(8) NOT NULL DEFAULT 'null',
       `StudentSMath` INT NOT NULL DEFAULT 0,
       `StudentSMySQL` INT NOT NULL DEFAULT 0,
       `StudentSEng` INT NOT NULL DEFAULT 0,
       PRIMARY KEY (`StudentID`));

CREATE TABLE `studentsystemdao`.`tb_user`
(
      `User_Name` VARCHAR(12) NOT NULL,
      `Password` VARCHAR(18) NOT NULL,
      PRIMARY KEY (`User_Name`));