-- 테이블 조인하기
-- 사원아이디, 사원명, 소속부서아이디, 소속부서명
-- employees테이블 -> 사원아이디, 사원명, 소속부서아이디
-- departments 테이블 - 소속수서명
select employees.employee_id, employees.first_name, employees.department_id, 
       departments.department_name
from employees, departments
where employees.department_id = departments.department_id;

select A.employee_id, A.first_name, A.department_id, B.department_name
from employees A, departments B 
where A.department_id = B.department_id;

-- 테이블조인하기
-- 사원아이디, 이름, 직종아이디, 급여, 직종제목, 직종 치소 급여, 직종 최대 급여 조회하기
-- employees 테이블 -> 사원아이디, 이름, 직종아이디, 급여
-- jobs 테이블 -> 직종아이디, 직종제목, 직종 최저급여, 직종 최고급여
select A.employee_id, A.first_name, A.salary, A.job_id, B.min_salary, B.max_salary
FROM employees A, jobs B
where A.job_id = B.job_id;

-- 테이블조인하기
-- 부서아이디, 부서명, 소재지아이디, 소재지 주소, 소재지 도시명 조회하기
-- departments -> 부서아이디, 부서명, 소재지아이디
-- locations -> 소재지주소, 소재지 도시명
select A.department_id, A.department_name, A.location_id, B.street_address, B.city
from departments A, locations B 
where A.location_id = B.location_id;

-- 테이블 조인하기
-- 부서관리자가 지정되어 있는 부서의 부서아이디, 부서명, 부서관리자 아이디, 부서관리자 이름 조회하기
-- departments -> 부서아아디, 부서명, 부서관리자아이디,
-- employees -> 부서관리자이름(사원이름)
-- departments의 manager_id는 부서관리자로 지정된 사원의 사원아이디다.
-- departments의 manager_id와 동일한 사원아이디를 가진 사원정보가 조인되어야한다.
select A.department_id, A.department_name, A.manager_id, B.first_name
from departments A, employees B 
where A.manager_id = B.employee_id
and A.manager_id is not null;

-- 3개 이상의 테이블 조인하기
-- 사원아이디, 사원이름, 직종아이디, 급여, 직종최저급여, 직종초고급여, 소속부서 아이디, 부서명 조회
-- employees -> 사원아이디, 사원이름, 직종아이디, 급여, 소속부서아이디
-- jobs -> 직종최저급여, 직종최고급여
-- departments -> 부서명
select E.employee_id, E.first_name, E.job_id,
		E.salary, J.min_salary, J.max_salary, 
		E.department_id, D.department_name
from employees E, jobs J, departments D
where E.job_id = J.job_id 
and E.department_id = D.department_id
order by E.employee_id asc; 

-- 100번 사원의 이름, 전화번호, 이메일, 
-- 소속부서아이디, 소속부서명, 소속부서 도시명, 소속부서 소재지주소 조회하기
select E.first_name, E.phone_number, E.email,
       D.department_id, D.department_name,
       L.city, L.street_address
from employees E, departments D, locations L 
where E.employee_id = 100 -- 검색조건
and E.department_id = D.department_id 
and D.location_id = L.location_id;

-- 50번 부서에 소속된 사원들의 사원아이디, 이름, 직종아이디, 직종제목 조회하기
-- 사원아이디, 이름, 직종아이디 --> employees
-- 직종제목 --> jobs
select E.employee_id, E.first_name, J.job_id, J.job_title
from employees E, jobs J 
where E.department_id = 50 
and E.job_id = J.job_id;

-- 급여를 15000이상 받은 사원들의 이름, 직종아이디, 급여, 부서명을 조회하기
-- 급여를 15000이상, 급여, 이름, 직종아이디 --> employees 
-- 부서명 ==> departments
select E.first_name, E.job_id, E.salary, D.department_name
from employees E, departments D 
where E.salary >= 15000
and E.department_id = D.department_id;

-- 100번직원 직원이 관리하는 사원들의 이름, 직종아이디, 직종제목, 부서아이디, 부서명 조회하기
-- 100번직원, 이름, 직종아이디, 부서아아디 --> employees 
-- 직종제목 --> jobs 
-- 부서명 -- >departments
select E.first_name, E.job_id, J.job_title, 
	D.department_id, D.department_name
from employees E, jobs J, departments D 
where E.manager_id = 100
and E.job_id = J.job_id 
and E.department_id = D.department_id;

