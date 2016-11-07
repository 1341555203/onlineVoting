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
    create_date timestamp not null ,
    cutoff_time timestamp,
    menu_status char(1) not null default '0',	-- 0 投票中 1 暂停 2 截止
    del_flag char(1) not null default '0'		-- 0正常状态   1 冻结状态    9 删除状态
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
  ON UPDATE NO ACTION;

