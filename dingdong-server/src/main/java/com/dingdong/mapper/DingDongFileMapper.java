package com.dingdong.mapper;

import com.dingdong.domain.model.DingDongFile;
import com.dingdong.domain.query.DingDongFileQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DingDongFileMapper {

    //根据id查询
    DingDongFile load(Long id);

    //插入
    void insert(DingDongFile dingDongFile);

    void update(DingDongFile dingDongFile);

    //批量插入
    void insertBatch(List<DingDongFile> dingDongFileList);

    //根据query对象查询
    List<DingDongFile> queryList(DingDongFileQuery query);

    //查询条数
    int queryCount(DingDongFileQuery query);

}
