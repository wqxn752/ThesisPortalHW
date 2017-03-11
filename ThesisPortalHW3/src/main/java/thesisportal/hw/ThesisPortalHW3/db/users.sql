create database topics;
use topics;
CREATE TABLE topics (
    ID UNSIGNED INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created DATE
);
select * from topics;
select * from topics where id=2;
drop table topics;
insert into topics values('', "Lihnuti mladat kukacky", "Pozorovani okolnosti lihnuti mladat kukacek v cizich hnizdech", "2017-01-02");
insert into topics values('', "Chradnuti jasanu", "Porovnavani odolnosti druhu jasanu proti virum zpusobujicich kradnuti", "2016-06-12");
insert into topics values('', "Samosvorny diferencial", "Pozorovani ubytku lamelovych disku u samosvorneho diferencialu", "2017-02-28");
