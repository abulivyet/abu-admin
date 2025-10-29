package com.abulivyet.abuadmin.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义操作日志注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /** 日志标题 */
    String title() default "";

    /** 业务类型，例如 INSERT、UPDATE、DELETE、OTHER */
    BusinessType businessType() default BusinessType.OTHER;
}
