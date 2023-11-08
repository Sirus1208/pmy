create table if not exists `todo` (
  `id` bigint(20) unsigned not null auto_increment comment 'ID',
  `title` varchar(30) not null comment 'タイトル',
  `deadline` date not null comment '期日',
  `status` tinyint(1) not null default '0' comment 'ステータス',
  `create_time` datetime not null default current_timestamp comment '作成日時',
  `update_time` datetime not null default current_timestamp on update current_timestamp comment '更新日時',
  primary key (`id`),
  unique key `title_unique` (`title`)
) engine=innodb default charset=utf8mb4 comment='todoテーブル';