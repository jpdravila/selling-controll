package io.github.jpdravila.impl;

import io.github.jpdravila.repository.PedidoRepository;
import io.github.jpdravila.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository repository;
    public PedidoServiceImpl(PedidoRepository repository){
        this.repository = repository;
    }

}
