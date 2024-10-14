package com.tareaJava.tareaJava.services;

import java.util.List;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.model.Domicilio;
import com.tareaJava.tareaJava.repository.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService { 

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> getAllClientes() {
        return clienteRepositorio.findAll();
    }



    public void creandoCliente(Cliente cliente) {
        Cliente c = this.clienteRepositorio.findByDni(cliente.getDni());
        if(c != null) {
            throw new IllegalIdentifierException("El cliente ya existe");
        }
        this.clienteRepositorio.save(cliente);
    }


}
