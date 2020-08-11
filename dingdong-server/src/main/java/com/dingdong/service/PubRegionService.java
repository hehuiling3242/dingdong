package com.dingdong.service;

import com.dingdong.domain.dto.PubRegionList;
import com.dingdong.domain.enums.PubRegionTypeEnum;
import com.dingdong.domain.model.PubRegion;
import com.dingdong.domain.query.PubRegionQuery;
import com.dingdong.mapper.PubRegionMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PubRegionService {

    @Autowired
    private PubRegionMapper pubRegionMapper;

    /**
     * 获取所有，层级关系存在
     *
     * @return
     */
    public List<PubRegion> getAllLevel() {

        PubRegionQuery query = new PubRegionQuery();
        List<PubRegion> regionList = pubRegionMapper.queryList(query);

        //转map
        Map<String, List<PubRegion>> regionMap = new HashMap<>();
        for (PubRegion region : regionList) {
            String parentCode = region.getParentCode();
            List<PubRegion> pubRegionList = new ArrayList<>();
            for (PubRegion r : regionList) {
                if (parentCode.equals(r.getParentCode())) {
                    pubRegionList.add(r);
                }
            }
            regionMap.put(parentCode, pubRegionList);
        }

        query.setRegionType(PubRegionTypeEnum.PROVINCE.getValue());
        List<PubRegion> provinceList = pubRegionMapper.queryList(query);
        PubRegionList pubRegionList = new PubRegionList();
        for (PubRegion province : provinceList) {
//            if (province.getRegionType().equals(PubRegionTypeEnum.PROVINCE.getValue())) {
            List<PubRegion> cityList = regionMap.get(province.getCode());
            if (!CollectionUtils.isEmpty(cityList)) {
                for (PubRegion city : cityList) {
                    city.setChildren(regionMap.get(city.getCode()));
                }
            }

            province.setChildren(cityList);
            pubRegionList.add(province);
//            }
        }
        return pubRegionList;
    }

    /**
     * 根据区级code获取全路径名称
     */
    public String queryFullForRegionCode(String regionCode,String fullName){
        if(null== regionCode){
            return StringUtils.EMPTY;
        }
        PubRegion pubRegion = pubRegionMapper.load(regionCode);
        if(PubRegionTypeEnum.PROVINCE.getValue().equals(pubRegion.getRegionType())){
            return fullName;
        }
        fullName = pubRegion.getRegionName() + fullName;
        this.queryFullForRegionCode(pubRegion.getParentCode(),fullName);
        return fullName;
    }
}
