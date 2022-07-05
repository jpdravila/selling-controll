package io.github.jpdravila;

import io.github.jpdravila.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Autowired
    public ClienteRepository clientes;

    @Bean
    public CommandLineRunner eecultar(){
        return args -> {
          /*  Cliente cli1 = new Cliente(null, "Joao Pedro");
            Cliente cli2 = new Cliente(null, "José Carlos");
            Cliente cli3 = new Cliente(null, "Mateus Albulquerque");

            clientes.save(cli1);
            clientes.save(cli2);
            clientes.save(cli3);*/
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
