package io.github.jpdravila.service;

import io.github.jpdravila.domain.entity.Pedido;
import io.github.jpdravila.domain.entity.enums.StatusPedido;
import io.github.jpdravila.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void ataualizaStatus(Integer id, StatusPedido statusPedido);

}
