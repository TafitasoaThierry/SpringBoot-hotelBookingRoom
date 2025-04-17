package com.hotel.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person {
    protected String name;
    protected String surName;
    protected String email;
    protected String phone;
    protected String passWord;
}