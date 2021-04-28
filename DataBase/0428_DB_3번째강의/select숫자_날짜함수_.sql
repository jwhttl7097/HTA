-- �����Լ�
select 
    round(1.4), -- 1, �ݿø�
    trunc(1.4), -- 1, �Ҽ��� ����
    ceil(1.4),  -- 2, ������ ���ں��� ���ų� ū ���� �߿��� ���� ���� ���� ��ȯ
    floor(1.4)  -- 1, ������ ���ں��� ���ų� ���� ���� �߿��� ���� ū ���� ��ȯ
    -- ceil�� floor�� õ��� �ٴ��� �����ϸ� �� 1.4�հ� �̷��� ���� ���
    -- ceil�� õ�尪 floor�� �ٴڰ����� �����ϸ� ��
from dual;

select 
    round(1.8), -- 2
    trunc(1.8), -- 1
    ceil(1.8),  -- 2
    floor(1.8)  -- 1
from dual;

select 
    round(1234.56789,4), -- 1234.5679 �Ҽ������� 5��° �ڸ����� �ݿø�
    round(1234.56789,3), -- 1234.568  �Ҽ������� 4��° �ڸ����� �ݿø�
    round(1234.56789,2), -- 1234.57   �Ҽ������� 3��° �ڸ����� �ݿø�
    round(1234.56789,1), -- 1234.6    �Ҽ������� 2��° �ڸ����� �ݿø�
    round(1234.56789,0), -- 1235      �Ҽ������� 1��° �ڸ����� �ݿø�
    round(1234.56789,-1),-- 1230      ���� �ڸ����� �ݿø�
    round(1234.56789,-2),-- 1200      ���� �ڸ����� �ݿø�
    round(1234.56789,-3) -- 1000      ���� �ڸ����� �ݿø�
from dual;

select 
    trunc(1234.56789,4), -- 1234.5678 �Ҽ������� 4��° �ڸ����� ����� ����
    trunc(1234.56789,3), -- 1234.567  �Ҽ������� 3��° �ڸ����� ����� ����
    trunc(1234.56789,2), -- 1234.56   �Ҽ������� 2��° �ڸ����� ����� ����
    trunc(1234.56789,1), -- 1234.5    �Ҽ������� 1��° �ڸ����� ����� ����
    trunc(1234.56789,0), -- 1234      �Ҽ����κ� ���� ����
    trunc(1234.56789,-1),-- 1230      ���� �ڸ� ����
    trunc(1234.56789,-2),-- 1200      ���� �ڸ� ����
    trunc(1234.56789,-3) -- 1000      ���� �ڸ� ����
from dual;

-- ��¥ ���� �Լ�
-- sysdate : �ý����� ���� ��¥ �ð����� ��ȯ
select sysdate from dual; -- �ý����� ���� ��¥, �ð������� ��ȯ�Ѵ�.

-- months_between(date1, date2) : �� ��¥���� ���� �� ��ȯ
select employee_id, first_name, hire_date, trunc(months_between(sysdate, hire_date))months_between
from employees;

-- ��¥ ����
-- date + ���� -> ��¥ : date���� ���ڸ�ŭ ����� ��¥, ���ڴ� day ��
-- date - ���� -> ��¥ : date���� ���ڸ�ŭ ���� ��¥
-- date - date -> ���� : �� ��¥ ���� day ��
select sysdate + 5, sysdate - 5
from dual;

-- 60�� �μ��� �Ҽӵ� ������� �ش� ������ �ٹ��ϼ� ���
select employee_id, first_name, hire_date, trunc(sysdate - hire_date)
from employees
where department_id = 60;

-- next_day(����) ������ ��¥�� �������� ���� �ֱ� ������ ��¥�� ��ȯ
select sysdate, next_day(sysdate, '��')
from dual;

-- last_day(��¥) : ������ ���� ������ ���ڸ� ��ȯ
select sysdate, LAST_DAY(SYSDATE)
from dual;

