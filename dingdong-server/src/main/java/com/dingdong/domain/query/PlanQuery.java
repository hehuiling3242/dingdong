package com.dingdong.domain.query;

import io.swagger.annotations
		.ApiModelProperty;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * 订单表查询对象
 */
public class PlanQuery extends BaseQuery implements Serializable {
	private static final long serialVersionUID = 15959997036811L;


	@ApiModelProperty("id")
	private Long id;

	@ApiModelProperty("主键id")
	private Collection<Long> idArray;//主键id

	@ApiModelProperty("下单日")
	private Date planDateFrom;//下单日

	@ApiModelProperty("下单日")
	private Date planDateTo;//下单日

	@ApiModelProperty("下单人id")
	private Long userId;//下单人id

	@ApiModelProperty("下单人")
	private String userName;//下单人

	@ApiModelProperty("下单人真实姓名")
	private String userRealName;//下单人真实姓名

	@ApiModelProperty("商品id")
	private Long productId;//商品id

	@ApiModelProperty("商品名称")
	private String productName;//商品名称

	@ApiModelProperty("下单数量")
	private Integer planCount;//下单数量

    /**
     * @see com.dingdong.domain.enums.PlanStatusEnum
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

	@ApiModelProperty("收货地址省级code")
	private String deliverProvinceCode;//收货地址省级code

	@ApiModelProperty("收货地址市级code")
	private String deliverCityCode;//收货地址市级code

	@ApiModelProperty("收货地址区级code")
	private String deliverRegionCode;//收货地址区级code

	@ApiModelProperty("详细收货地址")
	private String deliverAddress;//详细收货地址

    /***主键id*/
    public Collection<Long> getIdArray() {
        return idArray;
    }

    /***主键id*/
    public void setIdArray(Collection<Long> idArray) {
        this.idArray = idArray;
    }

    /***下单日*/
    public Date getPlanDateFrom() {
        return planDateFrom;
    }

    /***下单日*/
    public void setPlanDateFrom(Date planDateFrom) {
        this.planDateFrom = planDateFrom;
    }

    /***下单日*/
    public Date getPlanDateTo() {
        return planDateTo;
    }

    /***下单日*/
    public void setPlanDateTo(Date planDateTo) {
        this.planDateTo = planDateTo;
    }

    /***下单人id*/
    public Long getUserId() {
        return userId;
    }

    /***下单人id*/
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /***下单人*/
    public String getUserName() {
        return userName;
    }

    /***下单人*/
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /***下单人真实姓名*/
    public String getUserRealName() {
        return userRealName;
    }

    /***下单人真实姓名*/
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /***商品id*/
    public Long getProductId() {
        return productId;
    }

    /***商品id*/
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /***商品名称*/
    public String getProductName() {
        return productName;
    }

    /***商品名称*/
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /***下单数量*/
    public Integer getPlanCount() {
        return planCount;
    }

    /***下单数量*/
    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    /***收货地址省级code*/
    public String getDeliverProvinceCode() {
        return deliverProvinceCode;
    }

    /***收货地址省级code*/
    public void setDeliverProvinceCode(String deliverProvinceCode) {
        this.deliverProvinceCode = deliverProvinceCode;
    }

    /***收货地址市级code*/
    public String getDeliverCityCode() {
        return deliverCityCode;
    }

    /***收货地址市级code*/
    public void setDeliverCityCode(String deliverCityCode) {
        this.deliverCityCode = deliverCityCode;
    }

    /***收货地址区级code*/
    public String getDeliverRegionCode() {
        return deliverRegionCode;
    }

    /***收货地址区级code*/
    public void setDeliverRegionCode(String deliverRegionCode) {
        this.deliverRegionCode = deliverRegionCode;
    }

    /***详细收货地址*/
    public String getDeliverAddress() {
        return deliverAddress;
    }

    /***详细收货地址*/
    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
