package com.java.meta.annonation;

import com.java.meta.constant.BusinessType;

import java.lang.annotation.*;

/**
 * @author 胡毅
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD }) // 注解放置的目标位置,PARAMETER: 可用在参数上  METHOD：可用在方法级别上
@Retention(RetentionPolicy.RUNTIME)    // 指明修饰的注解的生存周期  RUNTIME：运行级别保留
@Documented
public @interface LogPrint {


    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;

}
