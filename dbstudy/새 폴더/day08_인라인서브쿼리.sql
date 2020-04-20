-- 인라인 서브쿼리
-- 1. 서브쿼리의 결과가 테이블 일 수 있다.
-- 2. FROM 절에서 서브쿼리를 사용할 수 있다.
-- 3. FROM 절에서 사용하는 서브쿼리를 인라인 서브쿼리라고 한다.
-- 4. 인라인 서브쿼리의 별명을 이용해서 원하는 칼럼을 메인쿼리의 SELECT 절에서 사용할 수 있다.


-- 1. 주소가 '서울'인 사용자들의 아이디, 이름을 조회하시오.
-- SELECT * FROM users WHERE u_address = '서울';
SELECT 서울사람.u_id, 서울사람.u_name
FROM (SELECT * FROM users WHERE u_address = '서울') 서울사람;


-- 2. 전화번호1이 '010'인 사용자들의 아이디, 이름을 조회하시오.
SELECT u.u_id, u.u_name
FROM (SELECT * FROM users WHERE u_mobile1 = '010') u;
