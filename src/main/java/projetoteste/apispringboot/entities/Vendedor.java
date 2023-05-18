package projetoteste.apispringboot.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Vendedor implements Serializable {

    private static final long serialVersionUID =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    List<Venda> listaDeVendas = new ArrayList<>();

    public Vendedor() {
    }

    public Vendedor(String name, String cpf, String email) {
        this.nome = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Venda> getListaDeVendas() {
        return listaDeVendas;
    }

    public Double getTotalDeVendasNoPeriodo(LocalDateTime min, LocalDateTime max){
        Duration intervalo = Duration.between(min,max);
        var intervaloEmDias = intervalo.toDays();

        double total = 0;
        for(Venda venda: listaDeVendas){
            if(venda.getData().isAfter(min) && venda.getData().isBefore(max))
                total += venda.getTotal();

        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(id, vendedor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
