-- 인덱스

-- 1. EMPLOYEE 테이블의 NAME 칼럼에 비고유 인덱스 IDX성명 을 생성하시오.
CREATE INDEX IDX성명 ON EMPLOYEE (NAME);

-- 2. EMPLOYEE 테이블의 HIRE_DATE 칼럼에 비고유 인덱스 IDX고용일 을 생성하시오.
CREATE INDEX IDX고용일 ON EMPLOYEE (HIRE_DATE);

-- 3. DEPARTMENT 테이블의 DEPT_NAME 칼럼에 고유(UNIQUE) 인덱스 IDX부서명 을 생성하시오.
CREATE UNIQUE INDEX IDX부서명 ON DEPARTMENT (DEPT_NAME);

-- 4. 지금까지 생성한 모든 인덱스를 삭제하시오.
DROP INDEX IDX성명;
DROP INDEX IDX고용일;
DROP INDEX IDX부서명;
