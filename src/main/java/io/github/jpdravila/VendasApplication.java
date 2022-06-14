package io.github.jpdravila;

import io.github.jpdravila.domain.entity.Cliente;
import io.github.jpdravila.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Dougllas"));
            clientes.save(new Cliente("Outro Cliente"));
    };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
