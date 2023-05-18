package projetoteste.apispringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.entities.Venda;
import projetoteste.apispringboot.repository.VendaRepository;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> saveAll(List<Venda> listaDeVendas){
        return vendaRepository.saveAll(listaDeVendas);
    }
}
