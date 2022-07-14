package io.github.jpdravila.service;

import io.github.jpdravila.domain.entity.Pedido;
import io.github.jpdravila.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

}
