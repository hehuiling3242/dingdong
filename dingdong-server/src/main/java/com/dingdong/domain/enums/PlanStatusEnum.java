package com.dingdong.domain.enums;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

@ApiModel(value = "订单状态")
public enum PlanStatusEnum {

    WAIT_PAY(1,"待支付"),

    WAIT_DELEVER(2,"待收货"),

    WAIT_COMMENT(3,"待评论"),

    COMPLETE(4,"已完成"),
    ;

    private static Map<Integer,PlanStatusEnum> pool = new HashMap<>();

    static {
        for (PlanStatusEnum each : PlanStatusEnum.values()) {
            PlanStatusEnum defined = pool.get(each.getValue());
            if (null != defined) {
                throw new IllegalArgumentException(defined.toString() + " defined as same code with "
                        + each.toString());
            }
            pool.put(each.getValue(), each);
        }
    }
    PlanStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    private Integer value;
    private String text;

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static PlanStatusEnum valueOf(Integer value){
        PlanStatusEnum planStatusEnum = pool.get(value);
        if(null == planStatusEnum){
            throw new IllegalArgumentException("cannot find enum by value[" + value + "]");
        }

        return planStatusEnum;
    }
}
