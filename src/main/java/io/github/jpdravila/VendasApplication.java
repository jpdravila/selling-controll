package io.github.jpdravila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Olá mundo";

    }

    @Value("${application.name}")
    public String noName;

    @GetMapping("/bomdia")
    private String nome(){
        return noName;
    }



    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}
