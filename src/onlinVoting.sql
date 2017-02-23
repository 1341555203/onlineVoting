/*
用户表
*/
drop table if exists t_user;
create table t_user(
	id int(8) not null auto_increment primary key,
    username varchar(128) not null default 'Zoe',
    email varchar(128) not null,
    password varchar(128) not null,
    gender char(1) not null default '0',  -- 0 女	1 男
    create_date datetime not null,
    update_date timestamp not null,
    user_type char(1) not null default '0', -- 0 普通用户  1 管理员
    del_flag char(1) not null default '0'   -- 0正常状态   1 冻结状态    9 删除状态
);

/*
选单表
*/
drop table if exists t_menu;
create table t_menu(
	id int(8) not null auto_increment primary key,
    menu_title varchar(256) not null default 'n.s',
    menu_discription varchar(512) not null default 'n.s',
    need_pwd varchar(256),
    create_date timestamp not null ,
    cutoff_time timestamp,
    menu_type char(1) not null default '0',     -- 0单选  1 多选
    menu_status char(1) not null default '0',	-- 0 投票中 1 暂停 2 截止 
    del_flag char(1) not null default '0'	,	-- 0正常状态   1 冻结状态    9 删除状态
    created_by int(8) not null
);

/*
选项表
*/
drop table if exists t_option;
create table t_option(
	id int(8) not null auto_increment primary key,
	menu_id  int(8) not null,
    option_title varchar(256) not null,
    del_flag char(1) not null default '0'		-- 0正常状态   1 冻结状态    9 删除状态
    
);
/*
option menu 外键 级联删除
*/
ALTER TABLE `online_voting`.`t_option` 
ADD CONSTRAINT `fk_menu_option`
  FOREIGN KEY (`id`)
  REFERENCES `online_voting`.`t_menu` (`id`)
  ON DELETE CASCADE
;

/*t_user
投票记录表
*/
drop table if exists t_record;
create table t_record(
	id int(8) not null auto_increment primary key ,
    menu_id int(8) not null,
    option_id int(8) not null,
    user_id int(8) not null,
    create_date timestamp
);

/*
图片/附件记录
*/
drop table if exists t_attachment;
create table t_attachment(
	id int(8) not null auto_increment primary key,
    owner_id int(8) not null,					-- 附件所有者id
    owner_type char(1) not null default '0',	-- 所有者类型
    att_name varchar(256) not null,				-- 文件名
    att_origin varchar(256) not null			-- 原始文件名
);

/*
评论表
*/
drop table if exists t_commit;
create table t_commit(
	id int(8) not null auto_increment primary key,
	menu_id int(8) not null,
	user_id int(8) not null,
    content varchar(512) not null default 'n.s',
	create_date timestamp,
	del_flag char(1) not null default '0'		-- 0正常状态      9 删除状态
);
