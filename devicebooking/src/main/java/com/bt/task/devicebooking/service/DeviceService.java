package com.bt.task.devicebooking.service;

import java.util.List;

import com.bt.task.devicebooking.data.entity.Phone;

public interface DeviceService {

	List<Phone> getAllPhones();
    Phone bookPhone(Long id, String bookedBy);
    Phone returnPhone(Long id);
    
}
