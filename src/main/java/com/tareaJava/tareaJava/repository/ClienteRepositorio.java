package com.tareaJava.tareaJava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.model.Domicilio;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {


    
}
