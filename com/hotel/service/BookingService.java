package com.hotel.service;

import com.hotel.model.Booking;
import com.hotel.repository.BookingRepository;

import jakarta.el.ELException;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking makeBooking(Booking newBooking) {
        return this.bookingRepository.save(newBooking);
    }

    public List<Booking> getBookingList() {
        return this.bookingRepository.findAll();
    }

    public String deleteBooking(Long reference) {
        if(this.bookingRepository.findById(reference).isPresent()) {
            this.bookingRepository.deleteById(reference);
            return "booking deleted";
        }else {
            return reference.toString() + " isn't in booking list";
        }
    }

    public Booking updateBooking(Long reference, Booking bookingNewInfo) {
        if(this.bookingRepository.findById(reference).isPresent()) {
            Booking bookingInfo = this.bookingRepository.findById(reference).get();
            bookingInfo.setDate(bookingNewInfo.getDate());
            bookingInfo.setTime(bookingNewInfo.getTime());
            bookingInfo.setIsPaid(bookingNewInfo.getIsPaid());

            return this.bookingRepository.save(bookingInfo);
        }else {
            throw new ELException(reference.toString() + " isn't in booking list");
        }
    }
}
