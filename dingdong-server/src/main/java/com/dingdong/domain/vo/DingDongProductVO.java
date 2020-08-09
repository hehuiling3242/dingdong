package com.dingdong.domain.vo;

import com.dingdong.domain.model.DingDongProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import com.dingdong.domain.enums.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@ApiModel(value = "dingdong商品VO")
public class DingDongProductVO extends DingDongProduct {

    @ApiModelProperty(value = "text")
    private String text;

    @ApiModelProperty(value = "文件ids")
    private Collection<Long> fileIdSet;

    @ApiModelProperty(value = "文件路径")
    private Collection<String> filePaths;

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

    public Collection<Long> getFileIdSet() {
        return fileIdSet;
    }

    public void setFileIdSet(Collection<Long> fileIdSet) {
        this.fileIdSet = fileIdSet;
    }

    public Collection<String> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(Collection<String> filePaths) {
        this.filePaths = filePaths;
    }
}

