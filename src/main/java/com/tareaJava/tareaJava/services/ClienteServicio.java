package com.tareaJava.tareaJava.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.model.Domicilio;
import com.tareaJava.tareaJava.repository.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicio { 

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> getAllClientes() {
        return clienteRepositorio.findAll();
    }



    public void creandoCliente(Cliente c) {
        this.clienteRepositorio.save(c);
    }


}
