package projetoteste.apispringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.entities.ItemVenda;
import projetoteste.apispringboot.repositories.ItemVendaRepository;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public ItemVenda save(ItemVenda item){
        return itemVendaRepository.save(item);
    }

    public List<ItemVenda> saveAll(List<ItemVenda> listaDeItens){
        return itemVendaRepository.saveAll(listaDeItens);
    }
}
