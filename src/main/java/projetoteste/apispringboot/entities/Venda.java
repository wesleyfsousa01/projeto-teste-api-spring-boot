package projetoteste.apispringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @OneToMany(mappedBy = "id.venda", fetch = FetchType.EAGER)
    private Set<ItemVenda> listaDeItens = new HashSet<>();

    public Venda() {
    }

    public Venda(LocalDateTime data, Vendedor vendedor) {
        this.data = data;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Set<ItemVenda> getListaDeItens() {
        return listaDeItens;
    }

    public Double getTotal(){
        double soma = 0;
        for(ItemVenda i: listaDeItens){
            soma += i.getPreco() * i.getQtd();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
