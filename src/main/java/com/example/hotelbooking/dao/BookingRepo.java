package com.example.hotelbooking.dao;

import com.example.hotelbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    
}