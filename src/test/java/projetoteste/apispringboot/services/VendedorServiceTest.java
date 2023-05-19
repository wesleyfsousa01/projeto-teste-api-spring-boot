package projetoteste.apispringboot.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import projetoteste.apispringboot.dto.VendedorDTO;
import projetoteste.apispringboot.entities.ItemVenda;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.Venda;
import projetoteste.apispringboot.entities.Vendedor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public class VendedorServiceTest {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ItemVendaService itemVendaService;

    @Test
    public void findById(){
        Vendedor vendedor = new Vendedor("Pedro", "222.333.121-55","pedro@gmail.com");
        vendedorService.save(vendedor);

        Vendedor vendedorEncontrado = vendedorService.findById(vendedor.getId());

        Assert.assertEquals(vendedor.getId(), vendedorEncontrado.getId());
        Assert.assertEquals(vendedor.getNome(), vendedorEncontrado.getNome());
        Assert.assertEquals(vendedor.getEmail(), vendedorEncontrado.getEmail());
        Assert.assertEquals(vendedor.getCpf(), vendedorEncontrado.getCpf());
    }

    @Test
    public void save(){
        Vendedor vendedor = new Vendedor("Pedro", "222.333.121-55","pedro@gmail.com");
        Vendedor vendedorSalvo = vendedorService.save(vendedor);

        Assert.assertEquals(vendedor.getId(), vendedorSalvo.getId());
        Assert.assertEquals(vendedor.getNome(), vendedorSalvo.getNome());
        Assert.assertEquals(vendedor.getCpf(), vendedorSalvo.getCpf());
        Assert.assertEquals(vendedor.getEmail(), vendedorSalvo.getEmail());
    }

    @Test
    public void saveAll(){
        Vendedor vendedor1 = new Vendedor("Pedro","222.333.444-55","pedro@gmail.com");
        Vendedor vendedor2 = new Vendedor("Jose","222.333.777-88","jose@gmail.com");
        Vendedor vendedor3 = new Vendedor("Maria","222.333.111-00","maria@gmail.com");

        List<Vendedor> listaDeVendedores = Arrays.asList(vendedor1,vendedor2,vendedor3);

        List<Vendedor>listaDeVendedoresSalvos = vendedorService.saveAll(listaDeVendedores);

        Assert.assertEquals(listaDeVendedores,listaDeVendedoresSalvos);
    }

    //Este ultimo teste não rodou devido a um erro de relacionamento do JPA que não consegui resolver:
    @Test
    public void obterVendasPorPeriodo(){
        Vendedor vendedor = new Vendedor("Pedro","222.333.444-55","pedro@gmail.com");
        vendedorService.save(vendedor);

        Produto p1 = new Produto("Mouse",89d);
        Produto p2 = new Produto("teclado",129d);
        List<Produto> listaDeProdutos = new ArrayList<>(Arrays.asList(p1,p2));
        produtoService.saveAll(listaDeProdutos);

        Venda venda = new Venda(LocalDateTime.now(),vendedor);
        Venda venda2 = new Venda(LocalDateTime.now(),vendedor);
        List<Venda> listaDeVendas = Arrays.asList(venda,venda2);
        vendaService.saveAll(listaDeVendas);

        ItemVenda item1 = new ItemVenda(venda,p1,2,p1.getPreco());
        ItemVenda item2 = new ItemVenda(venda,p1,2,p1.getPreco());
        ItemVenda item3 = new ItemVenda(venda2,p2,2,p2.getPreco());
        ItemVenda item4 = new ItemVenda(venda2,p2,2,p2.getPreco());
        List<ItemVenda> listaDeitens = new ArrayList<>(Arrays.asList(item1,item2,item3,item4));
        itemVendaService.saveAll(listaDeitens);

        String minDate = LocalDate.now().toString();
        String maxDate = LocalDate.now().toString();

        List<VendedorDTO> listaDto = vendedorService.obterVendasPorPeriodo(minDate,maxDate);

        int totalDeVendas = 2;
        String mediaPordia = "436,00";

        for (VendedorDTO vendedorDto: listaDto){
            Assert.assertEquals(vendedor.getNome(),vendedorDto.getNome());
            Assert.assertEquals(mediaPordia,vendedorDto.getMediaVendasDia());
            Assert.assertEquals(totalDeVendas, (int) vendedorDto.getTotalDeVendas());

        }
    }


}
