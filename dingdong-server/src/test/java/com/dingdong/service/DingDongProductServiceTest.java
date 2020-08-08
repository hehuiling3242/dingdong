package com.dingdong.service;

import com.alibaba.fastjson.JSON;
import com.dingdong.domain.model.DingDongProduct;
import com.dingdong.domain.query.DingDongProductQuery;
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
        List<DingDongProduct> dingDongProducts = dingDongProductService.queryList(dingDongProductQuery);
        String toJSONString = JSON.toJSONString(dingDongProducts);
        System.out.println("---->> " + toJSONString);
    }

}
