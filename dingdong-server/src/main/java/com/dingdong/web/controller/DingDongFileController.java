package com.dingdong.web.controller;

import com.dingdong.service.DingDongFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @ApiOperation(value = "文件上传接口")
    @PostMapping("upload")
    public void upload(@RequestParam("Filedata") ArrayList<MultipartFile> uploadFile){
        dingDongFileService.upload(uploadFile);
    }
}
