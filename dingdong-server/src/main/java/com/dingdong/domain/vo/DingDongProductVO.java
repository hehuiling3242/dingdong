package com.dingdong.domain.vo;

import com.dingdong.domain.model.DingDongProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import com.dingdong.domain.enums.*;

@ApiModel(value = "dingdong商品VO")
public class DingDongProductVO extends DingDongProduct {

    @ApiModelProperty(value = "text")
    private String text;

    public String getText() {
        if(null == getStatus()){
            return null;
        }

        DingDongProductStatusEnum dingDongProductStatusEnum = DingDongProductStatusEnum.valueOf(getStatus());
        if(null == dingDongProductStatusEnum){
            return null;
        }

        return dingDongProductStatusEnum.getText();
    }
}

