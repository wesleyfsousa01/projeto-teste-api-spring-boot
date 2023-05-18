package projetoteste.apispringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoteste.apispringboot.entities.ItemVenda;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.pk.ItemVendaPK;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, ItemVendaPK> {
}
