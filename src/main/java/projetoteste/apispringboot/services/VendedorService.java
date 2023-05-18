package projetoteste.apispringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.repositories.VendedorRepository;
import projetoteste.apispringboot.services.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor findById(Long id){
        return vendedorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public Vendedor save(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> saveAll(List<Vendedor> listaDeVendedores){
        return vendedorRepository.saveAll(listaDeVendedores);
    }


}
