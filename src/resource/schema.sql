--- Create table USERS------------
create table USERS
(
  ID         NUMBER(10) not null,
  INPUT_DATE TIMESTAMP(6),
  USER_NAME  VARCHAR2(255 CHAR)
);
alter table USERS add primary key (ID) using index; 