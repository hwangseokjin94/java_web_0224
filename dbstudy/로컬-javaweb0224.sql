-- �ּ�

-- ����Ŭ ������ Ÿ��
-- 1. ���� NUMBER
-- 2. ���� CHAR ,VARCHAR2
--      1)CHAR : ������(���ڼ��� ũ�⿡ ������ ����������,�ֹε�� ��ȣ,�����ȣ, ���� ��)
--      2)VARCHAR2: ������ �ؽ�Ʈ(���ڼ��� ũ�⿡ ������ ū������,�ּ� ��)
-- 3.��¥ : DATE, TIMESTMAP

--������
--1. F5: ��ũ��Ʈ ��ü����
--2. Ctrl +Enter :������ ��ũ��Ʈ ����
--�μ����̺�
CREATE TABLE department
(
dept_no NUMBER NOT NULL PRIMARY KEY,
dept_name CHAR(10),
dept_loc VARCHAR2(100)
);