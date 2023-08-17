package com.bt.task.devicebooking.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model; // e.g., Samsung Galaxy S9
    private boolean alloted; // Yes/No
    private LocalDateTime bookedAt; // When it was booked
    private String bookedBy; // Who booked the phone


    // Getters and setters
}

