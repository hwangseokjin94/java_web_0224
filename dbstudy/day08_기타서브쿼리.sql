-- 1. employees 테이블과 구조와 데이터가 동일한 employees2 테이블을 생성한다.
CREATE TABLE employees2
AS SELECT * FROM employees;


-- 2. job_history 테이블의 employee_id, job_id, department_id 칼럼만 복사하여 job_history2 테이블을 생성한다.
CREATE TABLE job_history2 (employee_id, job_id, department_id)
AS SELECT employee_id, job_id, department_id FROM job_history;


-- 3. departments 테이블에서 manager_id 가 없는 데이터를 제외한 모든 데이터를 복사하여 departments2 테이블을 생성한다.
CREATE TABLE departments2
AS SELECT * FROM departments WHERE manager_id IS NOT NULL;


-- 4. regions 테이블과 구조만 동일하고 데이터는 하나도 존재하지 않는 regions2 테이블을 생성한다.
CREATE TABLE regions2
AS SELECT * FROM regions WHERE 1 = 2;


-- 5. regions 테이블에서 region_id 가 1 과 2 인 지역들을 검색하여 region2 테이블에 삽입한다.
INSERT INTO regions2 (region_id, region_name) 
SELECT region_id, region_name FROM regions WHERE region_id IN (1, 2);

INSERT INTO regions2
SELECT region_id, region_name FROM regions WHERE region_id IN (1, 2);

INSERT ALL
    INTO regions2 VALUES (region_id, region_name)
SELECT * FROM regions WHERE region_id IN(1, 2);


-- 6. employees2 테이블에서 employee_id 가 150 인 사원이 employee_id 가 200 인 사원과 같은 부서(department_id)가 되도록 수정한다.
UPDATE employees2
SET department_id = (SELECT department_id FROM employees2 WHERE employee_id = 200)
WHERE employee_id = 150;


-- 7. 이번 조직 개편에서 'Marketing' 부서를 없애고, 해당 사원을 모두 해고하기로 했다.
-- employees2 테이블에서 부서가 'Marketing' 인 모든 사원을 삭제한다.
DELETE FROM employees2
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'Marketing');


-- 8. 지금까지 생성한 employees2, job_history2, departments2, regions2 테이블을 모두 삭제한다.
DROP TABLE employees2;
DROP TABLE job_history2;
DROP TABLE departments2;
DROP TABLE regions2;