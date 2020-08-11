package com.dingdong.domain.query;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "基础查询对象")
public class BaseQuery implements Serializable {

    @ApiModelProperty(value = "当前是第几页")
    private int pageNo; // 当前是第几页，从1开始记数
    @ApiModelProperty(value = "每页展示多少条")
    private int pageSize; // 每页多少条
    @ApiModelProperty(value = "排序")
    private String sort; // 排序表达式

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
