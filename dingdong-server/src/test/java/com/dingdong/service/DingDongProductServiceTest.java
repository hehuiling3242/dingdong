package com.dingdong.service;

import com.alibaba.fastjson.JSON;
import com.dingdong.domain.model.DingDongProduct;
import com.dingdong.domain.query.DingDongProductQuery;
import com.dingdong.domain.vo.DingDongProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DingDongProductServiceTest {

    @Autowired
    private DingDongProductService dingDongProductService;

    @Test
    public void testQueryList() {
        DingDongProductQuery dingDongProductQuery = new DingDongProductQuery();
        List<DingDongProductVO> dingDongProductVOS = dingDongProductService.queryList(dingDongProductQuery);
        String toJSONString = JSON.toJSONString(dingDongProductVOS);
        System.out.println("---->> " + toJSONString);
    }

    @Test
    public void testLoad(){
        DingDongProduct dingDongProduct = dingDongProductService.load(1016L);
        String toJSONString = JSON.toJSONString(dingDongProduct);
        System.out.println("---->> " + toJSONString);
    }

}
