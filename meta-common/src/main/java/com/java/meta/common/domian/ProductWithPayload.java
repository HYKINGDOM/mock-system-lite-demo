package com.java.meta.common.domian;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithPayload<T> {

    private String traceId;

    private String productName;

    private T payload;
}