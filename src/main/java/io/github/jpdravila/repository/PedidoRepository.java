package io.github.jpdravila.repository;

import io.github.jpdravila.domain.entity.Cliente;
import io.github.jpdravila.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


    List<Pedido> findByCliente( Cliente cliente );

}
