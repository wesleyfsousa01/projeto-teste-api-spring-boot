package projetoteste.apispringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.repository.ProdutoRepository;
import projetoteste.apispringboot.repository.VendedorRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto){
       return produtoRepository.save(produto);
    }

    public List<Produto> saveAll(List<Produto> listaDeProdutos){
       return produtoRepository.saveAll(listaDeProdutos);
    }
}
