package com.dingdong.web.controller;

import com.dingdong.domain.model.DingDongProduct;
import com.dingdong.domain.query.DingDongProductQuery;
import com.dingdong.domain.vo.DingDongProductVO;
import com.dingdong.service.DingDongProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品控制类
 *
 * @since 2020/8/3
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private DingDongProductService productService;

    @ApiOperation(value = "queryList")
    @GetMapping("query-list")
    @ResponseBody
    public List<DingDongProductVO> queryList(@ApiParam("productQuery")DingDongProductQuery query){

        return productService.queryList(query);
    }

}
