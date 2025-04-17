package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.model.Admin;
import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.service.AdminService;
import com.hotel.service.BookingService;
import com.hotel.service.RoomService;

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
@RequestMapping("/hotel/admin")
public class AdminController {
    final AdminService adminService;
    final RoomService roomService;
    final BookingService bookingService;

    public AdminController(AdminService adminService, RoomService roomService, BookingService bookingService) {
        this.adminService = adminService;
        this.roomService = roomService;
        this.bookingService = bookingService;
    }
    
    /* 
     * use Admin service
     */
    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin newAdmin) {
        return ResponseEntity.ok(adminService.addAdmin(newAdmin));
    }

    @GetMapping("/getAdminList")
    public ResponseEntity<List<Admin>> getAdminList() {
        return ResponseEntity.ok(adminService.getAdminList());
    }

    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable String id) {
        return ResponseEntity.ok(this.adminService.getAdminById(id));
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String id) {
        return ResponseEntity.ok(this.adminService.deleteAdmin(id));
    }

    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin newAdminInfo) {
        return ResponseEntity.ok(this.adminService.updateAdmin(id, newAdminInfo));
    }

    /*
     * use Room service
     */
    @PostMapping("/addRoom")
    public ResponseEntity<Room> addRoom(@RequestBody Room newRoom) {
        return ResponseEntity.ok(this.roomService.addRoom(newRoom));
    }

    @GetMapping("/getRoomList")
    public ResponseEntity<List<Room>> getRoomList() {
        return ResponseEntity.ok(this.roomService.getRoomList());
    }

    @GetMapping("/getRoomByNumber/{roomNumber}")
    public ResponseEntity<Optional<Room>> getRoomByNumber(@PathVariable String roomNumber) {
        return ResponseEntity.ok(this.roomService.getRoomByNumber(roomNumber));
    }

    @DeleteMapping("/deleteRoom/{roomNumber}")
    public ResponseEntity<String> deleteRoom(@PathVariable String roomNumber) {
        return ResponseEntity.ok(this.roomService.deleteRoom(roomNumber));
    }

    @PutMapping("/updateRoom/{roomNumber}")
    public ResponseEntity<Room> updateRoom(@PathVariable String roomNumber, @RequestBody Room newRoomInfo) {
        return ResponseEntity.ok(this.roomService.updateRoom(roomNumber, newRoomInfo));
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
