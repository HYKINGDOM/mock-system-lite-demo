package com.java.metaadmin.domian;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RocketMqMessage {
    private Long id;
    private String message;
    private String version;

    private LocalDate currentDate;
    private LocalDateTime currentDateTime;
}

