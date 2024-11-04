package com.tareaJava.tareaJava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tareaJava.tareaJava.dto.ClienteDTO;
import com.tareaJava.tareaJava.mapper.ClientMapper;
import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.repository.ClienteRepositorio;

@Service
public class ClienteServiceImpl implements ClienteService{

    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    private final ClienteRepositorio clienteRepositorio;
    @Autowired
    private final ClientMapper clienteMapper;
    @Autowired
    private RestTemplate restTemplate;



    public ClienteServiceImpl(ClienteRepositorio clienteRepositorio, ClientMapper clienteMapper, RestTemplate restTemplate) {
        this.clienteRepositorio = clienteRepositorio;
        this.clienteMapper = clienteMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public ClienteDTO getUserById(Long id) {


        ClienteDTO cliente = restTemplate.getForObject(API_URL + "/{id}", ClienteDTO.class, id);
        this.clienteRepositorio.save(this.clienteMapper.toEntity(cliente));
        return cliente;
    }



    public ClienteDTO[] findAll() {
        return restTemplate.getForObject(API_URL, ClienteDTO[].class);
    }


    @Override
    public ClienteDTO createClient(ClienteDTO clienteDTO) {
        return null;
    } 

    @Override
    public void deleteUser(Long id) {
        
    }

    @Override
    public List<ClienteDTO> getAllClients() {
        return null;
    }



    @Override
    public void updateUser(Long id, ClienteDTO clienteDTO) {
        
    }

}
