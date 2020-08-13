package com.dingdong.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Collection;

@ApiModel(value = "dingdong用户查询对象")
public class UserQuery extends BaseQuery {
    @ApiModelProperty("用户id")
    private int id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String passWord;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("生日")
    private String birthday;

    @ApiModelProperty("省级code")
    private String provinceCode;

    @ApiModelProperty("市级code")
    private String cityCode;

    @ApiModelProperty("区级code")
    private String regionCode;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("邮编")
    private String postCode;

    @ApiModelProperty(value = "idArray")
    private Collection<Long> idArray;

    public Collection<Long> getIdArray() {
        return idArray;
    }

    public void setIdArray(Collection<Long> idArray) {
        this.idArray = idArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

}