-- ������ ����ȯ
select employee_id, salary
from employees
where salary >= 15000;

-- ������ ����ȯ
select employee_id, salary
from employees
where salary >= '15000';    -- ���� '1500' -> ���� 15000���� �ڵ� ��ȯ

select employee_id, first_name, hire_date
from employees
where hire_date > '2007/01/01';  -- ���� '2007/01/01' -> ��¥�� �ڵ� ����ȯ

select employee_id, first_name, hire_date
from employees
where hire_date > '2007-01-01';  -- ���� '2007/01/01' -> ��¥�� �ڵ� ����ȯ

-- ����� ����ȯ
-- ���� -> ����ȭ�� ����
select employee_id, first_name, salary, to_char(salary, '999,999')
       , commission_pct, to_char(commission_pct, '0.99')
from employees
where commission_pct is not null;

-- ��¥ -> ����ȭ�� ���ڿ�
select employee_id, first_name, hire_date,
    to_char(hire_date, 'yyyy'),
    to_char(hire_date, 'mm'),
    to_char(hire_date, 'dd'),
    to_char(hire_date, 'yyyy"��"mm"��"dd"��"day'),
    to_char(hire_date, 'hh:mi:ss'),
    to_char(hire_date, 'hh"��"mi"��"ss"��"')
from employees;

-- ���� -> ����
select '100'+'100' from dual; -- ������ ����ȯ
select to_number('1,000', '9,999') + to_number('1,000', '9,999') from dual; -- ����� ����ȯ

-- ���� -> ��¥
select sysdate - to_date('2020/12/25', 'yyyy/mm/dd') from dual; -- ����� ����ȯ

-- ����� ����ϱ�
select TO_DATE('2018/08/29') + 1000 from dual;

-- nvl �Լ�
select nvl(1000, 0),
       nvl(null, 0)
from dual;

-- null�� ������ ��Ģ���� ����� ������ null�̴�.
select 100 + null, 100 - null, 100*null, 100/null
from dual;

-- employees ���̺��� ��� ���̵�, �̸�, �޿�, �޿�, Ŀ�̼��� ����� �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary, salary*nvl(commission_pct, 0)
from employees;

-- nvl2(�÷� Ȥ�� ��, null�ƴ� �� ��, null�� �� ��)
-- 2��°, 3��° ���� Ÿ���� �����ؾ� �Ѵ�.
-- employees ���̺��� ������̵�, �̸�, �޿�, Ŀ�̼�(�޿��� ���� ���� Ŀ�̼Ǳݾ�)�� ��ȸ�ϱ�
select employee_id, first_name, salary,
    nvl2(commission_pct, salary*commission_pct, 0) commission_1,
    salary*nvl(commission_pct, 0) commission_2
from employees;

-- decode(�÷� Ȥ�� ǥ����, ��1, ǥ����, null)
-- ù��° �Ķ���Ͱ��� ��1�� ��ġ�ϸ� ǥ������ ����� ��ȯ�ǰ�,
--                        ��ġ���� ������ null�� ��ȯ�ȴ�.(null�� ������ �� �ִ�.)

-- decode(�÷� Ȥ�� ǥ����, ��1, ǥ����1, ǥ����2)
-- ù��° �Ķ���Ͱ��� ��1�� ��ġ�ϸ� ǥ����1�� ����� ��ȯ�ǰ�,
--                        ��ġ���� ������ ǥ����2�� ����� ��ȯ�ȴ�.

-- decode(�÷� Ȥ�� ǥ����, ��1, ǥ����1,
--                        ��2, ǥ����2,
--                        ��3, ǥ����3,
--                        ǥ����4)
-- ù��° �Ķ������ ���� ��1�� ��ġ�ϸ� ǥ����1�� ����� ��ȯ�ǰ�,
--                     ��2�� ��ġ�ϸ� ǥ����2�� ����� ��ȯ�ǰ�,
--                     ��3�� ��ġ�ϸ� ǥ����3�� ����� ��ȯ�ǰ�,
--                     ��1/��2/��3 ��ο� ��ġ���� ������ ǥ����4�� ����� ��ȯ�ȴ�.

