package com.dingdong.domain.vo;

import com.dingdong.domain.model.User;
import io.swagger.annotations.ApiModelProperty;

public class UserVO extends User {

    @ApiModelProperty(value = "全地址")
    private String fullAddress;

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
