create table user
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(20)                  not null comment '用户名',
    password    varchar(32)                  not null comment '密码',
    nickname    varchar(10)  default '小*批' null comment '昵称',
    email       varchar(128) default ''      null comment '邮箱',
    user_pic    varchar(128) default ''      null comment '头像',
    creat_time  datetime                     not null comment '注册时间',
    update_time datetime                     not null comment '更新时间',
    constraint username
        unique (username)
)
    comment '用户表';

