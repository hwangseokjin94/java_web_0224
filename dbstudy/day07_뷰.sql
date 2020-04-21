-- 뷰

-- 기본 테이블로 만드는 가상의 테이블


-- 1. EMPLOYEE 테이블의 EMP_NO, NAME 칼럼을 이용해 VIEW사원 뷰를 생성하시오.
CREATE VIEW VIEW사원 AS SELECT EMP_NO, NAME FROM EMPLOYEE;


-- 2. EMPLOYEE 테이블의 모든 칼럼을 이용해 VIEW과장 뷰를 생성하시오.
-- 직급이 '과장'인 데이터만 이용하시오.
CREATE VIEW VIEW과장 AS SELECT * FROM EMPLOYEE WHERE POSITION = '과장';


-- 3. EMPLOYEE 테이블과 DEPARTMENT 테이블을 이용하여 VIEW부서 뷰를 생성하시오.
-- EMP_NO, NAME, DEPT_NAME, POSITION 칼럼을 이용하시오.
CREATE VIEW VIEW부서 AS 
    SELECT E.EMP_NO, E.NAME, D.DEPT_NAME, E.POSITION 
    FROM DEPARTMENT D, EMPLOYEE E 
    WHERE D.DEPT_NO = E.DEPART;
    
    
-- 4. 생성된 모든 VIEW 를 삭제하시오.
DROP VIEW VIEW과장;
DROP VIEW VIEW부서;
DROP VIEW VIEW사원;
