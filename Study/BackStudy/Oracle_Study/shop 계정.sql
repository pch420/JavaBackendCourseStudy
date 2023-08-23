SHOW USER;

-- ShopMiniMall �ǽ�
-- 2. member table ���� 
create table member
   ( userid varchar2(20) CONSTRAINT member_userid_pk PRIMARY KEY,
     passwd varchar2(20) not null,
     username varchar2(20) not null,
     post varchar2(6) not null,
     addr1 varchar2(500) not null,
     addr2 varchar2(500) not null,
     phone1 varchar2(3) not null,
     phone2 varchar2(4) not null,
     phone3 varchar2(4) not null,
     email1 varchar2(20) not null,
     email2 varchar2(20) not null
    );
    
--- 3. ��ǰ ��� goods table ����
-- TOP , DRESS , OUTER , BOTTOM
   create table goods
   ( gCode varchar2(20) PRIMARY KEY, --��ǰ�ڵ�
     gCategory varchar2(20) not null,
     gName varchar2(50) not null,
     gContent varchar2(4000) not null,
     gPrice NUMBER(6) not null,
     gImage varchar2(20) not null );
     
insert into goods 
  values ('T1',	'top', '�ٸ��� ���� ž',	'��Ƽ���� ������ ���� ���� �����꽺 ž', '12100', 'top1');
  insert into goods 
  values ('T2',	'top', '������ ���� ���콺',	'���������� ���ð� ������ �������� ��������� ��', '12100', 'top2');
  insert into goods 
  values ('T3',	'top', '�Ⱦ� ���� ��Ʈ Ʃ��',	'�Ϳ��� �ɸ����� ��Ʈ ������ Ʃ��', '12800', 'top3');
  insert into goods 
  values ('T4',	'top', '��ŰŸ ��Ī ��Ʈ ž',	'�������� �����ο� ��Ī���� �������� �� ��Ʈž', '8800', 'top4');
  insert into goods 
  values ('T5',	'top', '��Ī ��Ʈ������ ���̾�� ž',	'��Ī�� ��Ʈ������ ������ �ý��� ���̾�� ž', '11800', 'top5');
  insert into goods 
  values ('T6',	'top', 'Ŭ�ο� ������ ���� ũ�� ž',	'������ �������� �Ҹ� ���� ����Ʈ', '9800', 'top6');
  insert into goods 
  values ('T7',	'top', '�ø���� ��߶��� ��Ʈ ž',	'������ ������ ��Ʈ ������ ���̳� ��Ʈ ž', '9800', 'top7');
  insert into goods 
  values ('T8',	'top', '�� ���� ��� üũ ���콺',	'�Ϳ��� ���� �������� ��� üũ ���콺', '12800', 'top8');
   insert into goods 
  values ('T9',	'top', '�� ���̽� ���� �ϵ� ��ũ ��Ʈ',	'�� �� ���� �ڼ��� ������������~~', '29800', 'top9');
  insert into goods 
  values ('T10',	'top', 'Ȧ ���� ���� ������ ����',	'������ ������ ����ϰ� �Ա� ���ƿ�', '27800', 'top10');
  insert into goods 
  values ('T11',	'top', '������ ���̽� ���̾�� ���콺',	'��� ���̵� ��ġ�ϸ� ��̴ѷ� �ϼ�', '26800', 'top11');
  insert into goods 
  values ('T12',	'top', '���̽� ���� Ʈ���� ���콺',	'ī��� ������ο� ���̽� ���������� ����Ʈ�� �� ���� ���콺', '26800', 'top12');
  
  insert into goods 
  values ('D1',	'dress', '�ε�� ���� ��ƽ �ϵ� �巹��',	'���� �½� ���� ǳ���� ���� ������ ���ǽ�', '37800', 'dress1');
  insert into goods 
  values ('D2',	'dress', '���Ǿ� ��Ʈ ��Ʈ �巹��',	'����ϸ鼭 ��̴��� �������� ��Ʈ ���ǽ�', '36800', 'dress2');
  insert into goods 
  values ('D3',	'dress', '��ŸŰ�� ��Ÿ�� �÷��� ���� �巹��',	'�÷��� �������� �Ϳ��� ������ ��Ÿ���� ���� ���ǽ�', '34800', 'dress3');
  insert into goods 
  values ('D4',	'dress', '�������� ��� ��ư �巹��',	'��� ��ư ����� ����Ʈ�� �÷��� �̵� �巹��', '33800', 'dress4');

  insert into goods 
  values ('D5',	'dress', '�� ���� ���̽� �巹��',	'������ �Ҹ� ������ ��������!!', '24800', 'dress5');
  insert into goods 
  values ('D6',	'dress', '�޽� Ʈ����Ʈ �� �巹��',	'������� ���ǽ�!', '24800', 'dress6');
  insert into goods 
  values ('D7',	'dress', '���� ���콺 üũ �巹��',	'�Ϳ��� ������ ����� ���콺�� üũ ���ǽ�', '23800', 'dress7');
  insert into goods 
  values ('D8',	'dress', '��̴� �÷� ��Ʈ �巹��',	'������������ ���� ���������� ���̴� ���ǽ�', '23800', 'dress8');
  
  insert into goods 
  values ('D9',	'dress', '���� ���̽� ���� ��Ʈ',	'���������� �������� ��Ʈ ��ǰ', '20800', 'dress9');
  insert into goods 
  values ('D10',	'dress', '�� ������ ��Ʈ������ ��Ʈ',	'��������� ������ �ǳ����� ���ǽ� ��Ʈ', '20400', 'dress10');
  insert into goods 
  values ('D11',	'dress', '�����ں��� ����Ƽ�� �巹�� ��Ʈ',	'���� ������ ���ǽ��� ���� �߽�Ƽ�� ��Ʈ', '19800', 'dress11');
  insert into goods 
  values ('D12',	'dress', 'ǻ�� ��Ʈ������ �÷��� �巹��',	'û���ϸ鼭 ���������� ��Ÿ���� ��Ʈ������ ���ǽ�', '19800', 'dress12');
  
   insert into goods 
  values ('O1',	'outer', '���� ��ư ������',	'��޽����� ������ ��ī�� ������ ����', '52800', 'outer1');
  insert into goods 
  values ('O2',	'outer', '���� ��ư ������ ����Ʈ',	'�ε巯�� ������ ������ ��Ÿ�� ����Ʈ', '52800', 'outer2');
  insert into goods 
  values ('O3',	'outer', '���� Ʈ��ġ ����',	'Ŭ������ ���� Ʈ��ġ ����', '51800', 'outer3');
  insert into goods 
  values ('O4',	'outer', 'Ÿ�� ������ ����',	'����� ��Ÿ�Ͽ� �������� ������ ����', '48800', 'outer4');

  insert into goods 
  values ('O5',	'outer', '�Ľ��� �� ���� �� ��Ʈ',	'�ε巯�� ����� �Ľ������� ����ư ��Ʈ', '45800', 'outer5');
  insert into goods 
  values ('O6',	'outer', 'Ƽ�� �� ��ư �� ������',	'ȭ���� �÷����� �����̴� ����ϰ� ������ ������', '41800', 'outer6');
  insert into goods 
  values ('O7',	'outer', 'Ʈ��ġ ���� ���� ����',	'Ŭ������ Ʈ��ġ ������ ���� ����', '39800', 'outer7');
  insert into goods 
  values ('O8',	'outer', '������ Ʈ��ġ ��Ʈ',	'��޽����� �÷����� �������� Ʈ��ġ ��Ʈ', '39800', 'outer8');

   insert into goods 
  values ('O9',	'outer', '���и� ���� �� ����',	'���� �������� ������ ����', '31800', 'outer9');
  insert into goods 
  values ('O10',	'outer', '��Ű ���콺 ����Ʈ ������ �����',	'��Ű�ڼ��� ������ �ִ� ������ �����', '30800', 'outer10');
  insert into goods 
  values ('O11',	'outer', '������ũ ��Ų ���� ���̴� ����',	'�����ִ� ���ǹ����� ���̴� ����', '29800', 'outer11');
  insert into goods 
  values ('O12',	'outer', 'ž �� �� �װ� ����',	'���͸��ڼ��� ��ġ�� Ʈ������ �� �װ�����', '29800', 'outer12');

   insert into goods 
  values ('B1',	'bottom', '���� ���̽� ��ĿƮ',	'��̴��� ���̽� �ڼ��� �ڽ����� ��ĿƮ', '9800', 'bottom1');
  insert into goods 
  values ('B2',	'bottom', '���̽� ������ ��ĿƮ',	'��ũ�ϸ鼭 Ʈ������ ������ ���̽� ��ĿƮ', '9800', 'bottom2');
  insert into goods 
  values ('B3',	'bottom', '���� ���̵� ����',	'���༺ �ִ� ������ ���̵� �� ����', '9800', 'bottom3');
  insert into goods 
  values ('B4',	'bottom', '��긮�� H���� ��ĿƮ',	'������ �����ο� H���� �̴� ��ĿƮ', '9800', 'bottom4');
  
  insert into goods 
  values ('B5',	'bottom', '���ϸ� �� ��ĿƮ',	'���ϸ��� �Ա� ���� ������ ������ �� ��ĿƮ', '9800', 'bottom5');
  insert into goods 
  values ('B6',	'bottom', '�����ͺ� �̴� �÷��� ��ĿƮ',	'�ӹ��� �Ȱ��� �پ��ִ� �������� ��Ÿ���� �÷��� ��ĿƮ', '9800' , 'bottom7');
  insert into goods 
  values ('B7',	'bottom', '���� �÷� �ĵ� Ʈ���̴� ��Ʈ',	'�����ϰ� �Ա� ���� Ʈ���̴� ��Ʈ', '9800', 'bottom7');
  insert into goods 
  values ('B8',	'bottom', '�Ḯ�� ���� �̵� ��ĿƮ',	'��ŭ�� ������ �����̴� �̵� �÷��� ��ĿƮ', '10800', 'bottom8');
  
   insert into goods 
  values ('B9',	'bottom', '��Ű �ø��� �̴� ��ĿƮ',	'�Ϳ��� ��������� ���ο� �ø��� �̴� ��ĿƮ', '11800', 'bottom9');
  insert into goods 
  values ('B10',	'bottom', '�Ƹ��� ���� �÷��� ��ĿƮ',	'�ڿ������� �ָ��� �ŷ����� �÷��� ��ĿƮ', '11800', 'bottom10');
  insert into goods 
  values ('B11',	'bottom', '�ø��� ��ĿƮ ���뽺',	'��̴��� ������ �ø��� �ָ� ���뽺', '11800', 'bottom11');
  insert into goods 
  values ('B12',	'bottom', '���̽� �̵� ��ĿƮ',	'���������� ���̽� �̵� ��ĿƮ', '11800', 'bottom12');
  
  commit;
  
  -- cart 
  create table cart
  (  num NUMBER(6) PRIMARY KEY,
     userid VARCHAR2(20),
     gCode varchar2(20) not null,
     gName varchar2(50) not null,
     gPrice NUMBER(6) not null,
     gSize CHAR(1) not null,
     gColor VARCHAR2(10) not null,
     gAmount NUMBER(2) not null,
     gImage varchar2(20) not null
  );   
  alter table cart
  add CONSTRAINT cart_userid_fk FOREIGN KEY(userid)
   REFERENCES member(userid) ON DELETE CASCADE;
   
  alter table cart
  add CONSTRAINT cart_gCode_fk FOREIGN KEY(gCode)
   REFERENCES goods(gCode) ON DELETE CASCADE; 
   
 create sequence cart_seq;