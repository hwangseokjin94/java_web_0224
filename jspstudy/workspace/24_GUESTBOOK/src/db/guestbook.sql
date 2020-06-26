DROP TABLE GUESTBOOK;
CREATE TABLE GUESTBOOK(
	NO NUMBER PRIMARY KEY,
	WRITER VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(50),
	TITLE VARCHAR2(100) NOT NULL,
	CONTENT VARCHAR2(1000),
	PW VARCHAR2(20) NOT NULL,
	FILENAME VARCHAR2(300),
	REGDATE DATE 
);

DROP SEQUENCE GUESTBOOK_SEQ;
CREATE SEQUENCE GUESTBOOK_SEQ;
INSERT INTO GUESTBOOK VALUES(GUESTBOOK_SEQ.NEXTVAL,'유재석','SUK@GMAIL.COM','반갑습니다.','대박기원','1111',NULL,SYSDATE);