package com.example.hotelbooking.service;

import com.example.hotelbooking.model.Booking;
import com.example.hotelbooking.dao.BookingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {
    @Autowired
    BookingRepo Booking;

    public List<Booking> getAllBooking() {
        return Booking.findAll();
    }

    public Optional<Booking> getBookingById(long id) {
        return Booking.findById(id);
    }
}