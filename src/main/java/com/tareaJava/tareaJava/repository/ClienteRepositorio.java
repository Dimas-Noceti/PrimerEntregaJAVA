package com.tareaJava.tareaJava.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.model.Domicilio;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {


    List<Cliente> findByNombre(String nombre);

    Cliente findByDni(long dni);
}
