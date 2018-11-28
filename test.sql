drop table Bus_login;
drop table Booked_Ticket;
drop table Bus_Details;

create table Bus_login(user_name varchar2(20),pwd varchar2(20));
insert into  Bus_login values('admin','admin');
commit;

create table Bus_Details(bId number primary key,bType varchar2(20),fare number(7,2),timing varchar2(20));
insert into Bus_Details values(1,'AC 3x2',500,'10AM');
insert into Bus_Details values(2,'AC 2x2',300,'12PM');
insert into Bus_Details values(3,'Volvo 2x2',1000,'7PM');
commit;
select * from BUS_DETAILS;

create table Booked_Ticket (ticketid number primary key,type varchar2(20),
timing varchar2(20),fare number(7,2),bId number not null,
CONSTRAINT fk_bus
FOREIGN KEY (bId) REFERENCES Bus_Details (bId));