-- employees���� �Ҽ� �μ����̵� 10, 20, 30�� �ش��ϴ� �������
-- ������̵�, �̸�, �μ����̵�, �޿��� ��ȸ�ϱ�
-- (�μ���ȣ�� 30�� �μ��� �Ҽӵ� ������� �޿��� 20%�� ���ʽ��� �����ϵ��� ��ȸ�ϱ�)
select employee_id, first_name, department_id, salary,
    decode(department_id, 30, salary*0.2) bonus
from employees
where department_id in (10, 20, 30);

-- employees���� �Ҽ� �μ����̵� 10, 20, 30�� �ش��ϴ� �������
-- ������̵�, �̸�, �μ����̵�, �޿��� ��ȸ�ϱ�
-- (10�� �μ��� �޿��� 10%, 20�� �μ��� �޿��� 20%, 30�� �μ��� �޿��� 30%�� ���ʽ��� ����)
select employee_id, first_name, department_id, salary,
    decode(department_id, 10, salary*0.1,
                          20, salary*0.2,
                          30, salary*0.3) bonus
from employees
where department_id in (10, 20, 30);

-- employees���̺��� �������̵� CLERK�� ���ԵǾ� �ִ� ������� ���
-- ��ü ��ձ޿��� 50%�� ���ʽ��� �����ϰ�, �׿ܿ��� ��ü ��ձ޿��� 30%�� ���ʽ��� ������ �����̴�
-- ������̵�, �̸�, ����, ���ʽ��� ����ϱ�
select employee_id, first_name, job_id,
    decode(substr(job_id, 4), 'CLERK', (select trunc(avg(salary)/2) from employees),
                                       (select trunc(avg(salary)*0.3) from employees)) as bonus
from employees;

-- case ��
-- if���� ���� ������ �����Ѵ�.
-- decode�� equal �񱳸� �����ѵ� ���ؼ�, case���� >, >=, <, <= ���� �񱳵� �����ϴ�.
-- case
--     when ���ǽ�1 then ǥ����1
--     when ���ǽ�2 then ǥ����2
--     when ���ǽ�3 then ǥ����3
--                 else ǥ����4
-- end

-- employees ���̺��� �޿��� 20000�޷� �̻� �޴� ��� �޿��� 10%�� ���ʽ��� �����ϰ�,
--                          10000�޷� �̻� �޴� ��� �޿��� 30%�� ���ʽ��� �����ϰ�,
--                            5000�޷� �̻� �޴� ��� �޿��� 50%�� ���ʽ��� �����ϰ�,
--                                           �� �ܴ� �޿��� 75%�� ���ʽ��� �����Ѵ�.
-- ������̵�, �̸�, �޿�, ���ʽ��� ��ȸ�ϱ�(���ʽ��� 10�� �ڸ����� �ݿø� �Ѵ�.)
select employee_id, first_name, salary,
    round(
        case
            when salary >= 20000 then salary * 0.1
            when salary >= 10000 then salary * 0.3
            when salary >= 5000 then salary * 0.5
            else salary*0.75
        end) as bonus
from employees;

-- employees ���̺� ����� ������� �޿��� �������� ����� ��ȸ�Ϸ��� �Ѵ�.
-- �޿��� 20000�̻��� ��� A, 10000�̻��� ��� B, 5000�̻��� ��� C,
--       2500�̻��� ��� D, �׿ܴ� E ������� �����Ѵ�.
-- ������̵�, �̸�, �޿�, �޿������ ��ȸ�ϱ�
SELECT employee_id, first_name, salary, 
    case
        when salary >= 20000 then 'A'
        when salary >= 10000 then 'B'
        when salary >= 5000 then 'C'
        when salary >= 2500 then 'D'
        else 'E'
    end as salaryGrade
