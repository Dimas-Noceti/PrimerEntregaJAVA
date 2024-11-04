package com.tareaJava.tareaJava.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tareaJava.tareaJava.model.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
