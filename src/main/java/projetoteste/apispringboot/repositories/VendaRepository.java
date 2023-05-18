package projetoteste.apispringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoteste.apispringboot.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
