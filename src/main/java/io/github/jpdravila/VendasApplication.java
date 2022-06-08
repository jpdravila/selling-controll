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
            System.out.println("Salvando clientes...");
            clientes.salvar(new Cliente("Dougllas"));
            clientes.salvar(new Cliente("Outro Cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            /*System.out.println("Atualizando clientes...");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome()+ " atualizando...");
                clientes.atualizar(c);
            });
            System.out.println("Buscando clientes...");
            clientes.buscarPorNome("%Cli%").forEach(System.out::println);

            System.out.println("Deletando clientes...");
            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado...");
            } else{
            todosClientes.forEach(System.out::println);}*/
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
