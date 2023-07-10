-- 查看所有数据库
show databases;
/*
 这是多行数据
 */
create database if not exists db2;

drop database if exists db2;

select database();

create table tb_user
(
    id       int primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户',
    name     varchar(10) comment '姓名',
    age      int unsigned comment '年龄',
    gender   char(1) default '中' comment '性别'
) comment '用户表';

create table a_table
(
    username      varchar(20)  not null comment '用户名',
    name          varchar(10)  not null comment '员工姓名',
    gender        char         not null comment '姓名',
    image         varchar(200) null comment '图像',
    job           varchar(20)  null comment '职位',
    date_on_board date         null,
    constraint a_table_pk
        unique (username)
);

show tables;
desc a_table ;
