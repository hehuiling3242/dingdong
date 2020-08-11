package com.dingdong.service;

import com.dingdong.domain.model.Plan;
import com.dingdong.domain.model.Result;
import com.dingdong.domain.query.PlanQuery;
import com.dingdong.domain.vo.PlanVO;
import com.dingdong.mapper.PlanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PubRegionService pubRegionService;

    /**
     * 下单
     * @return
     */
    @Transactional
    public Result addPlan(Plan plan){
        Assert.notNull(plan,"订单不能为空");
        Assert.notNull(plan.getProductId(),"商品不能为空");
        Assert.notNull(plan.getUserId(),"下单人不能为空");
        Assert.notNull(plan.getDeliverAddress(),"收获地址不能为空");
        Assert.notNull(plan.getDeliverProvinceCode(),"收获地址不能为空");
        Assert.notNull(plan.getDeliverCityCode(),"收获地址不能为空");
        Assert.notNull(plan.getDeliverRegionCode(),"收获地址不能为空");

        planMapper.insert(plan);

        Result result = new Result();
        result.setCode("200");
        result.setMessage("下单成功");
        result.setData(plan);
        return result;
    }

    public List<PlanVO> queryList(PlanQuery query){
        List<Plan> planList = planMapper.queryList(query);
        if(CollectionUtils.isEmpty(planList)){
            return null;
        }

        List<PlanVO> planVOList = new ArrayList<>();
        PlanVO planVO;
        for (Plan plan : planList) {
            planVO = new PlanVO();
            BeanUtils.copyProperties(plan,planVO);
            planVO.setDelieverFullAddress(pubRegionService.queryFullForRegionCode(plan.getDeliverRegionCode(),""));
            planVOList.add(planVO);
        }

        return planVOList;
    }
}
