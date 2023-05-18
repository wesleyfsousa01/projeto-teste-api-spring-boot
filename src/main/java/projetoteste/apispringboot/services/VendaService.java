package projetoteste.apispringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetoteste.apispringboot.dto.VendaDTO;
import projetoteste.apispringboot.entities.Venda;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.repositories.VendaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired ItemVendaService itemVendaService;

    public Venda save(Venda venda){
        return vendaRepository.save(venda);
    }

    public List<Venda> saveAll(List<Venda> listaDeVendas){
        return vendaRepository.saveAll(listaDeVendas);
    }

    @Transactional
    public VendaDTO saveDTO(VendaDTO objDto){
        try {
            Vendedor vendedor = vendedorService.findById(objDto.getVendedorId());
            Venda venda = new Venda(LocalDateTime.now(), vendedor);
            vendaRepository.save(venda);

            var itensSalvos = objDto.getListaDeItens().stream().map(itemVenda -> {
                itemVenda.setVenda(venda);
                itemVenda.setProduto(produtoService.findById(itemVenda.getProduto().getId()));
                itemVenda.setPreco(itemVenda.getProduto().getPreco());
                return itemVenda;
            }).collect(Collectors.toList());

            itemVendaService.saveAll(itensSalvos);

            return new VendaDTO(vendedor.getId(), itensSalvos);

        } catch(RuntimeException ex){
            // TODO: LOGAR EXCEÇÃO
            throw ex;
        }
    }
}
