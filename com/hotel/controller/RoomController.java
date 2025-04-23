package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.model.Room;
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
@RequestMapping("/hotel/room")
public class RoomController {
    final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
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
}
