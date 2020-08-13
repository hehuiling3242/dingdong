package com.dingdong.domain.dto;

import com.dingdong.domain.model.PubRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.Serializable;

/**
*地区,邮编号码表实体列表
*/
public class PubRegionList extends ArrayList<PubRegion> implements Serializable{
    private static final long serialVersionUID = 15967597430385L;

    public PubRegionList() {
        super();
    }

    public PubRegionList(int size) {
        super(size);
    }

    public PubRegionList(List<PubRegion> list) {
        Collections.addAll(this, list.toArray(new PubRegion[]{}));
    }
}