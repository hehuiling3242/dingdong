package com.dingdong.web.controller;

import com.dingdong.domain.model.PubRegion;
import com.dingdong.service.PubRegionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地区控制类控制类
 * @author pjl
 * @since 2020/08/11
 */
@RestController
@RequestMapping("pub-region")
public class PubRegionController {

    @Autowired
    private PubRegionService pubRegionService;


    @ApiOperation(value = "获取全路径")
    @GetMapping("all-level")
    public List<PubRegion> allLevel(){
        return pubRegionService.getAllLevel();
    }
}
