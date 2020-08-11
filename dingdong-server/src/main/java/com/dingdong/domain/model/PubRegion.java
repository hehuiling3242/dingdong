package com.dingdong.domain.model;

import io.swagger.annotations
        .ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 地区,邮编号码表实体类
 */
public class PubRegion implements Serializable {
	private static final long serialVersionUID = 15967597430382L;


	@ApiModelProperty("按照国家规则的统一编码来")
	private String code;//按照国家规则的统一编码来

    @ApiModelProperty("上一级地区的编码")
	private String parentCode;//上一级地区的编码

    @ApiModelProperty("地区名字")
	private String regionName;//地区名字

    /**
     * @see com.dingdong.domain.enums.PubRegionTypeEnum
     */
    @ApiModelProperty("地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区")
	private String regionType;//地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区

    @ApiModelProperty("1、正常 -1、失效")
	private String status;//1、正常 -1、失效

    @ApiModelProperty("区域别名")
	private String abbname;//区域别名

    @ApiModelProperty("邮编")
	private String postCode;//邮编

    @ApiModelProperty(value = "下级地区", hidden = true)
    private List<PubRegion> children;


    public PubRegion() {
    }

    /**
     * @param code -- 按照国家规则的统一编码来
     */
    public PubRegion(String code) {
        this.code = code;
    }

    /**
     * 按照国家规则的统一编码来
     */
    public String getCode() {
        return code;
    }

    /**
     * 按照国家规则的统一编码来
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 上一级地区的编码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 上一级地区的编码
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 地区名字
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 地区名字
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区
     */
    public String getRegionType() {
        return regionType;
    }

    /**
     * 地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区
     */
    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    /**
     * 1、正常 -1、失效
     */
    public String getStatus() {
        return status;
    }

    /**
     * 1、正常 -1、失效
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 区域别名
     */
    public String getAbbname() {
        return abbname;
    }

    /**
     * 区域别名
     */
    public void setAbbname(String abbname) {
        this.abbname = abbname;
    }

    /**
     * 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<PubRegion> getChildren() {
        return children;
    }

    public void setChildren(List<PubRegion> children) {
        this.children = children;
    }
}
