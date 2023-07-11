create database db1;
create table tb_emp
(
    id          int primary key auto_increment comment '主键ID',
    username    varchar(20)                  not null comment '用户名',
    password    varchar(32) default '123456' null comment '密码',
    name        varchar(10)                  not null comment '姓名',
    gender      tinyint unsigned             not null comment '性别, 1 男, 2 女',
    image       varchar(300)                 null comment '图像url',
    job         tinyint unsigned             null comment '职位, 1 班主任 , 2 讲师 , 3 学工主管, 4 教研主管',
    entry_date  date                         null comment '入职日期',
    create_time datetime                     not null comment '创建时间',
    update_time datetime                     not null comment '修改时间',
    constraint tb_emp_username_uindex unique (username)
) comment '员工表';
-- DDL: 查看表结构
-- 查看: 当前数据库下的表
show tables;
-- 查看: 查看指定表结构
desc tb_emp;
-- 查看: 数据库的建表语句
show create table tb_emp;
-- DDL: 修改表结构
-- 修改: 为表 tb_emp 添加字段 qq varchar(11)
alter table tb_emp
    add qq varchar(11);
-- 修改: 修改 tb_emp 字段类型 qq varchar(13)
alter table tb_emp
    modify qq varchar(13) null;
-- 修改: 修改 tb_emp 字段名 qq 为 qq_num varchar(13)
alter table tb_emp
    change qq qq_num varchar(11) null;
-- 修改: 删除 tb_emp 的 qq_num 字段
alter table tb_emp
    drop column qq;
-- 修改: 将tb_emp 表名修改为 emp
rename table tb_emp to emp;
-- 修改: 将emp 表名修改为 tb_emp
rename table emp to tb_emp;
-- DDL: 删除表结构

-- 删除: 删除 tb_emp 表
drop table if exists tb_emp;
-- DML : 数据操作语言
-- DML : 插入数据 - insert
-- 1. 为 tb_emp 表的 username, name, gender 字段插入值
insert into tb_emp (username, name, gender, create_time, update_time)
values ('shf', 'fsd', '男', now(), now());
-- 2. 为 tb_emp 表的 所有字段插入值
insert into tb_emp
values (1, 'df', 'sdf', '男', null, null, null, null, null, null, null);
-- 3. 批量为 为 tb_emp 表的 username , name , gender 字段插入数据。一次插入两条记录
insert into tb_emp (username, name, gender)
values ('sh', 'fs', '男'),
       ('fd', 'ghg', '女');