package com.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Room")
@Getter
@Setter
public class Room {
    @Id
    private String roomNumber;
    private String state;
    private String type;
    private int cost;
}