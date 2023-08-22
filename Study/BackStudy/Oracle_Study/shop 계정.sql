show user;

-- ShopMiniMall 실습
-- 2. member table 생성
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
