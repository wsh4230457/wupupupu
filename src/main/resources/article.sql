create table article
(
    id               int unsigned auto_increment comment '文章ID'
        primary key,
    title            varchar(30)               not null comment '文章标题',
    content          varchar(1000)             not null comment '文章内容',
    cover_img        varchar(128)              not null comment '文章封面',
    state            varchar(3) default '草稿' null comment '文章状态：只能是已发布或者草稿',
    category_belongs int unsigned              not null comment '所属分类id',
    create_user      int unsigned              not null comment '文章发布者id',
    create_time      datetime                  not null comment '创建时间',
    update_time      datetime                  not null comment '更新时间',
    constraint fk_article_category
        foreign key (category_belongs) references category (id),
    constraint fk_article_user
        foreign key (create_user) references user (id)
);

