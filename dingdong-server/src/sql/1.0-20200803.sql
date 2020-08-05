CREATE TABLE `file` (
`id`  bigint(11) NOT NULL COMMENT '主键id' ,
`file_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文件名称' ,
`uploaded_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文件上传后的名称(在磁盘中的名称)' ,
`file_path`  varchar(255) NOT NULL DEFAULT '' COMMENT '文件在磁盘的中路径' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='文件表';


ALTER TABLE `file`
ADD COLUMN `upload_date`  datetime NULL DEFAULT NULL COMMENT '上传时间' AFTER `file_path`;

ALTER TABLE `dingdong`.`file`
ADD COLUMN `product_id` bigint(11) NULL COMMENT '商品id' AFTER `upload_date`;

ALTER TABLE `file`
MODIFY COLUMN `id`  bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id' FIRST ;





