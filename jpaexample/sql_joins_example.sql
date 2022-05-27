create database hsctraining;

use hsctraining;

create table movies (
id bigint NOT NULL auto_increment,
title varchar(255) not null,
category varchar(255) not null,
primary key (id)

);

create table members (
id bigint NOT NULL auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
movie_id bigint default null,
primary key (id),
FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE

);


select * from movies;

select * from members;

INSERT INTO `hsctraining`.`movies`
(
`title`,
`category`)
VALUES
(
'MATRIX1',
'Action');

INSERT INTO `hsctraining`.`movies`
(
`title`,
`category`)
VALUES
(
'MATRIX2',
'Action');

INSERT INTO `hsctraining`.`movies`
(
`title`,
`category`)
VALUES
(
'MATRIX3',
'Action');

INSERT INTO `hsctraining`.`movies`
(
`title`,
`category`)
VALUES
(
'Conjuring',
'Horror');

INSERT INTO `hsctraining`.`movies`
(
`title`,
`category`)
VALUES
(
'Titanic',
'Drama');

INSERT INTO `hsctraining`.`movies`
(
`title`,
`category`)
VALUES
(
'Finding Nemo',
'Animations');

--  Members Insert

INSERT INTO `hsctraining`.`members`
(
`first_name`,
`last_name`,
`movie_id`)
VALUES
(
'Ritesh',
'Singh',
1);


INSERT INTO `hsctraining`.`members`
(
`first_name`,
`last_name`,
`movie_id`)
VALUES
(
'Nitesh',
'Singh',
2);

INSERT INTO `hsctraining`.`members`
(
`first_name`,
`last_name`,
`movie_id`)
VALUES
(
'Sapna',
'Singh',
3);

INSERT INTO `hsctraining`.`members`
(
`first_name`,
`last_name`,
`movie_id`)
VALUES
(
'Sugandha',
'Singh',
null);



select members.*,movies.*
from movies 
INNER JOIN 
members 
on movies.id = members.movie_id;

select movies.*,members.*
from movies 
left outer JOIN 
members 
on movies.id = members.movie_id;

select members.*,movies.*
from movies 
right outer JOIN 
members 
on movies.id = members.movie_id;








