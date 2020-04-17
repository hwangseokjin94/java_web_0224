/*
<< 테이블 제약 조건 (constraint) >>

1. NOT NULL : 빈 칸은 안 된다.
2. UNIQUE : 중복 저장은 안 된다.
3. PRIMARY KEY : 기본키 ( NOT NULL + UNIQUE )
   (예: 학번, 주민등록번호, 회원번호 등 레코드 고유 식별자)
4. DEFAULT 기본값 : 값이 전달되지 않으면 자동으로 기본값을 가진다.
5. CHECK (조건식) : 값이 입력되면 조건식을 만족하는지 검사한다.
*/


-- 테이블 삭제
DROP TABLE student;


-- 1. 제약조건을 사용하여 STUDENT 테이블을 생성하시오.
-- 1) 학번 : NUMBER, 기본키
-- 2) 성명 : VARCHAR2(20), 필수
-- 3) 국어 : NUMBER, 기본값 [0], 0 ~ 100 사이만 가능
-- 4) 영어 : NUMBER, 기본값 [0], 0 ~ 100 사이만 가능
-- 5) 수학 : NUMBER, 기본값 [0], 0 ~ 100 사이만 가능
-- 6) 평균 : NUMBER
-- 7) 이메일 : VARCHAR2(100), 중복 불가
-- 8) 등록일 : DATE, 기본값 [현재 날짜]

CREATE TABLE student 
(
stu_no NUMBER NOT NULL PRIMARY KEY,
stu_name VARCHAR2(20) NOT NULL,
kor NUMBER DEFAULT 0 CHECK (kor >= 0 AND kor <= 100),
eng NUMBER DEFAULT 0 CHECK (eng >= 0 AND eng <= 100),
mat NUMBER DEFAULT 0 CHECK (mat BETWEEN 0 AND 100),  -- 위와 같은 CHECK
average NUMBER,
stu_email VARCHAR2(100) UNIQUE,
stu_reg_date DATE DEFAULT SYSDATE
);


-- 2. 총 5명의 학생 정보를 임의로 생성하여 STUDENT 테이블에 삽입하시오.
--   이 때, 평균 정보는 입력하지 마시오.
INSERT INTO student (stu_no, stu_name, stu_email) VALUES (1, '앨리스', 'alice@gmail.com');
INSERT INTO student (stu_no, stu_name, kor, eng, mat, stu_email, stu_reg_date) VALUES (2, '제임스', 50, 60, 70, 'james@gmail.com', '20/04/07');

SELECT * FROM student;

-- 3. 삽입된 모든 학생의 평균 필드를 국어, 영어, 수학의 평균 점수로 갱신하시오.
UPDATE student SET average = (kor + eng + mat) / 3;


-- 4. 삽입된 모든 학생의 등록일 필드를 '2020-04-01'로 갱신하시오.
UPDATE student SET stu_reg_date = '2020-04-01';


-- 5. 임의의 학생을 1명 선정하여 삭제하시오.
DELETE FROM student WHERE stu_no = 1;
