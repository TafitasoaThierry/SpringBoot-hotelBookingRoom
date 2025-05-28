package com.hotel.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Personne {
    protected String nom;
    protected String prenoms;
    protected String email;
    protected String tel;
    protected String mdp;
}