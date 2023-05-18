package projetoteste.apispringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoteste.apispringboot.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
