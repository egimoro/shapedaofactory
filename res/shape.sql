create database shapesdb;
use shapesdb;

create table square(
squareId int primary key auto_increment,
base int
);

create table rectangle(
rectangleId int primary key,
base int,
height int
);

create table circle(
circleId int primary key,
radius int,
pi double
);

insert into square (base) values (7),(8),(9);
select * from square;
select base,height from rectangle;

select * from circle;
truncate table circle;