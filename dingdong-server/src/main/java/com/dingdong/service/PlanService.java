package com.dingdong.service;

import com.dingdong.domain.model.DingDongProduct;
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
import java.util.Date;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PubRegionService pubRegionService;
    @Autowired
    private DingDongProductService dingDongProductService;

    /**
     * 下单
     * @return
     */
    @Transactional
    public Result addPlan(Plan plan){
        Result result = new Result();

        if(null == plan){
            result.setCode("400");
            result.setMessage("请选择商品信息");
            return result;
        }
        if(null == plan.getProductId()){
            result.setCode("400");
            result.setMessage("请选择商品");
            return result;
        }
        if(null == plan.getUserId()){
            result.setCode("400");
            result.setMessage("下单人不能为空");
            return result;
        }
        if(null == plan.getDeliverAddress()){
            result.setCode("400");
            result.setMessage("请输入收获地址");
            return result;
        }
        if(null == plan.getDeliverRegionCode()){
            result.setCode("400");
            result.setMessage("请输入收获地址");
            return result;
        }
        if(null == plan.getDeliverProvinceCode()){
            result.setCode("400");
            result.setMessage("请输入收获地址");
            return result;
        }
        if(null == plan.getDeliverCityCode()){
            result.setCode("400");
            result.setMessage("请输入收获地址");
            return result;
        }
        if(null == plan.getPlanCount() || plan.getPlanCount()<0){
            result.setCode("400");
            result.setMessage("请输入购买数量");
            return result;
        }

        DingDongProduct product = dingDongProductService.load(plan.getProductId());
        if(null == product){
            result.setCode("400");
            result.setMessage("商品不存在");
            return result;
        }

        if(product.getCount() < plan.getPlanCount()){
            result.setCode("400");
            result.setMessage("该商品库存数量不够");
            return result;
        }
        plan.setProductName(product.getProductName());
        plan.setPlanDate(new Date());
        planMapper.insert(plan);

        //减去商品库存
        DingDongProduct dingDongProduct = new DingDongProduct();
        dingDongProduct.setId(plan.getProductId());
        dingDongProduct.setCount(product.getCount()-plan.getPlanCount());
        dingDongProductService.update(dingDongProduct);
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
            planVO.setDelieverFullAddress(pubRegionService.queryFullForRegionCode(plan.getDeliverRegionCode(),"") + plan.getDeliverAddress());
            planVOList.add(planVO);
        }

        return planVOList;
    }
}
