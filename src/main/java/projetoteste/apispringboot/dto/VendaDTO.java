package projetoteste.apispringboot.dto;

import projetoteste.apispringboot.entities.ItemVenda;

import java.util.List;

public class VendaDTO {

    private Long vendedorId;

    private List<ItemVenda> listaDeItens;

    public VendaDTO(Long vendedorId, List<ItemVenda> listaDeItens) {
        this.vendedorId = vendedorId;
        this.listaDeItens = listaDeItens;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public List<ItemVenda> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<ItemVenda> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }
}
