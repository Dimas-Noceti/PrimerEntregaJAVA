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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;



    @GetMapping("/all")
    @Operation(summary = "Obtener todos los clientes", description = "Obtener todos los clientes")
    @ApiResponses(value = { 
        @ApiResponse (responseCode = "200", description = "Operacion existosa", content = @Content(schema = @Schema(implementation = ClienteDTO.class))),
        @ApiResponse (responseCode = "404", description = "Clientes no encontrados", content = @Content(schema = @Schema(implementation = ApiResponseMsg.class), examples = {
            @ExampleObject(name = "ClienteNoEncontradoEjemplo", value = "{\"message\": \"Cliente no encontrado\"}", description = "Clientes no encontrados")
        })),

    })
    

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

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Borrar a un cliente de la API", description = "Borra un usuario por su id")
    @ApiResponse(responseCode = "204", description = "Cliente borrado")
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    public ResponseEntity<?> deleteUser( 
        @Parameter(description = "ID del cliente que quiera borrar de la API") @PathVariable Long id){
    try {
        clienteService.deleteUser(id);
        return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new ApiResponseMsg("User delete", e.getMessage()));
    }
    }
} 
