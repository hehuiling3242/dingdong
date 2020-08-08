package com.dingdong.service;

import com.dingdong.domain.model.DingDongProduct;
import com.dingdong.domain.query.DingDongProductQuery;
import com.dingdong.mapper.DingDongProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DingDongProductService {

    @Autowired
    private DingDongProductMapper dingDongProductMapper;

    public List<DingDongProduct> queryList(DingDongProductQuery query){
        List<DingDongProduct> dingDongProducts = dingDongProductMapper.queryList(query);
        return dingDongProducts;
    }
}
