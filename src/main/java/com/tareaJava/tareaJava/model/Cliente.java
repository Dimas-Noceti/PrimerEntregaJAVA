package com.tareaJava.tareaJava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name = "users")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    private String name;
    private String email;
    private String phone;
    private String website;
    
}

