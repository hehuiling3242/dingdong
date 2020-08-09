package com.dingdong.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件model
 */
@ApiModel(value = "文件model")
public class DingDongFile implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "系统生成名称")
    private String uploadedName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;

    @ApiModelProperty(value = "文件类型，1-主图、2-详情图")
    private Integer fileType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
}
