drop sequence bd_seq;
drop table board;

create sequence bd_seq nocache;

create table board(
	bd_no number primary key,
	bd_name varchar(100) not null,
	bd_title varchar(200) not null,
	bd_content varchar(4000) not null,
	bd_date date not null

);

insert into board values(bd_seq.nextval, '이름','제목테스트','글내용테스트',sysdate);