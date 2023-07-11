create database if not exists db3;
use db3;

create table user
(
    id   int auto_increment primary key,
    name varchar(20) not null
);

create table role
(
    id   int auto_increment primary key,
    name varchar(20) not null
);

create table permission
(
    id   int auto_increment primary key,
    name varchar(20) not null
);

insert into user
values (1, 'y'),
       (2, 'h'),
       (3, 'z');

insert into role
values (1, '管理员'),
       (2, '学生'),
       (3, '游客');

insert into permission
values (1, '教学'),
       (2, '上课'),
       (3, '吃饭'),
       (4, '旁听');

create table user_role
(
    id      int auto_increment primary key,
    user_id int,
    role_id int,
    constraint fk_courseid foreign key (user_id) references user (id),
    constraint fk_roleid foreign key (role_id) references role (id)
);

insert into user_role
values (null, 1, 1),
       (null, 1, 2),
       (null, 1, 3),
       (null, 2, 2),
       (null, 3, 2);

create table role_permission
(
    id            int auto_increment primary key,
    role_id       int,
    permission_id int,
    constraint fk_roleid2 foreign key (role_id) references role (id),
    constraint fk_permissionid foreign key (permission_id) references permission (id)
);

insert into role_permission
values (null, 1, 1),
       (null, 1, 2),
       (null, 1, 3),
       (null, 1, 4),
       (null, 2, 2),
       (null, 2, 3),
       (null, 3, 4);
