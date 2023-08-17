package com.bt.task.devicebooking.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.task.devicebooking.data.entity.Phone;
import com.bt.task.devicebooking.data.repository.DeviceRepository;
import com.bt.task.devicebooking.exception.DeviceBookingException;
import com.bt.task.devicebooking.exception.DeviceNotFoundException;
import com.bt.task.devicebooking.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Phone> getAllPhones() {
        return deviceRepository.findAll();
    }

    @Override
    @Transactional
    public Phone bookPhone(Long id, String bookedBy) {
        var phone = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("1", "Device not found"));
        if (!phone.isAlloted()) {
        	var allotedTime = LocalDateTime.now();
        	//optimistic locking mechansim on alloted field. (Avoid concurrent updates)
            var alloted = deviceRepository.allotBooking(id, LocalDateTime.now(), bookedBy);
            if (alloted > 0) {
            	phone.setAlloted(true);
            	phone.setBookedAt(allotedTime);
            	phone.setBookedBy(bookedBy);
            	return phone;
            }
        }
            throw new DeviceBookingException("3", "Device is already booked by an user");
        }

    @Override
    @Transactional
    public Phone returnPhone(Long id) {
        Phone phone = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("1", "Phone not found"));

        if (phone.isAlloted()) {
            phone.setAlloted(false);
            phone.setBookedAt(null);
            phone.setBookedBy(null);
            return deviceRepository.save(phone);
        } else {
            throw new DeviceBookingException("3", "Phone is not booked by any user");
        }
    }
}

