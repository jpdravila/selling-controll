package io.github.jpdravila.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException() {
        super("Pedido não encontrado");
    }

}
