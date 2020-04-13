--학생테이블 :student
--과목테이블 : subject
--수강신청 테이블 :enroll
DROP TABLE enroll;
DROP TABLE student;
DROP TABLE subject;

CREATE TABLE student
(std_id INTEGER NOT NULL PRIMARY KEY ,
std_name CHAR(10),
std_age INTEGER
);

CREATE TABLE subject
(sub_code CHAR(1) NOT NULL PRIMARY KEY,
sub_name CHAR(10),
sub_pro_name CHAR(10)
);

CREATE TABLE enroll
(enr_num INTEGER NOT NULL PRIMARY KEY ,
std_id INTEGER,
sub_code CHAR(1),
FOREIGN KEY (std_id) REFERENCES student(std_id),
FOREIGN KEY (sub_code) REFERENCES subject(sub_code)

);
