package projetoteste.apispringboot.entities.pk;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.Venda;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemVendaPK implements Serializable {

    private static final long serialVersionUID =1l;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Venda getVenda(){
        return venda;
    }

    public void setVenda(Venda venda){
        this.venda = venda;
    }

    public Produto getProduto(){
        return produto;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemVendaPK that = (ItemVendaPK) o;
        return Objects.equals(venda, that.venda) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venda, produto);
    }
}
