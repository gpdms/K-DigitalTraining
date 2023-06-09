drop table if exists board;
create table board (
	num int auto_increment primary key,
	writer varchar(20),
	title varchar(60),
	content text
);