package io.github.jpdravila.impl;

import io.github.jpdravila.domain.entity.Cliente;
import io.github.jpdravila.domain.entity.ItemPedido;
import io.github.jpdravila.domain.entity.Pedido;
import io.github.jpdravila.domain.entity.Produto;
import io.github.jpdravila.domain.entity.enums.StatusPedido;
import io.github.jpdravila.exceptions.PedidoNaoEncontradoException;
import io.github.jpdravila.exceptions.RegraNegocioException;
import io.github.jpdravila.repository.ClienteRepository;
import io.github.jpdravila.repository.ItemPedidoRepository;
import io.github.jpdravila.repository.PedidoRepository;
import io.github.jpdravila.repository.ProdutoRepository;
import io.github.jpdravila.rest.dto.ItemPedidoDTO;
import io.github.jpdravila.rest.dto.PedidoDTO;
import io.github.jpdravila.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;


    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        /*Terceiro início*/
        List<ItemPedido> itemPedidos = converterItems(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemPedidos);
        pedido.setItens(itemPedidos);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFetchItens(id);
    }

    @Override
    @Transactional
    public void ataualizaStatus(Integer id, StatusPedido statusPedido) {
         pedidoRepository.
                findById(id)
                .map(pedido ->{
                    pedido.setStatus((statusPedido));
                    return pedidoRepository.save(pedido);
                }).orElseThrow(() -> new PedidoNaoEncontradoException());
    }

    /*Novo início*/
    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possivel pedido sem itens");
        }
        return items.stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtoRepository.findById(idProduto)
                            .orElseThrow(() ->
                                    new RegraNegocioException("Código inválido." + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
