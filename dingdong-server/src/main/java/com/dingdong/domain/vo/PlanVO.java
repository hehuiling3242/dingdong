package com.dingdong.domain.vo;

import com.dingdong.domain.model.Plan;
import io.swagger.annotations.ApiModelProperty;

public class PlanVO extends Plan {

    @ApiModelProperty(value = "收获全地址")
    private String delieverFullAddress;

    public String getDelieverFullAddress() {
        return delieverFullAddress;
    }

    public void setDelieverFullAddress(String delieverFullAddress) {
        this.delieverFullAddress = delieverFullAddress;
    }
}
