-- 부서아이디, 부서명, 부서관리자아이디, 부서관리자 이름 조회하기
-- 부서아이디, 부서명, 부서관리자아이디 - departments
-- 부서관리자 이름 - employees
select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d, employees e
where d.manager_id = e.manager_id
order by d.department_id asc;

-- 포괄 조인을 활용하면, employees테이블과 매칭되지 않는 departments의 부서정보도 조회할 수 있다.
select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d, employees e
where d.manager_id = e.manager_id(+)
order by d.department_id asc;

-- 커미션을 받는 사원들의 사원아이디 이름, 소속부서아이디, 소속부서명 조회하기
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.commission_pct is not null
and e.department_id = d.department_id(+)
order by e.employee_id asc;

-- 90번 부서에 소속된 사원들의 사원 아이디, 이름, 해당 사원의 상사의 이름을 조회하기
select 부하.employee_id, 부하.first_name, 상사.first_name, 부하.department_id
from employees 부하, employees 상사
where 부하.department_id = 90
and 부하.manager_id = 상사.employee_id(+);

-- 오라클조인과 ANSI-조인(표준Sql쿼리)
-- 90번 부서에 소속된 사원들의 아이디, 이름, 직종아이디, 직종제목 조회하기
-- 오라클조인
select e.employee_id, e.first_name, j.job_id, j.job_title
from employees e, jobs j
where e.department_id = 90
and e.job_id = j.job_id;

-- ANSI-조인
select e.employee_id, e.first_name, j.job_id, j.job_title
from employees e join jobs j on e.job_id = j.job_id
where e.department_id = 90;

-- 90번 부서에 사원의 아이디, 이름, 직종아이디, 직종제목, 소속부서 아이디, 소속부서명 조회하기
-- 사원의 아이디, 이름, 직종아이디, 소속부서아이디 - employees
-- 직종아이디, 직종제목 - jobs
-- 소속부서아이디, 소속부서명 - departments
select e.employee_id, e.first_name, j.job_id, j.job_title, d.department_id, d.department_name
from employees e, jobs j, departments d
where e.department_id = 90
and e.job_id = j.job_id
and e.department_id = d.department_id;

-- ANSI-조인
select *
from employees e join jobs j        on e.job_id = j.job_id
                 join departments d on e.department_id = d.department_id
where e.department_id = 90;

-- 90번 부서에 소속된 사원의 아이디, 이름, 급여, 급여등급을 조회하기
select e.employee_id, e.first_name, e.salary, s.grade
from employees e, salary_grade s
where e.department_id = 90
and e.salary >= s.min_salary and e.salary <= s.max_salary;

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salary_grade s on e.salary >= s.min_salary and e.salary <= s.max_salary
where e.department_id = 90;

-- 부서아이디, 부서명, 부서담당자 아이디, 부서담당자 이름 조회하기
-- 부서담당자가 결정되어 있지 않은 부서도 조회한다.
select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d, employees e
where d.manager_id = e.employee_id(+);

select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d left outer join employees e on d.manager_id = e.employee_id;
-- left outer join : 선행테이블의 모든 행이 조회되도록 한다.

select d.department_id, d.department_name, d.manager_id, e.first_name
from employees e right outer join departments d on e.employee_id = d.manager_id;
-- right outer join : 후행테이블의 모든 행이 조회되도록 한다.

CREATE table sample_books (
    book_no number(4),
    book_title varchar2(200),
    book_writer varchar2(100),
    book_price number(8),
    book_discount_price number(8),
    book_stock number(4),
    book_created_date date
);

-- 테이블에 새로운 행 추가하기

-- 행의 모든 컬럼의 값을 지정해서 추가하기
insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values
(101, '자바의 정석', '남궁성', 35000, 29000, 1000, sysdate);

-- 행의 특정 컬럼에만 값을 지정해서 추가하기, 생략된 컬럼에는 null값이 저장된다.
insert into sample_books
(book_no, book_title, book_price, book_created_date)
values
(102, '이것이 정석', 28000, sysdate);

-- 행을 추가할 때 행의 모든 컬럼에 값을 추가하고, 컬럼의 순서 그대로 값을 추가할 때는
-- 컬럼명을 생략할 수 있다.
insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values
(103, '이것이 데이터분석이다', '윤기태', 28000, 26000, 100, sysdate);

insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
(104, '스프링 인 액션', '미상', 30000, 27000, 20);
commit;
-- 테이블에 저장된 데이터 삭제하기

-- 테이블에 저장된 모든 데이터 삭제
delete from sample_books;
-- 테이블에 저장된 데이터 중에서 특정 행을 삭제하기
delete from sample_books
where book_title like '%자바%';

select * from sample_books;

-- 테이블의 모든 행에 대해서 book_price 컬럼의 값을 32000으로 변경하기
update sample_books
set
    book_price = 32000
where
    book_no = 101;
update sample_books
set
    book_writer = '신용권',
    book_price = 35000,
    book_discount_price = 31500,
    book_stock = 50
where
    book_no = 102;
    
-- sample_books 테이블에 새로운 책 정보 추가하기 (3개 이상, 책 번호는 겹치지 않도록 한다.)
INSERT INTO sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
VALUES (105, '정보처리기사 실기', '권우석', 15000, 13000, 200);
-- 책 번호가 104번인 책 삭제하기
delete from sample_books
where book_no = 104;
-- 책 번호가 103번인 책 삭제하기
delete from sample_books
where book_no = 103;

-- 모든 책 정보 삭제하기
delete from sample_books;
SELECT
    *
FROM sample_books;
commit;