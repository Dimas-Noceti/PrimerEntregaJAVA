package com.tareaJava.tareaJava.mapper;

import org.springframework.stereotype.Component;

import com.tareaJava.tareaJava.dto.ClienteDTO;
import com.tareaJava.tareaJava.model.Cliente;


@Component
public class ClientMapper {


    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }

        ClienteDTO clienteDTO = new ClienteDTO(null, null, 0);
        return clienteDTO;
    }

    public Cliente toEntity(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }

        Cliente cliente = new Cliente();
        return cliente;
    }
    
} 