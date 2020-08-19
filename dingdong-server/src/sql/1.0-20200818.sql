use tcl_user;
ALTER TABLE `plan`
MODIFY COLUMN `total`  decimal(14,2) NULL DEFAULT NULL COMMENT '订单总金额' AFTER `status`,
ADD COLUMN `unit_price`  decimal(14,2) NULL DEFAULT NULL COMMENT '单价' AFTER `total`;
ALTER TABLE `plan`
ADD COLUMN `main_img_id`  bigint(11) NULL DEFAULT NULL COMMENT '主图id' AFTER `unit_price`;



