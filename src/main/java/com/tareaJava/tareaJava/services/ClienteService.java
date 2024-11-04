package com.tareaJava.tareaJava.services;

import java.util.List;

import com.tareaJava.tareaJava.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO getUserById (Long id);

    ClienteDTO createClient (ClienteDTO clienteDTO);

    List <ClienteDTO> getAllClients();

    void updateUser(Long id, ClienteDTO clienteDTO);

    void deleteUser(Long id);

}
