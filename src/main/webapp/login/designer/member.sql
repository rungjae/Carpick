--alter session set "_oracle_script"=true;
--create user servlet identified by java;
--grant connect, resource, unlimited tablespace to servlet;
--conn servlet/java;

drop table MEMBER;
drop sequence MEMBER_SEQ;

CREATE TABLE MEMBER( 
   SEQ NUMBER, 
   NAME VARCHAR2(30),
   EMAIL VARCHAR2(50) constraint MEMBER_PK PRIMARY KEY,
   PWD VARCHAR2(30), 
   PHONE VARCHAR2(50), 
   RDATE DATE default SYSDATE, 
   UDATE DATE default SYSDATE); 
   
CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into MEMBER values(MEMBER_SEQ.nextval, 'ȫ�浿',  'hong@hanmail.net', '1234', '0101231234', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '�̼���',  'lee@hanmail.net', '1234',  '0101231235', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '������',  'gang@hanmail.net', '1234',  '0101231236', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '�ѿ���',  'han@hanmail.net', '1234',  '0101231237', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '�嵿��', 'jang@hanmail.net', '1234',  '0101231238', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '�մ�',  'guest@hanmail.net','1234',  '0101231239', SYSDATE, SYSDATE);
commit;

select * from MEMBER order by SEQ desc;

