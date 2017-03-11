CREATE TABLE topics (
    ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created DATE
);
select * from topics;
use topics;
insert into topics values('', "Jmeno", "Popisek", "2017-02-02");
delete from topics;
drop table topics;
