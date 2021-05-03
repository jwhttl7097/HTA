-- �μ����̵�, �μ���, �μ������ھ��̵�, �μ������� �̸� ��ȸ�ϱ�
-- �μ����̵�, �μ���, �μ������ھ��̵� - departments
-- �μ������� �̸� - employees
select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d, employees e
where d.manager_id = e.manager_id
order by d.department_id asc;

-- ���� ������ Ȱ���ϸ�, employees���̺�� ��Ī���� �ʴ� departments�� �μ������� ��ȸ�� �� �ִ�.
select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d, employees e
where d.manager_id = e.manager_id(+)
order by d.department_id asc;

-- Ŀ�̼��� �޴� ������� ������̵� �̸�, �ҼӺμ����̵�, �ҼӺμ��� ��ȸ�ϱ�
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.commission_pct is not null
and e.department_id = d.department_id(+)
order by e.employee_id asc;

-- 90�� �μ��� �Ҽӵ� ������� ��� ���̵�, �̸�, �ش� ����� ����� �̸��� ��ȸ�ϱ�
select ����.employee_id, ����.first_name, ���.first_name, ����.department_id
from employees ����, employees ���
where ����.department_id = 90
and ����.manager_id = ���.employee_id(+);

-- ����Ŭ���ΰ� ANSI-����(ǥ��Sql����)
-- 90�� �μ��� �Ҽӵ� ������� ���̵�, �̸�, �������̵�, �������� ��ȸ�ϱ�
-- ����Ŭ����
select e.employee_id, e.first_name, j.job_id, j.job_title
from employees e, jobs j
where e.department_id = 90
and e.job_id = j.job_id;

-- ANSI-����
select e.employee_id, e.first_name, j.job_id, j.job_title
from employees e join jobs j on e.job_id = j.job_id
where e.department_id = 90;

-- 90�� �μ��� ����� ���̵�, �̸�, �������̵�, ��������, �ҼӺμ� ���̵�, �ҼӺμ��� ��ȸ�ϱ�
-- ����� ���̵�, �̸�, �������̵�, �ҼӺμ����̵� - employees
-- �������̵�, �������� - jobs
-- �ҼӺμ����̵�, �ҼӺμ��� - departments
select e.employee_id, e.first_name, j.job_id, j.job_title, d.department_id, d.department_name
from employees e, jobs j, departments d
where e.department_id = 90
and e.job_id = j.job_id
and e.department_id = d.department_id;

-- ANSI-����
select *
from employees e join jobs j        on e.job_id = j.job_id
                 join departments d on e.department_id = d.department_id
where e.department_id = 90;

-- 90�� �μ��� �Ҽӵ� ����� ���̵�, �̸�, �޿�, �޿������ ��ȸ�ϱ�
select e.employee_id, e.first_name, e.salary, s.grade
from employees e, salary_grade s
where e.department_id = 90
and e.salary >= s.min_salary and e.salary <= s.max_salary;

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salary_grade s on e.salary >= s.min_salary and e.salary <= s.max_salary
where e.department_id = 90;

-- �μ����̵�, �μ���, �μ������ ���̵�, �μ������ �̸� ��ȸ�ϱ�
-- �μ�����ڰ� �����Ǿ� ���� ���� �μ��� ��ȸ�Ѵ�.
select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d, employees e
where d.manager_id = e.employee_id(+);

select d.department_id, d.department_name, d.manager_id, e.first_name
from departments d left outer join employees e on d.manager_id = e.employee_id;
-- left outer join : �������̺��� ��� ���� ��ȸ�ǵ��� �Ѵ�.

select d.department_id, d.department_name, d.manager_id, e.first_name
from employees e right outer join departments d on e.employee_id = d.manager_id;
-- right outer join : �������̺��� ��� ���� ��ȸ�ǵ��� �Ѵ�.

CREATE table sample_books (
    book_no number(4),
    book_title varchar2(200),
    book_writer varchar2(100),
    book_price number(8),
    book_discount_price number(8),
    book_stock number(4),
    book_created_date date
);

-- ���̺� ���ο� �� �߰��ϱ�

-- ���� ��� �÷��� ���� �����ؼ� �߰��ϱ�
insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values
(101, '�ڹ��� ����', '���ü�', 35000, 29000, 1000, sysdate);

-- ���� Ư�� �÷����� ���� �����ؼ� �߰��ϱ�, ������ �÷����� null���� ����ȴ�.
insert into sample_books
(book_no, book_title, book_price, book_created_date)
values
(102, '�̰��� ����', 28000, sysdate);

-- ���� �߰��� �� ���� ��� �÷��� ���� �߰��ϰ�, �÷��� ���� �״�� ���� �߰��� ����
-- �÷����� ������ �� �ִ�.
insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values
(103, '�̰��� �����ͺм��̴�', '������', 28000, 26000, 100, sysdate);

insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
(104, '������ �� �׼�', '�̻�', 30000, 27000, 20);
commit;
-- ���̺� ����� ������ �����ϱ�

-- ���̺� ����� ��� ������ ����
delete from sample_books;
-- ���̺� ����� ������ �߿��� Ư�� ���� �����ϱ�
delete from sample_books
where book_title like '%�ڹ�%';

select * from sample_books;

-- ���̺��� ��� �࿡ ���ؼ� book_price �÷��� ���� 32000���� �����ϱ�
update sample_books
set
    book_price = 32000
where
    book_no = 101;
update sample_books
set
    book_writer = '�ſ��',
    book_price = 35000,
    book_discount_price = 31500,
    book_stock = 50
where
    book_no = 102;
    
-- sample_books ���̺� ���ο� å ���� �߰��ϱ� (3�� �̻�, å ��ȣ�� ��ġ�� �ʵ��� �Ѵ�.)
INSERT INTO sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
VALUES (105, '����ó����� �Ǳ�', '�ǿ켮', 15000, 13000, 200);
-- å ��ȣ�� 104���� å �����ϱ�
delete from sample_books
where book_no = 104;
-- å ��ȣ�� 103���� å �����ϱ�
delete from sample_books
where book_no = 103;

-- ��� å ���� �����ϱ�
delete from sample_books;
SELECT
    *
FROM sample_books;
commit;