
UPDATE `t_permission` SET `parent_id` = NULL, `parent_ids` = NULL, `parent_names` = NULL, `path_depth` = 0, `order_num` = 100, `name` = '系統管理', `scope` = '\"\"', `sn` = 'system', `menu_path` = '/acl', `menu_component` = 'views/acl', `menu_icon` = 'el-icon-s-tools', `menu_meta` = 'a', `enable` = 1, `type` = 1, `remark` = NULL, `create_time` = '2021-08-15 16:54:42', `update_time` = '2021-08-15 17:05:04' WHERE `id` = 1;

INSERT INTO `t_role`(`id`, `name`, `remark`, `create_time`, `update_time`) VALUES (1442736772130934784, '普通管理员', NULL, '2021-09-28 14:23:46', '2021-09-28 14:23:46');
