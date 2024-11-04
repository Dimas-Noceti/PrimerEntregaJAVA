package com.tareaJava.tareaJava.mapper;

import org.springframework.stereotype.Component;

import com.tareaJava.tareaJava.dto.ClienteDTO;
import com.tareaJava.tareaJava.model.Cliente;


@Component
public class ClientMapper {

    public ClienteDTO toDTO (Cliente cliente){
        if(cliente == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setName(cliente.getName());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setPhone(cliente.getPhone());
        clienteDTO.setWebsite(cliente.getWebsite());
        return clienteDTO;
    }

    public Cliente toEntity(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setName(clienteDTO.getName());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setPhone(clienteDTO.getPhone());
        cliente.setWebsite(clienteDTO.getWebsite());
        return cliente;
    }
} 