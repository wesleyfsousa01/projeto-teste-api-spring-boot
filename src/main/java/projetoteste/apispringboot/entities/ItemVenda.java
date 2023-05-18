package projetoteste.apispringboot.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import projetoteste.apispringboot.entities.pk.ItemVendaPK;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable {

    private static final long serialVersionUID =1l;

    @EmbeddedId
    private ItemVendaPK id;

    private Integer qtd;

    private Double preco;

    public ItemVenda() {
    }

    public ItemVenda(Venda venda, Produto produto,Integer qtd, Double preco) {
        this.id.setVenda(venda);
        this.id.setProduto(produto);
        this.qtd = qtd;
        this.preco = preco;
    }

    public Venda getVenda(){
        return id.getVenda();
    }

    public void setVenda(Venda venda){
        id.setVenda(venda);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ItemVendaPK getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return Objects.equals(id, itemVenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
