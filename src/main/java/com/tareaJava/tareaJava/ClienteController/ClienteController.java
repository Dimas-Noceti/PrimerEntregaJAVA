package com.tareaJava.tareaJava.ClienteController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> getAllClients() {
        return this.clienteService.getAllClientes();
    }

    @PostMapping("/create")
    public ResponseEntity<?> agregarPersona(@RequestBody Cliente cliente) {
        try {

            this.clienteService.creandoCliente(cliente);
            return ResponseEntity.ok(cliente);

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
            return ResponseEntity.status(400).body(e.getMessage());
            
        }
    }


    @GetMapping("/nombre")
    public ResponseEntity<?> buscarPersonaPorNombre(@RequestParam String nombre) {
        try {
            this.clienteService.buscarPorNombre(nombre);
            return ResponseEntity.ok(this.clienteService.buscarPorNombre(nombre));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

} 
