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

            /*List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);*/

            boolean existe = clientes.existsByNome("Dougllas");
            System.out.println("Existe um cliente com o nome Dougllas? " + existe);

           /* System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.save(c);
            });

            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

              System.out.println("Buscando clientes");
              clientes.findByNomeLike("Cli").forEach(System.out::println);

              System.out.println("deletando clientes");
              clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });

            todosClientes = clientes.findAll();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
            }*/
    };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
