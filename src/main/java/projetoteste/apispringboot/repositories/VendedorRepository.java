package projetoteste.apispringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoteste.apispringboot.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
}
