package com.synjones.cloudcard.permission.provider.aop;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MngOperLogAnnotation {
    String model(); //模块
    String describe(); //描述
    String bizType(); //业务类型
}