-- 1
-- 모든 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명을 조회하기
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

--2
-- 모든 사원들의 사원아이디, 이름, 직종아이디, 직종제목을 조회하기
select e.employee_id, e.first_name, j.job_id, j.job_title
from employees e, jobs j
where e.job_id = j.job_id;

--3
-- 사원들 중에서 소속부서가 정해지지 않는 사원의 아이디, 이름, 급여, 직종, 직종최소급여, 직종최대급여를 조회하기
select e.employee_id, e.first_name, e.salary, j.job_id, j.min_salary, j.max_salary
from employees e, jobs j
where e.department_id is null
and e.job_id = j.job_id;

--4
-- 2007년에 입사한 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명을 조회하기
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.hire_date like '2007%'
and e.department_id = d.department_id;

--5
-- 커미션을 받은 사원들의 사원아이디, 이름, 직종, 직종제목, 소속부서아이디, 소속부서명을 조회하기
select e.employee_id, e.first_name, j.job_id, j.job_title, d.department_id, d.department_name
from employees e, jobs j, departments d
where e.commission_pct is not null
and e.job_id = j.job_id
and e.department_id = d.department_id;

--6
-- 직종최소급여가 10000달러 이상인 직종에 종사하고 있는 사원들의 아이디, 이름, 직종아이디, 급여를 조회하기
select e.employee_id, e.first_name, e.job_id, e.salary
from employees e, jobs j
where j.min_salary >= 10000
and e.job_id = j.job_id;

--7
-- 모든 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명, 해당부서의 소재지 도시 및 주소를 조회하기
select e.employee_id, e.first_name, d.department_id, d.department_name, l.city, l.street_address
from employees e, locations l, departments d
where d.location_id = l.location_id
and e.department_id = d.department_id;

--8
-- 모든 사원들의 사원아이디, 이름, 직종아이디, 직종제목, 소속부서아이디, 소속부서명, 해당부서의 소재지 도시 및 주소
select e.employee_id, e.first_name, 
       j.job_id, j.job_title,
       d.department_id, d.department_name,
       l.city, l.street_address
from employees e, locations l, departments d, jobs j
where d.location_id = l.location_id
and e.job_id = j.job_id
and e.department_id = d.department_id;

--9
-- 부서 소재지 국가가 미국에 위치하고 있는 부서의 부서아이디, 부서명, 도시명을 조회하기
select d.department_id, d.department_name, l.city, l.country_id
from departments d, locations l
where l.country_id = 'US'
and d.location_id = l.location_id;

--10
-- 'Seattle'에서 근무하고 있는 사원들의 사원아이디, 이름, 부서아이디, 부서명을 조회하기
select e.employee_id, e.first_name, d.department_id, d.department_name
from employees e, departments d, locations l
where l.city = 'Seattle'
and e.department_id = d.department_id
and d.location_id = l.location_id;

--11
-- 2006년에 job이 변경된 기록이 있는 사원들의 사원아이디, 이름, 직종아이디를 조회하기
select e.employee_id, e.first_name, h.job_id
from employees e, job_history h
where e.hire_date like '2006%'
and e.job_id != h.job_id
and e.employee_id = h.employee_id;

select e.employee_id, e.first_name, h.job_id
from employees e, job_history h
where h.start_date >= to_date('2006-01-01', 'yyyy-mm-dd') 
and h.end_date < to_date('2007-01-01', 'yyyy-mm-dd')
and e.employee_id = h.employee_id;

--12
-- 이전에 50번 부서에서 근무한 적이 있는 사원들의 사원아이디, 이름, 근무시작일, 근무종료일, 근무당시 직종아이디를 조회하기
select e.employee_id, e.first_name, h.start_date, h.end_date, h.job_id
from employees e, job_history h
where h.department_id = 50
and e.employee_id = h.employee_id;

--13
-- 사원들 중에서 자신이 근무하고 있는 직종의 최소급여와 최대급여의 평균값도 적은 급여를 받는 
-- 사원의 아이디, 이름, 직종아이디, 급여, 최소급여, 최대급여, 최소/최대급여 평균값을 조회하기
-- (평균값은 (최소급여+최대급여)/2로 구한다)
select e.employee_id, e.first_name, e.job_id, e.salary, j.min_salary, j.max_salary, ((j.min_salary+j.max_salary)/2) as 평균값
from employees e, jobs j
where salary < ((j.min_salary+j.max_salary)/2)
and e.job_id = j.job_id
order by e.job_id;
