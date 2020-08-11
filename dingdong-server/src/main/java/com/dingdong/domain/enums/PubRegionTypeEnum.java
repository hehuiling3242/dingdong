package com.dingdong.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 地区
 */
public enum PubRegionTypeEnum{
    PROVINCE(2, "省"),
    CITY(3, "市"),
    REGION(4, "区"),
    //
    ;

    private static Map<Integer, PubRegionTypeEnum> pool = new HashMap<>();

    static {
        for (PubRegionTypeEnum each : PubRegionTypeEnum.values()) {
            PubRegionTypeEnum defined = pool.get(each.getValue());
            if (null != defined) {
                throw new IllegalArgumentException(defined.toString() + " defined as same code with "
                        + each.toString());
            }
            pool.put(each.getValue(), each);
        }
    }

    private Integer value;
    private String text;

    PubRegionTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static PubRegionTypeEnum valueOf(int value) {
        return pool.get(value);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}