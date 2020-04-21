-- 서브쿼리
-- 상관서브쿼리 : 메인쿼리와 연산 (WHERE 절)
-- 인라인서브쿼리 : FROM 절
-- 스칼라서브쿼리 : SELECT 절


-- 복습

-- 1. 나이가 가장 많은 사용자의 U_NAME 을 조회하시오.
-- SELECT MIN(u_birthyear) FROM users;  -- 1960 (단일 행 서브쿼리)
SELECT u_name 
FROM users 
WHERE u_birthyear = (SELECT MIN(u_birthyear) FROM users);


-- 2. 아이디가 'YJS' 인 사용자와 같은 주소를 가진 사용자의 U_NAME 을 조회하시오.
-- SELECT u_address FROM users WHERE u_id = 'YJS';  -- 서울 (단일 행 서브쿼리)
SELECT u_name
FROM users
WHERE u_address = (SELECT u_address FROM users WHERE u_id = 'YJS');


-- 3. 주소가 '서울' 인 사용자들의 생년월일(U_BIRTHYEAR)과 같은 생년월일을 가지는 사용자의 U_NAME 을 조회하시오.
-- SELECT u_birthyear FROM users WHERE u_address = '서울';  -- 1972, 1965, 1967, 1970 (다중 행 서브쿼리)
SELECT u_name
FROM users
WHERE u_birthyear IN (SELECT u_birthyear FROM users WHERE u_address = '서울');


-- 주소가 '서울' 인 사용자들보다 나이가 많은 사용자의 U_NAME 을 조회하시오.
SELECT u_name
FROM users
WHERE u_birthyear < ALL (SELECT u_birthyear FROM users WHERE u_address = '서울');

-- ALL/ANY 연산은 MAX, MIN 함수로 대체할 수 있다.
SELECT u_name
FROM users
WHERE u_birthyear < (SELECT MIN(u_birthyear) FROM users WHERE u_address = '서울');


-- 4. 아이디가 'YJS'인 사용자의 주소(u_address)와 전화번호1(u_mobile1)가 모두 일치하는 사용자를 조회하시오.
-- SELECT u_address, u_mobile1 FROM users WHERE u_id = 'YJS';  -- 단일 행 서브쿼리
SELECT *
FROM users
WHERE (u_address, u_mobile1) = (SELECT u_address, u_mobile1 FROM users WHERE u_id = 'YJS');
