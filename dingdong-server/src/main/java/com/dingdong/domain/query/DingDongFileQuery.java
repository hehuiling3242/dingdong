package com.dingdong.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;

@ApiModel(value = "文件查询对象")
public class DingDongFileQuery extends BaseQuery{

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "idArray")
    private Collection<Long> idArray;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "系统生成名称")
    private String uploadedName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Long> getIdArray() {
        return idArray;
    }

    public void setIdArray(Collection<Long> idArray) {
        this.idArray = idArray;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedName() {
        return uploadedName;
    }

    public void setUploadedName(String uploadedName) {
        this.uploadedName = uploadedName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
