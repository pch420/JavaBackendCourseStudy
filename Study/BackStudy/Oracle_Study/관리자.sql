-- �ּ���, ��ҹ��� ��������, ���� ���� ; ����.

show user;

-- hr ���� lock Ǯ�� ��� hr ����
alter user hr identified by hr; 
alter user hr identified by hr account unlock;

-- workshop ���� ���� �� ���� �ο�
-- workshop ���� ����
create user workshop identified by workshop;
-- ���� �ο�
grant resource, connect to workshop;