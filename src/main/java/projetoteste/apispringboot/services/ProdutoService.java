package projetoteste.apispringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.repositories.ProdutoRepository;
import projetoteste.apispringboot.services.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }


    public Produto save(Produto produto){
       return produtoRepository.save(produto);
    }

    public List<Produto> saveAll(List<Produto> listaDeProdutos){
       return produtoRepository.saveAll(listaDeProdutos);
    }
}
