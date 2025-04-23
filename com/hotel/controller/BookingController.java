package com.hotel.controller;

import java.util.List;

import com.hotel.model.Booking;
import com.hotel.service.BookingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel/booking")
public class BookingController {
    final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * use Booking service
     */
    @PostMapping("/makeBooking")
    public ResponseEntity<Booking> makeBooking(@RequestBody Booking newBooking) {
        return ResponseEntity.ok(this.bookingService.makeBooking(newBooking));
    }

    @GetMapping("/getBookingList")
    public ResponseEntity<List<Booking>> getBookingList() {
        return ResponseEntity.ok(this.bookingService.getBookingList());
    }

    @DeleteMapping("/deleteBooking/{reference}")
    public ResponseEntity<String> deleteooking(@PathVariable Long referene) {
        return ResponseEntity.ok(this.bookingService.deleteBooking(referene));
    }

    @PutMapping("/updateBooking/{reference}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long reference, @RequestBody Booking newBookingInfo) {
        return ResponseEntity.ok(this.bookingService.updateBooking(reference, newBookingInfo));
    }
}