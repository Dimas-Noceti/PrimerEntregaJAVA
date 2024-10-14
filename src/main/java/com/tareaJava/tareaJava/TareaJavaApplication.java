package com.tareaJava.tareaJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tareaJava.tareaJava.model.Cliente;
import com.tareaJava.tareaJava.model.Domicilio;
import com.tareaJava.tareaJava.services.ClienteService;

@SpringBootApplication
public class TareaJavaApplication implements CommandLineRunner{

	@Autowired
	private ClienteService clienteServicio;

	public static void main(String[] args) {
		SpringApplication.run(TareaJavaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Mostramos todos los clientes");
		for (Cliente c : this.clienteServicio.getAllClientes()) {
			System.out.println(c);
		}

		System.out.println("Creamos un cliente");
		this.clienteServicio.creandoCliente(new Cliente("Dimas", "Noceti", 47401886));;

	}

}
