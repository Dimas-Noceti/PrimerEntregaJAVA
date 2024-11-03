package com.tareaJava.tareaJava.dto;


import lombok.Data;

@Data
public class ClienteDTO {

    private String nombre;
    private String apellido;
    private long dni;


    public ClienteDTO(String nombre, String apellido, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
}
