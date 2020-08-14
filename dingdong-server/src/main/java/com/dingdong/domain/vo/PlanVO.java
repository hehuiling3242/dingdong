package com.dingdong.domain.vo;

import com.dingdong.domain.enums.PlanStatusEnum;
import com.dingdong.domain.model.Plan;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

public class PlanVO extends Plan {

    @ApiModelProperty(value = "收获全地址")
    private String delieverFullAddress;

    public String getDelieverFullAddress() {
        return delieverFullAddress;
    }

    public void setDelieverFullAddress(String delieverFullAddress) {
        this.delieverFullAddress = delieverFullAddress;
    }

    public String getStstusText(){
        if(null == getStatus()){
            return null;
        }

        PlanStatusEnum planStatusEnum = PlanStatusEnum.valueOf(getStatus());
        return null != planStatusEnum ? planStatusEnum.getText():null;

    }
}
