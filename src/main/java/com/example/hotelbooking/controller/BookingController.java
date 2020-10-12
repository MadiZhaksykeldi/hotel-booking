package com.example.hotelbooking.controller;

import com.example.hotelbooking.model.Booking;
import com.example.hotelbooking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingService service;

    @GetMapping(path = "/bookings")
    public List<Booking> getAllBooking() {
        return service.getAllBooking();
    }

    @GetMapping(path = "/bookings/{id}")
    public Optional<Booking> getBookingById(@PathVariable("id") long id) {
        return service.getBookingById(id);
    }
}