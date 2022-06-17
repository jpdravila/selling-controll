package io.github.jpdravila;

import io.github.jpdravila.domain.entity.Cliente;
import io.github.jpdravila.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner execultar(@Autowired ClienteRepository clientes){
        return args -> {
            Cliente c = new Cliente(null, "Joao Pedro");
            clientes.save(c);
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
