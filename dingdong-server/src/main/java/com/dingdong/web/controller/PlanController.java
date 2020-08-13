package com.dingdong.web.controller;

import com.dingdong.domain.model.Plan;
import com.dingdong.domain.model.Result;
import com.dingdong.domain.query.PlanQuery;
import com.dingdong.domain.vo.PlanVO;
import com.dingdong.service.PlanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单控制类
 */
@RestController
@RequestMapping("plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @ApiOperation(value = "下单")
    @PostMapping("add")
    @ResponseBody
    public Result addPlan(Plan plan){
        return planService.addPlan(plan);
    }

    @ApiOperation(value = "queryList")
    @GetMapping("query-list")
    @ResponseBody
    public List<PlanVO> queryList(PlanQuery planQuery){
        return planService.queryList(planQuery);
    }
}
