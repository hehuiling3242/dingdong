package com.dingdong.mapper;

import com.dingdong.domain.model.DingDongFile;
import com.dingdong.domain.query.DingDongFileQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface DingDongFileMapper {

    DingDongFile load(Long id);

    void insert(DingDongFile dingDongFile);

    void update(DingDongFile dingDongFile);

    void insertBatch(List<DingDongFile> dingDongFileList);

    List<DingDongFile> queryList(DingDongFileQuery query);

    int queryCount(DingDongFileQuery query);

}
