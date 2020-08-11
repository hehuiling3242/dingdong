package com.dingdong.domain.query;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * 地区,邮编号码表查询对象
 */
public class PubRegionQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 15967597430381L;


	@ApiModelProperty("按照国家规则的统一编码来")
	private Collection<String> codeArray;//按照国家规则的统一编码来

	@ApiModelProperty("上一级地区的编码")
	private String parentCode;//上一级地区的编码

	@ApiModelProperty("地区名字")
	private String regionName;//地区名字

    @ApiModelProperty("地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区")
    private Integer regionType;

	@ApiModelProperty("地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区")
	private String regionTypeFrom;//地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区

	@ApiModelProperty("地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区")
	private String regionTypeTo;//地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区

	@ApiModelProperty("1、正常 -1、失效")
	private String status;//1、正常 -1、失效

	@ApiModelProperty("1、正常 -1、失效")
	private Collection<String> statusArray;//1、正常 -1、失效

	@ApiModelProperty("区域别名")
	private String abbname;//区域别名

	@ApiModelProperty("邮编")
	private String postCode;//邮编

    /***按照国家规则的统一编码来*/
    public Collection<String> getCodeArray() {
        return codeArray;
    }

    /***按照国家规则的统一编码来*/
    public void setCodeArray(Collection<String> codeArray) {
        this.codeArray = codeArray;
    }

    /***上一级地区的编码*/
    public String getParentCode() {
        return parentCode;
    }

    /***上一级地区的编码*/
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /***地区名字*/
    public String getRegionName() {
        return regionName;
    }

    /***地区名字*/
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /***地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区*/
    public Integer getRegionType() {
        return regionType;
    }

    /***地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区*/
    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    /***地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区*/
    public String getRegionTypeTo() {
        return regionTypeTo;
    }

    /***地区类型，0：国家，1： 省份/直辖市，2：市，3：县/区*/
    public void setRegionTypeTo(String regionTypeTo) {
        this.regionTypeTo = regionTypeTo;
    }

    /***1、正常 -1、失效*/
    public String getStatus() {
        return status;
    }

    /***1、正常 -1、失效*/
    public void setStatus(String status) {
        this.status = status;
    }

    /***1、正常 -1、失效*/
    public Collection<String> getStatusArray() {
        return statusArray;
    }

    /***1、正常 -1、失效*/
    public void setStatusArray(Collection<String> statusArray) {
        this.statusArray = statusArray;
    }

    /***区域别名*/
    public String getAbbname() {
        return abbname;
    }

    /***区域别名*/
    public void setAbbname(String abbname) {
        this.abbname = abbname;
    }

    /***邮编*/
    public String getPostCode() {
        return postCode;
    }

    /***邮编*/
    public void setPostCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
