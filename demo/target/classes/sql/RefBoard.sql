create SEQUENCE ref_board_bno start with 1 INCREMENT BY 1 NOMAXVALUE;
select * from MEMBER_MANAGEMENT_TBL;
drop table ref_board_tbl;

create table ref_board_tbl(
    bno number,
    userName varchar2(20) not null,
    relationship varchar2(10) not null,
    title varchar2(50) not null,
    content CLOB not null,
    registerDate date not null
    );
    
alter table ref_board_tbl
ADD CONSTRAINT ref_board_tbl_pk  PRIMARY KEY (bno) ;


insert into ref_board_tbl values(ref_board_bno.nextval,'조현일','친구','그는','좋은 친구', sysdate);

select * from ref_board_tbl where username='tester123';

select * from ref_board_tbl where bno>0
