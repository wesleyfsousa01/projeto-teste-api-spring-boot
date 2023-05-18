package projetoteste.apispringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.repository.VendedorRepository;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor save(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> saveAll(List<Vendedor> listaDeVendedores){
        return vendedorRepository.saveAll(listaDeVendedores);
    }


}
