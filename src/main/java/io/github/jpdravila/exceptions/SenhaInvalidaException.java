package io.github.jpdravila.exceptions;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException(){
        super("Senha inválida");
    }

}
