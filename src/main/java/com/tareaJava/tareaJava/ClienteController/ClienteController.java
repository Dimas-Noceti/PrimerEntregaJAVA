package com.tareaJava.tareaJava.ClienteController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareaJava.tareaJava.dto.ClienteDTO;
import com.tareaJava.tareaJava.services.ClienteServiceImpl;
import com.tareaJava.tareaJava.utils.ApiResponseMsg;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;



    @GetMapping("/all")
    public ResponseEntity<?> getAllClients() {
        try {
            ClienteDTO[] clientes = clienteService.findAll();
            return ResponseEntity.ok(new ApiResponseMsg("Ok", clientes));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponseMsg("Error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable("id") Long id) {
        try {
            ClienteDTO cliente = clienteService.getUserById(id);
            return ResponseEntity.ok(new ApiResponseMsg("Ok", cliente));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponseMsg("Error", e.getMessage()));
        }
    }

    @PutMapping("/{id}") 
    public ResponseEntity<?> getMethodName(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.updateUser(id, clienteDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    try {
        clienteService.deleteUser(id);
        return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new ApiResponseMsg("User delete", e.getMessage()));
    }
    }
} 
