package com.dingdong.web.controller;

import com.dingdong.service.DingDongFileService;
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

    @PostMapping("upload")
    public void upload(@RequestParam("Filedata") ArrayList<MultipartFile> uploadFile){
        dingDongFileService.upload(uploadFile);
    }

    @GetMapping("test")
    public String test(){
        return "------测试----------";
    }
}
