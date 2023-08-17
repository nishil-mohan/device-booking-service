package com.bt.task.devicebooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.task.devicebooking.data.entity.Phone;
import com.bt.task.devicebooking.model.PhoneInfo;
import com.bt.task.devicebooking.service.DeviceInfoService;
import com.bt.task.devicebooking.service.DeviceService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class DeviceBookingController {

    private final DeviceService deviceService;
    private final DeviceInfoService deviceInfoService;


    public DeviceBookingController(DeviceService deviceService, DeviceInfoService deviceInfoService) {
        this.deviceService = deviceService;
        this.deviceInfoService = deviceInfoService;
    }

    @GetMapping("devices")
    @ApiOperation("Get list of all phones")
    public List<Phone> getAllPhones() {
        return deviceService.getAllPhones();
    }
    
    @GetMapping("device/info")
    @ApiOperation("Provides info about device")
    public PhoneInfo getPhoneInfo(@RequestParam(name = "deviceName")String deviceName) {
        return deviceInfoService.getPhoneInfo(deviceName);
    }

    @PostMapping("device/{id}/book")
    @ApiOperation("Book device")
    public Phone bookPhone(@PathVariable Long id, @RequestParam String bookedBy) {
        return deviceService.bookPhone(id, bookedBy);
    }

    @PostMapping("device/{id}/return")
    @ApiOperation("Return device")
    public Phone returnPhone(@PathVariable Long id) {
        return deviceService.returnPhone(id);
    }
}
