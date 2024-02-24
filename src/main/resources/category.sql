create table category
(
    id             int unsigned auto_increment comment 'ID'
        primary key,
    category_name  varchar(32)  not null comment '分类名称',
    category_alias varchar(32)  not null comment '分类别名',
    create_user    int unsigned not null comment '创建用户',
    create_time    datetime     not null comment '创建时间',
    update_time    datetime     not null comment '修改时间',
    constraint fk_category_user
        foreign key (create_user) references user (id)
);

