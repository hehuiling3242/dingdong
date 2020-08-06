package com.dingdong.domain.vo;

import com.dingdong.domain.model.DingDongFile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "dingdong文件VO")
public class DingDongFileVO extends DingDongFile {

    @ApiModelProperty(value = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
