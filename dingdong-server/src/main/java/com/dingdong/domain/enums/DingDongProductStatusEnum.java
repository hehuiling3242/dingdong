package com.dingdong.domain.enums;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品状态枚举
 * @author pjl
 * @since 2020/08/07
 */

@ApiModel(value = "商品状态枚举")
public enum DingDongProductStatusEnum{

    NORMAL(1,"正常"),

    REMOVE_SHELVES(2,"已下架"),

    ULTIMATE(3,"已告馨"),

    ;

    private static Map<Integer,DingDongProductStatusEnum> pool = new HashMap();

    static {
        for (DingDongProductStatusEnum each : DingDongProductStatusEnum.values()) {
            DingDongProductStatusEnum defined = pool.get(each.getValue());
            if (null != defined) {
                throw new IllegalArgumentException(defined.toString() + " defined as same code with "
                        + each.toString());
            }
            pool.put(each.getValue(), each);
        }
    }

    private Integer value;
    private String text;

    DingDongProductStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static DingDongProductStatusEnum valueOf(Integer value){
        DingDongProductStatusEnum dingDongProductStatusEnum = pool.get(value);
        if(null == dingDongProductStatusEnum){
            throw new IllegalArgumentException("cannot find enum by value[" + value + "]");
        }

        return dingDongProductStatusEnum;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }



}
