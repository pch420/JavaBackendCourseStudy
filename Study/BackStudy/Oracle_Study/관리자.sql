-- 주석문, 대소문자 구별안함, 문장 끝은 ; 끝남.

show user;

-- hr 계정 lock 풀고 비번 hr 설정
alter user hr identified by hr; 
alter user hr identified by hr account unlock;

-- workshop 계정 생성 및 권한 부여
-- workshop 계정 생성
create user workshop identified by workshop;
-- 권한 부여
grant resource, connect to workshop;