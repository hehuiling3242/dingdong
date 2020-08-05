package com.dingdong.web.controller;

import com.dingdong.service.DingDongFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 文件控制类
 *
 * @since 2020/8/3
 */
@RestController
@RequestMapping("file")
public class DingDongFileController {

    @Autowired
    private DingDongFileService dingDongFileService;

    @ApiOperation(value = "测试接口")
    @GetMapping("test")
    public String test(@RequestParam("aaa")String aaa)
    {
        return aaa;
    }

    @ApiOperation(value = "批量上传文件接口")
    @PostMapping("batch-upload")
    @ResponseBody
    public void upload(@RequestParam("fileArray") ArrayList<MultipartFile> uploadFile){
        dingDongFileService.batchUpload(uploadFile);
    }

    @ApiOperation(value = "单文件文件上传接口")
    @PostMapping("one-upload")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        dingDongFileService.oneUpload(file,request);
    }

    /*@ApiOperation(value = "单文件文件上传接口")
    @GetMapping("load")
    public void upload(@RequestParam("id") Long id){
        dingDongFileService.oneUpload(file);
    }*/


}
