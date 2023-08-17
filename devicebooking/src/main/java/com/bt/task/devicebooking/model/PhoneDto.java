package com.bt.task.devicebooking.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PhoneDto {

    private Long id;
    private String model; 
    private boolean alloted;
    private LocalDateTime bookedAt;
    private String bookedBy; 
    Integer version;

    // Getters and setters
}

