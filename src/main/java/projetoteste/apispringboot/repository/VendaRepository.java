package projetoteste.apispringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
