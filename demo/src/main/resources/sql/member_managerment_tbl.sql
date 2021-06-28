select sysdate from dual;

create table member_management_tbl(
    username varchar2(20) not null,
    password varchar2(20) not null,
    email varchar2(30) not null,
    auth varchar2(10) not null
    );
    
alter table member_management_tbl
add constraint member_management_tbl_pk PRIMARY KEY(username);

commit;