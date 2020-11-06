package com.example.hotelbooking.controller;

import com.example.hotelbooking.model.Booking;
import com.example.hotelbooking.service.BookingService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @HystrixCommand(fallbackMethod = "getFallbackBooking",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }
    )
    @GetMapping(path = "/bookings/{id}")
    public Optional<Booking> getBookingById(@PathVariable("id") long id) {
        return service.getBookingById(id);
    }

    public List<Booking> getFallbackBooking(@PathVariable("id") long id){
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking());
        return bookingList;
    }
}