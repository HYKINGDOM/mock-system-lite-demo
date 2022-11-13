package com.java.meta.common.util;

import cn.hutool.core.util.RandomUtil;
import org.slf4j.MDC;

import static com.java.meta.common.constant.CommonConstant.DEFAULT_TRACE_ID;

public class TraceIdUtil {


    /**
     * 根据入参设置traceId
     *
     * @param traceId
     */
    public static void setTraceId(String traceId) {
        MDC.put(DEFAULT_TRACE_ID, traceId);
    }


    /**
     * 获取traceId
     *
     * @return
     */
    public static String getTraceId() {
        return MDC.get(DEFAULT_TRACE_ID);
    }

    /**
     * 生成traceId
     */
    public static void generateTraceId() {
        MDC.put(DEFAULT_TRACE_ID, randomTraceId());
    }


    private static String randomTraceId() {
        return RandomUtil.randomString("qazwsxedc12312312", 20);
    }

}