from employees;

-- 1
-- employees ���̺��� ������(���)�� ������̵� �ߺ����� ��ȸ�ϱ�

SELECT DISTINCT manager_id
from employees;

-- 2
-- employees ���̺� ��ϵ� ������� �Ҽӵ� �μ����̵� �ߺ����� ��ȸ�ϱ�
-- (�ҼӺμ��� ���� ����� ���ܽ�Ų��.)

select DISTINCT department_id
from employees
where department_id is not null;

--3
-- employees ���̺��� ������̵�, �̸�, �̸����� ��ȸ�ϱ�(�̸����� �ҹ��ڷ� ǥ��)

select employee_id, first_name, lower(email)
from employees;

--4
-- employees ���̺��� �̸��� A�� �����ϴ� ����� ���̵�, �̸��� ��ȸ�ϱ�
select employee_id, first_name
from employees
where first_name like 'A%';

--5
-- employees ���̺��� ��� ������� ���̵�, �̸�, �޿�, ���� �� ������ ��ȸ�ϱ�
-- ���� �Ѽ����� �޿�*12 + (�޿�*12*commission_pct)��.

select employee_id, first_name, salary, (salary*12+(commission_pct)) as �����Ѽ���
from employees;

--6
-- employees ���̺��� 80�� �μ����� �ٹ����� ������� ������̵�, �̸�, �޿�, ������ ��ȸ�ϱ�
-- 14000�̻� 45%, 10000�̻� 42%, 7500�̻� 35%, 5000�̻� 25%, 2000�̻� 9%, �׿ܴ� 0%��.

select employee_id, first_name, salary, 
case 
    when salary >= 14000 then '45%'
    when salary >= 10000 then '42%'
    when salary >= 7500 then '35%'
    when salary >= 5000 then '25%'
    when salary >= 2000 then '9%'
    else '0%'
    end as Tax
from employees
where department_id = 80;

--7
-- employees ���̺��� 50�� �μ����� �ٹ����� ������� �޿��� 15% �λ����� ��,
-- ������̵�, �̸�, �λ��� �޿�, �λ�� �޿�, �λ�� �޿��� �λ��� �޿��� ���̸� ��ȸ�ϱ�
select employee_id, first_name, salary as �λ����޿�, salary+(salary*0.15) as �λ�ȱ޿�,
    (salary+(salary*0.15)) - salary as �λ�޿�����
from employees
where department_id = 50;

-- employees ���̺��� ����� �̸��� 'A'�Ǵ� 'J' �Ǵ� 'M'���� �����ϴ� ����� ���̵�, �̸��� ��ȸ�ϱ�
select first_name
from employees
where first_name like 'A%' or first_name like 'J%' or first_name like 'M%';

-- employees ���̺��� �ٹ��� ������ ���κ��� ���ñ��� �ٹ��� �������� ����ؼ� ��ȸ�ϱ�
-- ������̵�, �̸�, �Ի���, �ٹ��� ������(�������� ������ �ݿø��Ѵ�.)�� ��ȸ�Ѵ�.
select employee_id, first_name, hire_date, round(months_between(sysdate, hire_date))
from employees;

-- employees ���̺��� ������� �޿��� *�� ������ ǥ���Ϸ��� �Ѵ�.
-- *�ϳ��� 1000�޷��� ��Ÿ���ٰ� ���� ��, ����� ���̵�, �̸�, �޿�, *�� ǥ���ϱ�
-- 100 ȫ�浿 3400  ***
-- 101 ������ 15000 ***************
-- 102 ������ 7300  *******
select employee_id, first_name, salary,
    case 
        when length(salary) = 4 then rpad('*', substr(salary, 1, 1), '*')
        when length(salary) = 5 then rpad('*', substr(salary, 1, 2), '*')
    end
from employees;

select employee_id, first_name, salary,
    rpad('*', salary/1000, '*')
from employees;