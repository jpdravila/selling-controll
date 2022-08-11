package io.github.jpdravila.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import validation.NotEmptyList;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/* JSON código
{
    "cliente" : 1,
    "total" : 100,
    "items" : [
        {
            "produto" : 1,
            "quantidade" : 10
        }
    ]
}
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {

    @NotNull(message = "Informe o código do cliente")
    private Integer cliente;

    @NotNull(message = "Campo total do pedido é obrigatório")
    private BigDecimal total;

    @NotEmptyList(message = "Pedido não pode ser realizado sem itens")
    private List<ItemPedidoDTO> items;

}
