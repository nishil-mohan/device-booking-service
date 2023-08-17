package com.bt.task.devicebooking.data.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bt.task.devicebooking.data.entity.Phone;

public interface DeviceRepository extends JpaRepository<Phone, Long> {
	
	@Modifying
	@Query("update Phone set alloted = true, bookedAt =:date, bookedBy = :bookedBy where id = :id and alloted=false")
	public Integer allotBooking(@Param("id") Long id, @Param("date") LocalDateTime date, @Param("bookedBy") String bookedBy);
}
