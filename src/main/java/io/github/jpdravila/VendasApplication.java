package io.github.jpdravila;

import io.github.jpdravila.domain.entity.Cliente;
import io.github.jpdravila.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            clientes.salvar(new Cliente("Dougllas"));

            clientes.salvar(new Cliente("Outro cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
