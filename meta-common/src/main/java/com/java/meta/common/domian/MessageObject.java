package com.java.meta.common.domian;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageObject {

    private Long id;

    private String traceId;

    private Object dataMessage;

    private String version;

    private LocalDateTime currentDateTime;




}

