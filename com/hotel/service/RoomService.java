package com.hotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

import jakarta.el.ELException;

import org.springframework.stereotype.Service;

@Service
public class RoomService {
    final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room newRoom) {
        return this.roomRepository.save(newRoom);
    }

    public List<Room> getRoomList() {
        return this.roomRepository.findAll();
    }

    public Optional<Room> getRoomByNumber(String roomNumber) {
        return this.roomRepository.findById(roomNumber);
    }

    public String deleteRoom(String roomNumber) {
        if(this.roomRepository.findById(roomNumber).isPresent()) {
            this.roomRepository.deleteById(roomNumber);
            return "room deleted";
        }else {
            return roomNumber.toString() + " isn't found in room list";
        }
    }
    
    public Room updateRoom(String roomNumber, Room newRoomInfo) {
        if(this.roomRepository.findById(roomNumber).isPresent()) {
            Room roomInfo = this.roomRepository.findById(roomNumber).get();
            roomInfo.setState(newRoomInfo.getState());
            roomInfo.setType(newRoomInfo.getType());
            roomInfo.setCost(newRoomInfo.getCost());

            return this.roomRepository.save(roomInfo);
        }else {
            throw new ELException(roomNumber.toString() + " isn't exist in room list");
        }
    }
}
