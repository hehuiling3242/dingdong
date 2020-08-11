package com.dingdong.mapper;

import com.dingdong.domain.model.DingDongProduct;
import com.dingdong.domain.query.DingDongProductQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DingDongProductMapper {

    DingDongProduct load(Long id);

    List<DingDongProduct> queryList(DingDongProductQuery query);
}
