SHOW databases ;
CREATE DATABASE `ssmbuild`;
use ssmbuild;
DROP TABLE if exists `books`;
create table `books` (
                         `bookID` int(10) not null  auto_increment comment '书id',
                         `bookName` VARCHAR(100) not null  comment '书名',
                         `bookCounts` int(10) not null  comment '数量',
                         `detail` VARCHAR(100) not null  comment '描述',
                         primary key (bookID)
)ENGINE =INNODB DEFAULT  CHARSET =utf8;

show tables ;
insert into `books`(`bookID`,`bookName`,`bookCounts`,`detail`) values
(1,'Java',1,'从入门到放弃'),
(2,'MySQL',10,'从删库到跑路'),
(3,'Linux',5,'从进门到进牢');
