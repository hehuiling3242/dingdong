package com.dingdong.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * dingdong商品查询对象
 * @author pjl
 * @since 2020/08/07
 *
 */
@ApiModel(value = "dingdong商品查询对象")
public class DingDongProductQuery extends BaseQuery {

    @ApiModelProperty(value = "商品id")
    private Long id;

    @ApiModelProperty(value = "idArray")
    private Collection<Long> idArray;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    /**
     * @see com.dingdong.domain.enums.DingDongProductStatusEnum
     */
    @ApiModelProperty(value = "商品状态")
    private Integer status;

    @ApiModelProperty(value = "状态Array")
    private Collection<Integer> statusArray;

    @ApiModelProperty(value = "类别id")
    private Long classifyId;

    @ApiModelProperty(value = "类别idArray")
    private Collection<Long> classifyIdArray;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "")
    private String digg;

    @ApiModelProperty(value = "")
    private String productAbout;

    @ApiModelProperty(value = "")
    private String detail;

    @ApiModelProperty(value = "")
    private Integer count;

    @ApiModelProperty(value = "")
    private String productShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Long> getIdArray() {
        return idArray;
    }

    public void setIdArray(Collection<Long> idArray) {
        this.idArray = idArray;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public Collection<Long> getClassifyIdArray() {
        return classifyIdArray;
    }

    public void setClassifyIdArray(Collection<Long> classifyIdArray) {
        this.classifyIdArray = classifyIdArray;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDigg() {
        return digg;
    }

    public void setDigg(String digg) {
        this.digg = digg;
    }

    public String getProductAbout() {
        return productAbout;
    }

    public void setProductAbout(String productAbout) {
        this.productAbout = productAbout;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProductShow() {
        return productShow;
    }

    public void setProductShow(String productShow) {
        this.productShow = productShow;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Collection<Integer> getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(Collection<Integer> statusArray) {
        this.statusArray = statusArray;
    }
}
